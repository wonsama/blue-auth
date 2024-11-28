package dev.wonsama.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HttpResponseDto {
  private int status;
  private String content;

  @Builder
  public HttpResponseDto(int status, String content) {
    this.status = status;
    this.content = content;
  }
}
