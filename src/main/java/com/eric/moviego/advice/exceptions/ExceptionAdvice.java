package com.eric.moviego.advice.exceptions;

import com.eric.moviego.advice.ExceptionEnum;
import com.eric.moviego.common.CommonResult;
import com.eric.moviego.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 15.
 **/
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
    private final ResponseService responseService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return responseService.getFailResult(Integer.parseInt(ExceptionEnum.UNKNOWN_ERROR.getCode()), ExceptionEnum.UNKNOWN_ERROR.getMessage());
    }

    @ExceptionHandler(EmailDuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public CommonResult emailDuplicatedException(HttpServletRequest request, EmailDuplicatedException e) {
        return responseService.getFailResult(Integer.parseInt(ExceptionEnum.DUPLICATED_MEMBER_EMAIL.getCode()), ExceptionEnum.DUPLICATED_MEMBER_EMAIL.getMessage());
    }

    @ExceptionHandler(NameDuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public CommonResult nameDuplicatedException(HttpServletRequest request, NameDuplicatedException e) {
        return responseService.getFailResult(Integer.parseInt(ExceptionEnum.DUPLICATED_MEMBER_NAME.getCode()), ExceptionEnum.DUPLICATED_MEMBER_NAME.getMessage());
    }

    @ExceptionHandler(RoleNotSetException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult roleNotSetException(HttpServletRequest request, RoleNotSetException e) {
        return responseService.getFailResult(Integer.parseInt(ExceptionEnum.ROLE_NOT_SET.getCode()), ExceptionEnum.ROLE_NOT_SET.getMessage());
    }

}
