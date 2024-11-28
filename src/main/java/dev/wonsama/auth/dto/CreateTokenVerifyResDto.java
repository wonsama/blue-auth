package dev.wonsama.auth.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateTokenVerifyResDto {
  private boolean isValid;
  private String cause;
  private String approvalNo = "00000000";

  @Builder
  public CreateTokenVerifyResDto(boolean isValid, String cause, String approvalNo) {
    this.isValid = isValid;
    this.cause = cause;
    this.approvalNo = approvalNo;
  }

}