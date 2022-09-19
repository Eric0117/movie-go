package com.eric.moviego.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
@Data
public class SignInRequestDTO {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}
