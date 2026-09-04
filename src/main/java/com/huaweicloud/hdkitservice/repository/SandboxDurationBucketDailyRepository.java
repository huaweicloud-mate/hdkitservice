package com.huaweicloud.hdkitservice.repository;

import com.huaweicloud.hdkitservice.model.SandboxDurationBucketDaily;
import com.huaweicloud.hdkitservice.model.SandboxDurationBucketDaily.PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SandboxDurationBucketDailyRepository extends JpaRepository<SandboxDurationBucketDaily, PK> {

    List<SandboxDurationBucketDaily> findByStatDateOrderByBucketOrder(LocalDate statDate);
}
