package com.yeahbutstill.photoapp.api.users.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequestModel {

	@NotNull
	@NotEmpty
	@NotBlank
	private String email;

	@NotNull
	@NotBlank
	@NotEmpty
	private String password;

}
