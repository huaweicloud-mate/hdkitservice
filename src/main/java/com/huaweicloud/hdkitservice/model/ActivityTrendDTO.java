package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record ActivityTrendDTO(
        List<TrendPoint> chapter1,
        List<TrendPoint> chapter2,
        List<TrendPoint> chapter3
) {
    public record TrendPoint(String date, long value) {}
}
