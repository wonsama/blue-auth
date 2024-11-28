package dev.wonsama.auth.enums;

public enum VerifyStatus {
  SUCCESS, // 성공
  FAIL, // 실패
  ING, // 진행 중, 최초 진입시 상태
  ERR_HTTP_POST,
  ERR_HTTP_NETWORK,
  ERR_VERIFY

}
