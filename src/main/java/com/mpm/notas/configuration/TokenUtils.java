package com.mpm.notas.configuration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenUtils {

    @Value("${jwt.secret}")   
    private final static String ACCESS_TOKEN_SECRET = "secretgggdgdgdhhdgsgreyyyyshhshshs";
    
    @Value("${jwt.expiration}")   
    private final static long ACCESS_VALIDATY_SECONDS = 120;


    public static String createToken(String nombre, String username){
        long expirationTime = ACCESS_VALIDATY_SECONDS * 1000;

        long timeInMillis = GregorianCalendar.getInstance().getTimeInMillis();
        
        Date expirationDate = new Date(timeInMillis + expirationTime);

        Map<String, Object> extra = new HashMap();
        extra.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken gAuthentication(String token){

        try{
            Claims claims = Jwts.parserBuilder()
            .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();

            String username = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());


        } catch (JwtException e){
            e.printStackTrace();
            return null;
        }
    }
}
