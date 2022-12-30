package com.yeahbutstill.photoapp.api.users.security;

import com.yeahbutstill.photoapp.api.users.service.UsersService;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthenticationFilterSymflowerTest {
	@Test
	public void AuthenticationFilter1() {
		UsersService usersService = null; // TODO This is a fallback value due to incomplete analysis.
		Environment environment = null; // TODO This is a fallback value due to incomplete analysis.
		AuthenticationManager authenticationManager = null; // TODO This is a fallback value due to incomplete analysis.
		AuthenticationFilter expected = null; // TODO This is a fallback value due to incomplete analysis.
		AuthenticationFilter actual = new AuthenticationFilter(usersService, environment, authenticationManager);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	@Test
	public void attemptAuthentication2() throws AuthenticationException {
		AuthenticationFilter a = null; // TODO This is a fallback value due to incomplete analysis.
		HttpServletRequest req = null; // TODO This is a fallback value due to incomplete analysis.
		HttpServletResponse res = null; // TODO This is a fallback value due to incomplete analysis.
		Authentication expected = null; // TODO This is a fallback value due to incomplete analysis.
		Authentication actual = a.attemptAuthentication(req, res);

		assertEquals(expected, actual);
	}

	@Test
	public void successfulAuthentication3() throws IOException, ServletException {
		AuthenticationFilter a = null; // TODO This is a fallback value due to incomplete analysis.
		HttpServletRequest req = null; // TODO This is a fallback value due to incomplete analysis.
		HttpServletResponse res = null; // TODO This is a fallback value due to incomplete analysis.
		FilterChain chain = null; // TODO This is a fallback value due to incomplete analysis.
		Authentication auth = null; // TODO This is a fallback value due to incomplete analysis.
		a.successfulAuthentication(req, res, chain, auth);
	}
}
