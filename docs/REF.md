# README

## 작업순서

1. 요구사항 확인
   1. 고객과의 미팅 & 요구사항 정리
   2. 고객이 원하는 것과 필요한 것을 구분 / 필수 요소부터 진행
   3. 반드시 정리 이후 고객의 확인을 통해 최종 요구사항 확인
2. 작업 흐름 확인
   1. 업무 영역 구분
   2. 개별 영역 내 엑션 아이템 확인
   3. 개별 영역 내 작업흐름 작성 - SEQUENCE DIAGRAM 작성
   4. 영역 별 우선순위 확인
   5. 외부 연계 및 확장성 고려
3. 화면설계
   1. 요구사항 준수를 목표로 하는 최소한의 화면설계
   2. 최대한 공통 요소를 활용한 화면설계 고려
      1. 공통 요소 : 헤더, 푸터, 메뉴, 로그인 등
      2. 팝업 요소 : Master 성 정보 - 코드 / 사용자 / 아이템 등
   3. 실제 화면을 기획하면서 누락된 사항 설계 반영 (보통 작업흐름에 있어 숨겨진 영역)
   4. 화면설계 미팅 이후 요구사항 외 추가 요건의 경우 별도 일정관리 필수
4. ERD 작성
   1. 작업에 필수요소 확인 : CORE
   2. 화면을 구성하기 위한 추가요소 확인 : CHANNEL
   3. 이후 확장이 예상되는 부분에 대한 추가요소 확인 : EXTENSION
5. REST-API-JPA 개발
   1. Entity
   2. Repository
   3. Service
   4. Controller
6. TEST
   1. Unit Test
   2. E2E Test
7. API 문서 작성
   1. Swagger
8. DEPLOY
   ~~1. Maven Build & Run~~
   ~~2. Dockerfile~~
   ~~3. docker-compose.yml~~
9. CLOUD
   ~~1. ECR 이미지 업로드~~
   ~~2. ECS 배포 설정~~
   ~~3. RDS 설정~~

## 참조링크

- [[JPA] hibernate의 ddl-auto 속성의 종류와 주의해야할 점](https://colabear754.tistory.com/136)
- [[JPA] Foreign key를 제거하기로 했습니다 (feat. JPA 적용)](https://velog.io/@yrc97/JPA-Foreign-key%EB%A5%BC-%EC%A0%9C%EA%B1%B0%ED%95%98%EA%B8%B0%EB%A1%9C-%ED%96%88%EC%8A%B5%EB%8B%88%EB%8B%A4)
- [[JPA] - createdAt, updatedAt 자동 입력](https://velog.io/@ogu1208/JPA-createdAt-updatedAt-%EC%9E%90%EB%8F%99-%EC%9E%85%EB%A0%A5)
- [[JPA] @Enumerated 사용법](https://lovethefeel.tistory.com/72)
- [JPA에서 스트링 컬럼의 varchar 255 제한 해제하기](https://theleast.tistory.com/42)
- [스프링 부트 코딩 공작소 7장 액추에이터](https://theleast.tistory.com/29)
- [Spring Boot JPA + H2 example: Build a CRUD Rest APIs](https://www.bezkoder.com/spring-boot-jpa-h2-example/)
- [JPA @OneToMany, @ManyToOne으로 연관관계 관리하기](https://velog.io/@goniieee/JPA-OneToMany-ManyToOne%EC%9C%BC%EB%A1%9C-%EC%97%B0%EA%B4%80%EA%B4%80%EA%B3%84-%EA%B4%80%EB%A6%AC%ED%95%98%EA%B8%B0)
- [@ManyToOne과 @OneToMany로 배우는 JPA 기초 사용법 - 실습으로 배우는 JPA 1편](https://stir.tistory.com/158#google_vignette)
- [[SpringBoot] Custom Exception Response 만들기](https://velog.io/@dot2__/SpringBoot-Custom-Exception-Response-%EB%A7%8C%EB%93%A4%EA%B8%B0)
- [Spring Boot Validation 어노테이션 정리](https://devbksheen.tistory.com/entry/Spring-boot-validation-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%A0%95%EB%A6%AC)
- [apache_httpclient_response_handlers](https://www.tutorialspoint.com/apache_httpclient/apache_httpclient_response_handlers.htm)
- [[자바/스프링] API 호출 라이브러리 HttpURLConnection, RestTemplate, WebClient 비교](https://im-h-t-e-l.tistory.com/89)
- [[Spirng/JPA] Dto와 Entity를 분리해서 사용하는 이유](https://hstory0208.tistory.com/entry/SpirngJPA-Dto%EC%99%80-Entity%EB%A5%BC-%EB%B6%84%EB%A6%AC%ED%95%B4%EC%84%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)
- [JWT 토큰을 이용해서 로그인 인증 구현하기](https://dodop-blog.tistory.com/228)
- [Java @NoargsConstructor(AccessLevel.PROTECTED) 와 @Builder](https://cobbybb.tistory.com/14)
- [[Trouble-Shooting] Spring JPA @ColumnDefault 오류](https://jaehee1007.tistory.com/16)
- [failed to lazily initialize a collection of role 에러](https://velog.io/@chocochip/failed-to-lazily-initialize-a-collection-of-role-%EC%97%90%EB%9F%AC)
- [Optional의 orElse, orElseGet, orElseThrow 사용법](https://stir.tistory.com/140)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa)
- [[Java] Spring Boot - springdoc openapi 사용하기](https://blog.naver.com/seek316/223349824088)
- [Execute multiple lines in orElseThrow](https://stackoverflow.com/questions/68745590/execute-multiple-lines-in-orelsethrow)
