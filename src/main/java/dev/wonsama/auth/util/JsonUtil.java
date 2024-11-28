package dev.wonsama.auth.util;

import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dev.wonsama.auth.enums.AuthSystemErrorCode;
import dev.wonsama.auth.exception.AuthSystemException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JsonUtil {

  /**
   * json 문자열을 JsonObject로 변환
   * 
   * @param json 변환할 json 문자열
   * @return JsonObject
   */
  public JsonObject toJsonObject(String json) {
    try {
      JsonObject jsonObject = JsonParser.parseString(json)
          .getAsJsonObject();
      return jsonObject;
    } catch (Exception e) {
      log.error("toJsonObject fail ::: json : {}", json);
      throw new AuthSystemException(AuthSystemErrorCode.JSON_PARSE_OBJECT_ERROR);
    }
  }

  /**
   * JsonObject에서 key에 해당하는 값을 String으로 반환
   * 
   * @param json         추출할 json 문자열
   * @param key          추출할 key
   * @param defaultValue key에 해당하는 값이 없을 경우 반환할 기본값
   * @return key에 해당하는 값
   */
  public String getString(String json, String key, String defaultValue) {
    try {
      JsonElement el = toJsonObject(json).get(key);
      if (el.isJsonNull()) {
        return defaultValue;
      }
      return el.getAsString();
    } catch (Exception e) {
      log.error("getString fail ::: key : {} / json : {}", key, json);
      throw new AuthSystemException(AuthSystemErrorCode.JSON_EXTRACT_STRING_ERROR);
    }
  }

  public String getString(String json, String key) {
    return getString(json, key, null);
  }

  /**
   * JsonObject에서 key에 해당하는 값을 Boolean 으로 반환
   * 
   * @param json         추출할 json 문자열
   * @param key          추출할 key
   * @param defaultValue key에 해당하는 값이 없을 경우 반환할 기본값
   * @return key에 해당하는 값
   */
  public boolean getBoolean(String json, String key, boolean defaultValue) {
    try {
      JsonElement el = toJsonObject(json).get(key);
      if (el.isJsonNull()) {
        return defaultValue;
      }
      return el.getAsBoolean();

    } catch (Exception e) {
      log.error("getAsBoolean fail ::: key : {} / json : {}", key, json);
      throw new AuthSystemException(AuthSystemErrorCode.JSON_EXTRACT_STRING_ERROR);
    }
  }

  /**
   * JsonObject에서 key에 해당하는 값을 Boolean 으로 반환
   * 
   * @param json 추출할 json 문자열
   * @param key  추출할 key
   * @return key에 해당하는 값
   */
  public boolean getBoolean(String json, String key) {
    return getBoolean(json, key, false);
  }
}
