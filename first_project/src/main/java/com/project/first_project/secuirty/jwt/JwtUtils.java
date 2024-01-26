package com.project.first_project.secuirty.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${app.secret}")
    private  String secret;

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }
    public String generateJwtToken(Authentication authentication){
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+864000000))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String jwtToken) {
         try {
             Jwts.parserBuilder().setSigningKey(key()).build().parse(jwtToken);
             return true;
         }catch (MalformedJwtException e){  //malformed exception==change the signature(app.secret sentence)
             System.err.println("Token has been changed.Invalid");
         }catch (ExpiredJwtException e){
             System.err.println("Token is expired");
         }catch (UnsupportedJwtException e){
             System.err.println("Unsupported Token");
         }catch (IllegalArgumentException e){
             System.err.println("Blank Token");
         }
         return false;
    }

    public String getUsernameFromToken(String jwtToken) {
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(jwtToken).getBody().getSubject();
    }
}
