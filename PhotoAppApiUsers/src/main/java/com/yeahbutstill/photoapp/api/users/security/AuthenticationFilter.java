package com.yeahbutstill.photoapp.api.users.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeahbutstill.photoapp.api.users.exceptions.AuthenticationFilterException;
import com.yeahbutstill.photoapp.api.users.model.request.LoginRequestModel;
import com.yeahbutstill.photoapp.api.users.service.UsersService;
import com.yeahbutstill.photoapp.api.users.shared.UserDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final UsersService usersService;
	private final Environment environment;
	
	public AuthenticationFilter(UsersService usersService,
                                Environment environment,
                                AuthenticationManager authenticationManager) {

		this.usersService = usersService;
		this.environment = environment;
		super.setAuthenticationManager(authenticationManager);

	}
	
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {

        try {
            LoginRequestModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginRequestModel.class);
            
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new AuthenticationFilterException("A authentication filter exception is thrown");
        }

    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

    	String userName = ((User) auth.getPrincipal()).getUsername();
    	UserDto userDetails = usersService.getUserDetailsByEmail(userName);

        String token = Jwts.builder()
                .setSubject(userDetails.getUserId())
                .setExpiration(new Date(System.currentTimeMillis() +
                        Long.parseLong(Objects.requireNonNull(environment.getProperty("token.expiration_time")))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret") )
                .compact();

        res.addHeader("token", token);
        res.addHeader("userId", userDetails.getUserId());

    }

}
