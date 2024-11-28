package dev.wonsama.auth.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
  /**
   * 좌측 패딩
   * 
   * @param s 입력 문자열
   * @param l 길이
   * @param p 패딩 문자
   * @return 패딩된 문자열
   */
  public String leftPad(String s, int l, char p) {
    StringBuilder sb = new StringBuilder();
    while (sb.length() + s.length() < l) {
      sb.append(p);
    }
    sb.append(s);
    return sb.toString();
  }
}
