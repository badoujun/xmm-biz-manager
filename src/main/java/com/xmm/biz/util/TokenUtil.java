package com.xmm.biz.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xmm.biz.constant.SystemConstant;
import com.xmm.biz.pojo.AdminUser;
import com.xmm.biz.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

/**
 * token工具类
 */
@Component
public class TokenUtil {

    @Value("${jwttoken.key}")
    private String JWTTokenKey;

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 根据userId生成token,用以判断user是否登录
     */
    public String createTokenByLogin(long userId){
        String token = "";
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        token = JWT.create()
                .withAudience(String.valueOf(userId))
                .withIssuedAt(now)
                .withClaim(SystemConstant.TOKEN_PURPOSE, SystemConstant.IS_LOGIN)
                .sign(Algorithm.HMAC256(JWTTokenKey));
        return token;
    }

    /**
     * 验证根据userId生成的token,用以判断user是否登录
     */
    public boolean verifyTokenByLogin(String token){
        return currencyVerify(token,SystemConstant.TOKEN_PURPOSE,SystemConstant.IS_LOGIN);
    }

    /**
     * 根据userId生成token,用以判断user是否通过忘记密码验证
     */
    public String createTokenByChangePassword(long userId){
        String token = "";
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        token = JWT.create()
                .withAudience(String.valueOf(userId))
                .withIssuedAt(now)
                .withClaim(SystemConstant.TOKEN_PURPOSE, SystemConstant.CHANGE_PASSWORD)
                .sign(Algorithm.HMAC256(JWTTokenKey));
        return token;
    }

    /**
     * 验证根据userId生成的token,用以判断user是否通过忘记密码验证
     */
    public boolean verifyTokenByChangePassword(String token){
        return currencyVerify(token,SystemConstant.TOKEN_PURPOSE,SystemConstant.CHANGE_PASSWORD);
    }

    /**
     * 通用常规token验证
     */
    private boolean currencyVerify(String token,String token_purpose_key,String token_purpose_val){
        try {
            // 验证 token 密匙
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWTTokenKey)).build();
            jwtVerifier.verify(token);

            DecodedJWT jwt = JWT.decode(token);

            // 验证 token 用途
            Map<String, Claim> claims = jwt.getClaims();
            Claim claim = claims.get(token_purpose_key);
            String val = claim.asString();
            if(!val.equals(token_purpose_val)){
                return false;
            }
            // 获取 token 中的 userId
            String userId = jwt.getAudience().get(0);
            // 查询用户是否存在,以及验证用户状态
            AdminUser user = adminUserService.findById(Long.valueOf(userId));
            if (user == null || user.getState() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
