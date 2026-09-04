package com.huaweicloud.hdkitservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_stats_snapshot")
public class ActivityStatsSnapshot {

    @Id
    @Column(name = "snapshot_date", nullable = false)
    private LocalDate snapshotDate;

    @Column(name = "activity_code", length = 64, nullable = false)
    private String activityCode;

    @Column(name = "activity_name", length = 128)
    private String activityName;

    @Column(name = "participant_count")
    private int participantCount;

    @Column(name = "submit_count")
    private int submitCount;

    @Column(name = "beginner_count")
    private int beginnerCount;

    @Column(name = "intermediate_count")
    private int intermediateCount;

    @Column(name = "advanced_count")
    private int advancedCount;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ActivityStatsSnapshot() {}

    public ActivityStatsSnapshot(LocalDate snapshotDate, String activityCode, String activityName,
                                  int participantCount, int submitCount,
                                  int beginnerCount, int intermediateCount, int advancedCount) {
        this.snapshotDate = snapshotDate;
        this.activityCode = activityCode;
        this.activityName = activityName;
        this.participantCount = participantCount;
        this.submitCount = submitCount;
        this.beginnerCount = beginnerCount;
        this.intermediateCount = intermediateCount;
        this.advancedCount = advancedCount;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDate getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDate snapshotDate) { this.snapshotDate = snapshotDate; }

    public String getActivityCode() { return activityCode; }
    public void setActivityCode(String activityCode) { this.activityCode = activityCode; }

    public String getActivityName() { return activityName; }
    public void setActivityName(String activityName) { this.activityName = activityName; }

    public int getParticipantCount() { return participantCount; }
    public void setParticipantCount(int participantCount) { this.participantCount = participantCount; }

    public int getSubmitCount() { return submitCount; }
    public void setSubmitCount(int submitCount) { this.submitCount = submitCount; }

    public int getBeginnerCount() { return beginnerCount; }
    public void setBeginnerCount(int beginnerCount) { this.beginnerCount = beginnerCount; }

    public int getIntermediateCount() { return intermediateCount; }
    public void setIntermediateCount(int intermediateCount) { this.intermediateCount = intermediateCount; }

    public int getAdvancedCount() { return advancedCount; }
    public void setAdvancedCount(int advancedCount) { this.advancedCount = advancedCount; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
