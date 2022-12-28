package com.yeahbutstill.app.ws.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDetailsRequestModel {

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

}
