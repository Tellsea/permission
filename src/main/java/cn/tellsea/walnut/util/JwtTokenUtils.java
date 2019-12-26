package cn.tellsea.walnut.util;

import cn.tellsea.permission.system.entity.UserInfo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Jwt token 工具类
 *
 * @author: Tellsea
 * @date : 2019/12/23
 */
@Slf4j
public class JwtTokenUtils {

    /**
     * 过期时间
     */
    private static final long EXPIRE_TIME = 10 * 60 * 60 * 1000;
    private static final String TOKEN_SECRET = "permission";

    /**
     * 签名生成
     *
     * @param userName
     * @return
     */
    public static String sign(String userName) {
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", userName)
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
            log.info("JwtTokenUtils sign 用户名：{}", userName);
            log.info("JwtTokenUtils sign 生成签名：{}", token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 签名验证
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            log.info("JwtTokenUtils verify 认证通过：{}", jwt.getClaim("username").asString());
            log.info("JwtTokenUtils verify 过期时间：{}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(jwt.getExpiresAt()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String token = sign("tellsea");
        System.out.println(token);
        boolean verify = verify(token);
        System.out.println(verify);
    }
}
