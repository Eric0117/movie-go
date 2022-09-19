package com.eric.moviego.controller;

import com.eric.moviego.common.CommonResult;
import com.eric.moviego.common.SingleResult;
import com.eric.moviego.dto.SignInRequestDTO;
import com.eric.moviego.dto.SignUpRequestDTO;
import com.eric.moviego.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signin")
    public SingleResult<String> signIn(@Valid @RequestBody SignInRequestDTO signInRequestDTO) {
        return authService.signIn(signInRequestDTO);
    }

    @PostMapping("/signup")
    public CommonResult registerUser(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) throws Exception {
        return authService.signUp(signUpRequestDTO);
    }
}
