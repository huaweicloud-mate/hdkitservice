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
@Table(name = "voucher_face_value_daily")
@IdClass(VoucherFaceValueDaily.PK.class)
public class VoucherFaceValueDaily {

    @Id
    @Column(name = "stat_date", nullable = false)
    private LocalDate statDate;

    @Id
    @Column(name = "face_amount", nullable = false)
    private Integer faceAmount;

    @Column(name = "claim_count")
    private Integer claimCount;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public VoucherFaceValueDaily() {}

    public VoucherFaceValueDaily(LocalDate statDate, Integer faceAmount, Integer claimCount) {
        this.statDate = statDate;
        this.faceAmount = faceAmount;
        this.claimCount = claimCount;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDate getStatDate() { return statDate; }
    public void setStatDate(LocalDate statDate) { this.statDate = statDate; }

    public Integer getFaceAmount() { return faceAmount; }
    public void setFaceAmount(Integer faceAmount) { this.faceAmount = faceAmount; }

    public Integer getClaimCount() { return claimCount; }
    public void setClaimCount(Integer claimCount) { this.claimCount = claimCount; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static class PK implements Serializable {
        private LocalDate statDate;
        private Integer faceAmount;

        public PK() {}

        public PK(LocalDate statDate, Integer faceAmount) {
            this.statDate = statDate;
            this.faceAmount = faceAmount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PK pk = (PK) o;
            return Objects.equals(statDate, pk.statDate) && Objects.equals(faceAmount, pk.faceAmount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(statDate, faceAmount);
        }
    }
}
