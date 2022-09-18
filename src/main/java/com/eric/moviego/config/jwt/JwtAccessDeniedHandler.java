package com.eric.moviego.config.jwt;

import com.eric.moviego.advice.ExceptionEnum;
import com.eric.moviego.service.ResponseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 16.
 **/
@Component
@RequiredArgsConstructor
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAccessDeniedHandler.class);

    private final ResponseService responseService;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        LOGGER.error(ExceptionEnum.ACCESS_DENIED.getMessage());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        try (OutputStream os = response.getOutputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(os, responseService.getFailResult(Integer.parseInt(ExceptionEnum.ACCESS_DENIED.getCode()), ExceptionEnum.ACCESS_DENIED.getMessage()));
            os.flush();
        }
    }
}
