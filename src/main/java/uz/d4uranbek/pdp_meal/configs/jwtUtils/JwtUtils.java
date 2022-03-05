package uz.d4uranbek.pdp_meal.configs.jwtUtils;

import com.auth0.jwt.JWT;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;


import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Elyor Ergashov
 *
 * @author : mreed
 * @date : 3/4/2022
 * @project : mealDeliver
 */

public class JwtUtils {
    private static Integer expiry = 600_000;
    public static String secretKey = "ASDQW#@!$#@%$#DSFSDFRT%$#%34543terg45%^%$";

    public static Date getExpiry() {
        return new Date(System.currentTimeMillis() + expiry);
    }

    public static Date getRefreshToken() {
        return new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30));
    }

    public static Algorithm getAlgorithms() {
        return Algorithm.HMAC256(secretKey.getBytes());
    }
    public static JWTVerifier getVerify(){
        return JWT.require(getAlgorithms()).build();
    }


}
