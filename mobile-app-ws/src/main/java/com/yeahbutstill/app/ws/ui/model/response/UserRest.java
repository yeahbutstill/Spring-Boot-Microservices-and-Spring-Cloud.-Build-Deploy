package com.yeahbutstill.app.ws.ui.model.response;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRest {

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
    private String userId;

}
