package dev.wonsama.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.wonsama.auth.entity.Verify;

public interface VerifyRepository extends JpaRepository<Verify, String> {

  // , nativeQuery = true
  @Query(value = "SELECT COUNT(*)+1 FROM tb_verify WHERE created_at >= CURRENT_DATE", nativeQuery = true)
  public int countsByToday();

  @Query(value = "SELECT * FROM tb_verify WHERE token_id = :tokenId", nativeQuery = true)
  public Optional<Verify> findByToken(@Param("token") String tokenId);
}
