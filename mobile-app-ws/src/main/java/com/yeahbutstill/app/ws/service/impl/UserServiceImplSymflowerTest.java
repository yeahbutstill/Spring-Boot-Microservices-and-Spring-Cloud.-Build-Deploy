package com.yeahbutstill.app.ws.service.impl;

import com.yeahbutstill.app.ws.ui.model.request.UserDetailsRequestModel;
import com.yeahbutstill.app.ws.ui.model.response.UserRest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceImplSymflowerTest {
	@Test
	public void createUser1() {
		UserServiceImpl u = null; // TODO This is a fallback value due to incomplete analysis.
		UserDetailsRequestModel userDetailsRequestModel = null; // TODO This is a fallback value due to incomplete analysis.
		UserRest expected = null; // TODO This is a fallback value due to incomplete analysis.
		UserRest actual = u.createUser(userDetailsRequestModel);

		assertEquals(expected, actual);
	}
}
