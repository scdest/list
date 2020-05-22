package com.simple.list.api;

import com.simple.list.exceptions.AccessForbiddenException;
import com.simple.list.exceptions.UnproccessableEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CustomRestExceptionHandler {

    @ExceptionHandler(UnproccessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public Error unprocessable(UnproccessableEntityException ex) {
        log.warn(ex.getMessage());
        return new Error(ex.getMessage());
    }

    @ExceptionHandler(AccessForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public Error forbidden(AccessForbiddenException ex) {
        log.warn(ex.getMessage());
        return new Error(ex.getMessage());
    }
}
