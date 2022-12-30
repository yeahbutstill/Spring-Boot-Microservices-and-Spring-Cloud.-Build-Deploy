package com.yeahbutstill.photoapp.api.users.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserResponseModel {

	@NotBlank
	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	@NotBlank
	private String lastName;

	@NotNull
	@NotEmpty
	@NotBlank
	private String email;

	@NotNull
	@NotEmpty
	@NotBlank
	private String userId;

}
