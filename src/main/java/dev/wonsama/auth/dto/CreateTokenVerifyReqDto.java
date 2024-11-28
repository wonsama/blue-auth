package dev.wonsama.auth.dto;

import com.google.gson.Gson;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTokenVerifyReqDto {

  @NotNull(message = "Token 은 필수값입니다")
  private String tokenId;

  // 구매 정보
  @NotNull(message = "매장아이디는 필수값입니다") // 매장아이디는 Auth에서 검증 불가, 이전에서 검증하여야 됨
  private String shopId;

  @Min(value = 100, message = "가격은 100원 이상으로 입력해주세요")
  private int price;

  @Min(value = 1, message = "2개월 이상으로 입력해주세요. 1=일시불")
  @Max(value = 36, message = "0-36개월로 입력해주세요")
  private int installmentMonth = 1;

  @Builder
  public CreateTokenVerifyReqDto(String tokenId) {
    this.tokenId = tokenId;
  }

  /**
   * JSON 문자열로 변환
   */
  public String toJson() {
    Gson gson = new Gson();
    return gson.toJson(this);
  }
}
