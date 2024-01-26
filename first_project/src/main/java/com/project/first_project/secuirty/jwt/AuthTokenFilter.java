package com.project.first_project.secuirty.jwt;

import com.project.first_project.secuirty.UserDetailServiceImplimentation;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailServiceImplimentation userDetailServiceImplimentation;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          try {
              String jwt=parseJwtFromHeader(request);

              if (jwt!=null && jwtUtils.validateToken(jwt)){
                  String username=jwtUtils.getUsernameFromToken(jwt);

                  UserDetails userDetails=userDetailServiceImplimentation.loadUserByUsername(username);// exracting username and password from database

                  UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                   token.setDetails(new WebAuthenticationDetails(request));

                  SecurityContextHolder.getContext().setAuthentication(token);

              }
          }catch (Exception e){
              System.err.println(e);
          }
          filterChain.doFilter(request,response);
    }

    private  String parseJwtFromHeader(HttpServletRequest request){
        String authHeader=request.getHeader("Authorization");

        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")) {
            return authHeader.substring(7);
        }else {
            return null;
        }
    }
}
