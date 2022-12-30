package com.yeahbutstill.photoapp.api.users.model.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AlbumResponseModel {

	@NotNull
	@NotEmpty
	@NotBlank
    private String albumId;

	@NotNull
	@NotEmpty
	@NotBlank
    private String userId;

	@NotNull
	@NotEmpty
	@NotBlank
    private String name;

	@NotNull
	@NotEmpty
	@NotBlank
    private String description;
    
	
}
