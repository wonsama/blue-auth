package dev.wonsama.auth.service.impl;

import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.wonsama.auth.dto.CreateTokenVerifyReqDto;
import dev.wonsama.auth.dto.CreateTokenVerifyResDto;
import dev.wonsama.auth.dto.HttpResponseDto;
import dev.wonsama.auth.entity.Verify;
import dev.wonsama.auth.enums.AuthSystemErrorCode;
import dev.wonsama.auth.enums.VerifyStatus;
import dev.wonsama.auth.exception.AuthSystemException;
import dev.wonsama.auth.repository.VerifyRepository;
import dev.wonsama.auth.service.TokenService;
import dev.wonsama.auth.util.HttpUtil;
import dev.wonsama.auth.util.JsonUtil;
import dev.wonsama.auth.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

  @Autowired
  private VerifyRepository verifyRepository;

  @Autowired
  private HttpUtil httpUtil;

  @Autowired
  private JsonUtil jsonUtil;

  @Autowired
  private StringUtil stringUtil;

  @Value("${api.issue.host}")
  private String API_ISSUE_HOST;

  @Value("${api.issue.path.token.validate}")
  private String API_ISSUE_PATH_TOKEN_VALIDATE;

  @Override
  public CreateTokenVerifyResDto createTokenVerify(CreateTokenVerifyReqDto dto) {

    log.info(ToStringBuilder.reflectionToString(dto));

    // 토큰
    String tokenId = dto.getTokenId();

    // TokenSystem 을 통한 토큰 검증
    HttpResponseDto res = null;
    try {
      res = httpUtil.postJson(String.format("%s%s", API_ISSUE_HOST, API_ISSUE_PATH_TOKEN_VALIDATE), dto.toJson());
    } catch (IOException e) {
      Verify verify = new Verify(tokenId);
      verify.setVerifyStatus(VerifyStatus.ERR_HTTP_POST);
      verifyRepository.save(verify);
      log.error("interface call failed 1 {}", dto.toJson());
      throw new AuthSystemException(AuthSystemErrorCode.IF_TOKEN_SYSTEM_TOKEN_VERIFY);
    }

    // TokenSystem 응답코드 확인
    if (res.getStatus() != 200) {
      Verify verify = new Verify(tokenId);
      verify.setVerifyStatus(VerifyStatus.ERR_HTTP_NETWORK);
      verifyRepository.save(verify);
      log.error("interface call failed 2 {} {}", res.getStatus(), res.getContent());
      throw new AuthSystemException(AuthSystemErrorCode.IF_TOKEN_SYSTEM_TOKEN_VERIFY);
    }

    // TokenSystem 응답 데이터 파싱
    String cause = jsonUtil.getString(res.getContent(), "cause");
    boolean isValid = jsonUtil.getBoolean(res.getContent(), "valid");
    String cardNo = jsonUtil.getString(res.getContent(), "cardNo");
    String ci = jsonUtil.getString(res.getContent(), "ci");

    // TokenSystem 응답 정보 확인
    if (isValid == false) {
      Verify verify = new Verify(tokenId);
      verify.setVerifyStatus(VerifyStatus.FAIL);
      verifyRepository.save(verify);
      log.error("invalid token {}", cause);
      throw new AuthSystemException(AuthSystemErrorCode.IF_TOKEN_SYSTEM_TOKEN_VERIFY);
    }

    // 승인 검증정보 업데이트
    int _approvalNo = verifyRepository.countsByToday();
    String approvalNo = stringUtil.leftPad(String.valueOf(_approvalNo), 8, '0');
    Verify verify = new Verify(tokenId);
    verify.setVerifyStatus(VerifyStatus.SUCCESS);
    verify.setApprovalNo(approvalNo);
    verify.setCardNo(cardNo);
    verify.setCi(ci);
    verify.setPrice(dto.getPrice());
    verify.setShopId(dto.getShopId());
    verify.setInstallmentMonth(dto.getInstallmentMonth());
    verifyRepository.save(verify);

    // 응답정보
    CreateTokenVerifyResDto resDto = CreateTokenVerifyResDto.builder()
        .isValid(isValid)
        .cause(cause)
        .approvalNo(approvalNo)
        .build();

    return resDto;
  }

}
