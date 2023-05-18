package io.github.IsacWilliam.rest.controller;

import io.github.IsacWilliam.exception.RegraNegocioException;
import io.github.IsacWilliam.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioEception(RegraNegocioException ex){
        String messagemErro = ex.getMessage();
        return new ApiErrors(messagemErro);
    }
}
