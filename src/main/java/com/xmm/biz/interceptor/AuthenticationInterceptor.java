package com.xmm.biz.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xmm.biz.constant.ResultValueEnum;
import com.xmm.biz.service.AdminUserService;
import com.xmm.biz.target.PassToken;
import com.xmm.biz.target.TestApi;
import com.xmm.biz.target.UserForgetToken;
import com.xmm.biz.target.UserLoginToken;
import com.xmm.biz.util.TokenUtil;
import com.xmm.biz.vo.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 全局拦截,token验证
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Value("${jwttoken.key}")
    private String JWTTokenKey;

    @Value("${swagger.testApi}")
    private boolean testApiState;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getParameter("token");// 从 http 请求参数中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        // 检查是否有TestApi注释，有则验证测试接口是否开启
        if (method.isAnnotationPresent(TestApi.class)) {
            TestApi testApi = method.getAnnotation(TestApi.class);
            if (!testApi.required() || !testApiState) {
                returnBaseResultError(httpServletResponse, ResultValueEnum.SYS_API_IS_STOP);
                return false;
            }
        }
        // 检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 检查有没有需要用户登录权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {// 需要执行认证
                if (token == null) {//无token,需重新登录
                    returnBaseResultError(httpServletResponse, ResultValueEnum.SYS_TOKEN_NULL);
                    return false;
                }
                // 验证 token
                boolean verify_bool = tokenUtil.verifyTokenByLogin(token);
                if(!verify_bool){
                    returnBaseResultError(httpServletResponse, ResultValueEnum.SYS_TOKEN_ANOMALY);
                    return false;
                }
                if(!userLoginToken.powerName().equals("")){
                    //查询用户是否拥有接口所需的权限
                    DecodedJWT jwt = JWT.decode(token);
                    String userId = jwt.getAudience().get(0);
                    boolean have_power = adminUserService.checkUserPower(Long.valueOf(userId), userLoginToken.powerName());
                    if(!have_power){
                        returnBaseResultError(httpServletResponse, ResultValueEnum.SYS_USER_NOT_HAVE_POWER);
                        return false;
                    }
                }
            }
        }
        // 检查有没有需要用户忘记密码权限的注解
        if (method.isAnnotationPresent(UserForgetToken.class)) {
            UserForgetToken userForgetToken = method.getAnnotation(UserForgetToken.class);
            if (userForgetToken.required()) {// 需要执行认证
                if (token == null) {//无token,需重新登录
                    returnBaseResultError(httpServletResponse, ResultValueEnum.SYS_TOKEN_NULL);
                    return false;
                }
                // 验证 token
                boolean verify_bool = tokenUtil.verifyTokenByChangePassword(token);
                if(!verify_bool){
                    returnBaseResultError(httpServletResponse, ResultValueEnum.SYS_TOKEN_ANOMALY);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 组装验证未通过的直接返回信息
     */
    private void returnBaseResultError(HttpServletResponse httpServletResponse, ResultValueEnum resultValueEnum) {
        BaseResult<String> baseResult = BaseResult.newInstance();
        baseResult.setResultValueEnum(resultValueEnum);
        String jsonObjectStr = JSONObject.toJSONString(baseResult);
        returnJson(httpServletResponse,jsonObjectStr);
    }

    /**
     * 组装直接返回信息
     */
    private void returnJson(HttpServletResponse response, String json) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
