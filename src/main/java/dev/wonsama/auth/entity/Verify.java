package dev.wonsama.auth.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import dev.wonsama.auth.enums.VerifyStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 등록된 카드 정보 엔티티
 */
@Entity
@Getter
@Setter
@Table(name = "tb_verify")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Verify {

  /**
   * 카드 아이디 - TokenSystem 에서 생성된 카드 아이디를 사용한다
   */
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  /**
   * 토큰 아이디 - 구매에 사용된 토큰 아이디 (1회용)
   */
  @Column(nullable = false, name = "token_id")
  private String tokenId;

  /**
   * 카드 승인 번호, 우선 생성하고 시작, VerifyStatus 기준으로 유효한지 검증한다
   */
  @Column(nullable = false, name = "approval_no")
  private String approvalNo = "00000000";

  /**
   * CI - Connecting Information
   */
  @Column(name = "ci")
  private String ci;

  /**
   * 카드 번호 - 15~16자리 숫자
   */
  @Column(name = "card_no")
  private String cardNo;

  /**
   * 할부개월수 - 0 이면 일시불, (2~36)
   */
  @Column(nullable = false, name = "installment_month")
  private int installmentMonth;

  /**
   * 처리 상태 : SUCCESS, FAIL, ING
   */
  @Column(nullable = false, name = "verify_status")
  @Enumerated(EnumType.STRING)
  private VerifyStatus verifyStatus;

  @Column(name = "shop_id")
  private String shopId;

  @Column(name = "price")
  private int price = 0;

  /**
   * 등록일
   */
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  /**
   * 수정일
   */
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  public Verify(String tokenId) {
    this.tokenId = tokenId;
    this.verifyStatus = VerifyStatus.ING;
  }
}
