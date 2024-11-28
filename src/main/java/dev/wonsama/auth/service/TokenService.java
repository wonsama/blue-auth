package dev.wonsama.auth.service;

import dev.wonsama.auth.dto.CreateTokenVerifyReqDto;
import dev.wonsama.auth.dto.CreateTokenVerifyResDto;

public interface TokenService {

  public CreateTokenVerifyResDto createTokenVerify(CreateTokenVerifyReqDto dto);
}
