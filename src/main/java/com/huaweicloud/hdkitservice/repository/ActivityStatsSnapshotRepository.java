package com.huaweicloud.hdkitservice.repository;

import com.huaweicloud.hdkitservice.model.ActivityStatsSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityStatsSnapshotRepository extends JpaRepository<ActivityStatsSnapshot, LocalDate> {

    Optional<ActivityStatsSnapshot> findFirstByOrderBySnapshotDateDesc();

    List<ActivityStatsSnapshot> findBySnapshotDateGreaterThanEqualOrderBySnapshotDateAsc(LocalDate startDate);
}
