package dev.wonsama.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wonsama.auth.dto.CreateTokenVerifyReqDto;
import dev.wonsama.auth.dto.CreateTokenVerifyResDto;
import dev.wonsama.auth.enums.AuthSystemErrorCode;
import dev.wonsama.auth.exception.AuthSystemException;
import dev.wonsama.auth.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * 카드 관련 API 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/auth/token")
@Tag(name = "Token", description = "Token 관련 API")
public class TokenController {

  @Autowired
  private TokenService tokenService;

  /**
   * 카드 등록
   * 
   * @param dto           카드 등록 요청 DTO
   * @param bindingResult 바인딩 결과
   * @return 등록된 카드 정보
   */
  @PostMapping("/verify")
  @Operation(summary = "Token 검증 수행", description = "전달받은 TOKEN 이 유효한 정보인지 확인한다")
  public CreateTokenVerifyResDto createTokenVerify(@Valid @RequestBody CreateTokenVerifyReqDto dto,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        log.error("Error: {}", error.getDefaultMessage());
      });
      throw new AuthSystemException(AuthSystemErrorCode.INVALID_REQUEST_PARAMETER);
    }

    return tokenService.createTokenVerify(dto);
  }
}
