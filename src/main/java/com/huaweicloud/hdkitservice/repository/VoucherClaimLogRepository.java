package com.huaweicloud.hdkitservice.repository;

import com.huaweicloud.hdkitservice.model.VoucherClaimLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoucherClaimLogRepository extends JpaRepository<VoucherClaimLog, Long> {

    @Query(value = "SELECT COUNT(DISTINCT domain_hash) FROM voucher_claim_log WHERE DATE(claim_time) = :date", nativeQuery = true)
    long countDistinctUsersByDate(@Param("date") LocalDate date);

    @Query(value = "SELECT COALESCE(SUM(face_amount), 0) FROM voucher_claim_log WHERE DATE(claim_time) = :date", nativeQuery = true)
    long sumAmountByDate(@Param("date") LocalDate date);

    @Query(value = "SELECT COUNT(DISTINCT domain_hash) FROM voucher_claim_log", nativeQuery = true)
    long countAllDistinctUsers();

    @Query(value = "SELECT COALESCE(SUM(face_amount), 0) FROM voucher_claim_log", nativeQuery = true)
    long sumAllAmount();

    @Query(value = "SELECT COUNT(DISTINCT domain_hash) FROM voucher_claim_log WHERE YEAR(claim_time) = :year AND MONTH(claim_time) = :month", nativeQuery = true)
    long countDistinctUsersByMonth(@Param("year") int year, @Param("month") int month);

    @Query(value = "SELECT COALESCE(SUM(face_amount), 0) FROM voucher_claim_log WHERE YEAR(claim_time) = :year AND MONTH(claim_time) = :month", nativeQuery = true)
    long sumAmountByMonth(@Param("year") int year, @Param("month") int month);

    @Query(value = "SELECT DATE(claim_time) AS d, COUNT(*) AS cnt, COALESCE(SUM(face_amount), 0) AS amt FROM voucher_claim_log WHERE DATE(claim_time) >= :startDate GROUP BY DATE(claim_time) ORDER BY d", nativeQuery = true)
    List<Object[]> findDailyStatsSince(@Param("startDate") LocalDate startDate);

    @Query(value = "SELECT face_amount, COUNT(*) AS cnt FROM voucher_claim_log WHERE DATE(claim_time) = :date GROUP BY face_amount ORDER BY cnt DESC", nativeQuery = true)
    List<Object[]> findFaceValueDistributionByDate(@Param("date") LocalDate date);
}
