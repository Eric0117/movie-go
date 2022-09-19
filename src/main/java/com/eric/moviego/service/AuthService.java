package com.eric.moviego.service;

import com.eric.moviego.common.CommonResult;
import com.eric.moviego.common.SingleResult;
import com.eric.moviego.dto.SignInRequestDTO;
import com.eric.moviego.dto.SignUpRequestDTO;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 19.
 **/
public interface AuthService {
    SingleResult<String> signIn(SignInRequestDTO signInRequestDTO);
    CommonResult signUp(SignUpRequestDTO signUpRequestDTO);
}
