package com.huaweicloud.hdkitservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sandbox_duration_bucket_daily")
@IdClass(SandboxDurationBucketDaily.PK.class)
public class SandboxDurationBucketDaily {

    @Id
    @Column(name = "stat_date", nullable = false)
    private LocalDate statDate;

    @Id
    @Column(name = "bucket_label", length = 16, nullable = false)
    private String bucketLabel;

    @Column(name = "bucket_order")
    private Integer bucketOrder;

    @Column(name = "count")
    private Integer count;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public SandboxDurationBucketDaily() {
    }

    public SandboxDurationBucketDaily(LocalDate statDate, String bucketLabel,
                                      Integer bucketOrder, Integer count) {
        this.statDate = statDate;
        this.bucketLabel = bucketLabel;
        this.bucketOrder = bucketOrder;
        this.count = count;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDate getStatDate() { return statDate; }
    public void setStatDate(LocalDate statDate) { this.statDate = statDate; }
    public String getBucketLabel() { return bucketLabel; }
    public void setBucketLabel(String bucketLabel) { this.bucketLabel = bucketLabel; }
    public Integer getBucketOrder() { return bucketOrder; }
    public void setBucketOrder(Integer bucketOrder) { this.bucketOrder = bucketOrder; }
    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static class PK implements Serializable {
        private LocalDate statDate;
        private String bucketLabel;

        public PK() {
        }

        public PK(LocalDate statDate, String bucketLabel) {
            this.statDate = statDate;
            this.bucketLabel = bucketLabel;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PK pk)) return false;
            return Objects.equals(statDate, pk.statDate) && Objects.equals(bucketLabel, pk.bucketLabel);
        }

        @Override
        public int hashCode() {
            return Objects.hash(statDate, bucketLabel);
        }
    }
}
