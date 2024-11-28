package dev.wonsama.auth.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthSystemExceptionHandler {
  @ExceptionHandler(AuthSystemException.class)
  protected ResponseEntity<AuthSystemResponse> handleCustomException(AuthSystemException e) {
    return AuthSystemResponse.toResponseEntity(e.getErrorCode());
  }
}
