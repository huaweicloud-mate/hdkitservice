package com.huaweicloud.hdkitservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "voucher_claim_log")
public class VoucherClaimLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "claim_id", length = 64, nullable = false, unique = true)
    private String claimId;

    @Column(name = "domain_hash", length = 64, nullable = false)
    private String domainHash;

    @Column(name = "face_amount", nullable = false)
    private Integer faceAmount;

    @Column(name = "coupon_id", length = 128)
    private String couponId;

    @Column(name = "source", length = 64)
    private String source;

    @Column(name = "claim_time", nullable = false)
    private LocalDateTime claimTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public VoucherClaimLog() {}

    public VoucherClaimLog(String claimId, String domainHash, Integer faceAmount,
                           String couponId, String source, LocalDateTime claimTime) {
        this.claimId = claimId;
        this.domainHash = domainHash;
        this.faceAmount = faceAmount;
        this.couponId = couponId;
        this.source = source;
        this.claimTime = claimTime;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClaimId() { return claimId; }
    public void setClaimId(String claimId) { this.claimId = claimId; }

    public String getDomainHash() { return domainHash; }
    public void setDomainHash(String domainHash) { this.domainHash = domainHash; }

    public Integer getFaceAmount() { return faceAmount; }
    public void setFaceAmount(Integer faceAmount) { this.faceAmount = faceAmount; }

    public String getCouponId() { return couponId; }
    public void setCouponId(String couponId) { this.couponId = couponId; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public LocalDateTime getClaimTime() { return claimTime; }
    public void setClaimTime(LocalDateTime claimTime) { this.claimTime = claimTime; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
