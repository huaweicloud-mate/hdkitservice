package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record SandboxTrendDTO(
    List<TrendPoint> daily,
    List<TrendPoint> events,
    long totalUsers
) {
    public record TrendPoint(String date, long value) {}
}
