package com.ortiz.jonathan.security.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

/*1*/
@Component
public class JwtUtil {


    /*CREA LA CLAVE SECRETA EN EL FORMATO CORRECTO*/
    static SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    static String base64EncodedSecret = Base64.getEncoder().encodeToString(secretKey.getEncoded());

    static String secret = System.getenv("SECRET_KEY") != null ? System.getenv("SECRET_KEY") : base64EncodedSecret;


    /*PARA VER LA CLAVE SECRETA EN EL TERMINAL*/
    public static void main(String[] args) {
        System.out.println(base64EncodedSecret);
        System.out.printf(secret);
    }

//    static String base64Key = System.getenv("SECRET_KEY");  // Clave inicial
//
//
//    static String secret = System.getenv("SECRET_KEY") != null && !System.getenv("SECRET_KEY").isEmpty()
//            ? System.getenv("SECRET_KEY")
//
//            : Base64.getEncoder().encodeToString(base64Key.getBytes());


   /* private void quien() {
        while (base64Key.getBytes().length < 32) {
            base64Key += "a"; 
        }
    }*/

    /*public static void main(String[] args) {
        System.out.println(secret);
        System.out.println(base64Key);
    }*/

    private final long expiration = 3600000;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims validateToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
