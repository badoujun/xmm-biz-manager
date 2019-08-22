package com.xmm.biz.interceptor;

import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用户登录信息过滤器
 */
@Component
@WebFilter(urlPatterns = "/*")
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        RequestParameterWrapper requestParameterWrapper = new RequestParameterWrapper(httpServletRequest);
        try {
            String token = httpServletRequest.getParameter("token");
            if(token != null && token != "") {//入参存在token,则将token中包含的userId加入入参,过滤器不做token判断和user是否存在判断,交由拦截器进行判断
                String userId = JWT.decode(token).getAudience().get(0);
                requestParameterWrapper.addParameter("userId",userId);
                String username = JWT.decode(token).getAudience().get(1);
                requestParameterWrapper.addParameter("username",username);
            }
        }catch (Exception e){

        }
        chain.doFilter(requestParameterWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
