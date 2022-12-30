package com.yeahbutstill.photoapp.api.users.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserResponseModel {

	@NotNull
	@NotEmpty
	@NotBlank
    private String userId;

	@NotNull
	@NotEmpty
	@NotBlank
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
    private List<AlbumResponseModel> albums;

}
