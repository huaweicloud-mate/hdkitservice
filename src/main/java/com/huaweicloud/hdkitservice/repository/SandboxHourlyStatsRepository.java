package com.huaweicloud.hdkitservice.repository;

import com.huaweicloud.hdkitservice.model.SandboxHourlyStats;
import com.huaweicloud.hdkitservice.model.SandboxHourlyStats.PK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SandboxHourlyStatsRepository extends JpaRepository<SandboxHourlyStats, PK> {

    List<SandboxHourlyStats> findByStatDateOrderByHourOfDay(LocalDate statDate);
}
