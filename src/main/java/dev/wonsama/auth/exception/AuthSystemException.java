package dev.wonsama.auth.exception;

import dev.wonsama.auth.enums.AuthSystemErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthSystemException extends RuntimeException {
  AuthSystemErrorCode errorCode;
}
