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
@Table(name = "sandbox_hourly_stats")
@IdClass(SandboxHourlyStats.PK.class)
public class SandboxHourlyStats {

    @Id
    @Column(name = "stat_date", nullable = false)
    private LocalDate statDate;

    @Id
    @Column(name = "hour_of_day", nullable = false)
    private Integer hourOfDay;

    @Column(name = "user_count")
    private Integer userCount;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public SandboxHourlyStats() {
    }

    public SandboxHourlyStats(LocalDate statDate, Integer hourOfDay, Integer userCount) {
        this.statDate = statDate;
        this.hourOfDay = hourOfDay;
        this.userCount = userCount;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDate getStatDate() { return statDate; }
    public void setStatDate(LocalDate statDate) { this.statDate = statDate; }
    public Integer getHourOfDay() { return hourOfDay; }
    public void setHourOfDay(Integer hourOfDay) { this.hourOfDay = hourOfDay; }
    public Integer getUserCount() { return userCount; }
    public void setUserCount(Integer userCount) { this.userCount = userCount; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public static class PK implements Serializable {
        private LocalDate statDate;
        private Integer hourOfDay;

        public PK() {
        }

        public PK(LocalDate statDate, Integer hourOfDay) {
            this.statDate = statDate;
            this.hourOfDay = hourOfDay;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PK pk)) return false;
            return Objects.equals(statDate, pk.statDate) && Objects.equals(hourOfDay, pk.hourOfDay);
        }

        @Override
        public int hashCode() {
            return Objects.hash(statDate, hourOfDay);
        }
    }
}
