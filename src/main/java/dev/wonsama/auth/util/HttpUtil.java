package dev.wonsama.auth.util;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.stereotype.Component;

import dev.wonsama.auth.dto.HttpResponseDto;

@Component
public class HttpUtil {

  public HttpResponseDto postJson(String url, String json) throws IOException {
    HttpResponseDto response = null;
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpPost httpPost = new HttpPost(url);
      httpPost.addHeader("Content-Type", "application/json");
      StringEntity entity = new StringEntity(json);
      httpPost.setEntity(entity);

      // 응답 메시지 설정 - HttpResponseDto 에서 status 로 처리 ( 응답코드 : 200~299 )
      response = httpClient.execute(httpPost, httpResponse -> {
        int status = httpResponse.getCode();
        String content = httpResponse.getEntity() != null
            ? new String(httpResponse.getEntity().getContent().readAllBytes())
            : null;
        return HttpResponseDto.builder().status(status).content(content).build();
      });
    }
    return response;
  }
}
