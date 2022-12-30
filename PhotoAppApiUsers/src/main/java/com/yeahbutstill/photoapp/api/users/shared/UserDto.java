package com.yeahbutstill.photoapp.api.users.shared;

import com.yeahbutstill.photoapp.api.users.model.response.AlbumResponseModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserDto implements Serializable {
	@Serial
	private static final long serialVersionUID = -953297098295050686L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userId;
	private String encryptedPassword;
	private List<AlbumResponseModel> albums;

}
