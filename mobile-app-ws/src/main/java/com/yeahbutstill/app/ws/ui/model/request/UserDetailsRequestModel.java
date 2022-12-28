package com.yeahbutstill.app.ws.ui.model.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsRequestModel {

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 2)
    private String firstName;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotEmpty
    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 8)
    private String password;

}
