package com.ksh.security.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequests {

    @NotBlank
    private String memberName;

    @NotBlank
    @Email
    private String memberEmail;

    @NotBlank
    private String memberPassword;

    @NotBlank
    private String memberPhone;
}
