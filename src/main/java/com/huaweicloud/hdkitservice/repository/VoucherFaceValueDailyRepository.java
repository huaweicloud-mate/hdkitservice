package com.huaweicloud.hdkitservice.repository;

import com.huaweicloud.hdkitservice.model.VoucherFaceValueDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoucherFaceValueDailyRepository extends JpaRepository<VoucherFaceValueDaily, VoucherFaceValueDaily.PK> {

    List<VoucherFaceValueDaily> findByStatDateOrderByClaimCountDesc(LocalDate statDate);
}
