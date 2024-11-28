package dev.wonsama.auth.exception;

import org.springframework.http.ResponseEntity;

import dev.wonsama.auth.enums.AuthSystemErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthSystemResponse {

  private int status;
  private String code;
  private String message;

  public static ResponseEntity<AuthSystemResponse> toResponseEntity(AuthSystemErrorCode e) {
    return ResponseEntity
        .status(e.getHttpStatus())
        .body(AuthSystemResponse.builder()
            .status(e.getHttpStatus().value())
            .code(e.name())
            .message(e.getMessage())
            .build());
  }

}
