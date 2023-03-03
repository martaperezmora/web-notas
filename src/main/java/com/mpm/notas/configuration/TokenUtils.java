package com.mpm.notas.configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Configuration
public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "AAKSDHASDHKJADHKJASDH";
    private final static long ACCESS_VALIDATY_SECONDS = 120;  // tiempo de expiracion en segundos

    // metodo para crear token
    public static String createToken(String nombre, String username){

        long expirationTime = ACCESS_VALIDATY_SECONDS * 1000;                   // el tiempo de segundos a milisegundos
        long timeInMillis = GregorianCalendar.getInstance().getTimeInMillis();  // tiempo actual en milisegundos
        Date expirationDate = new Date(timeInMillis + expirationTime);

        Map<String, Object> extra = new HashMap<String, Object>();
        extra.put("nombre", nombre);

        String token = Jwts.builder()  // se construye un token
            .setSubject(username)
            .setExpiration(expirationDate)
            .addClaims(extra)
            .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
            .compact();

        return token;
    }

    // metodo para recoger token
    public static UsernamePasswordAuthenticationToken gAuthenticationToken(String token){

        Claims claims = Jwts.parserBuilder()
            .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();

        String username = claims.getSubject();

        return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
    }
}
