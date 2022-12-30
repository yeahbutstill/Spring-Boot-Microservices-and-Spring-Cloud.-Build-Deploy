package com.yeahbutstill.app.ws.exceptions;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceExceptionSymflowerTest {
	@Test
	public void UserServiceException1() {
		String message = null;
		UserServiceException expected = new UserServiceException(null);
		UserServiceException actual = new UserServiceException(message);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}
}
