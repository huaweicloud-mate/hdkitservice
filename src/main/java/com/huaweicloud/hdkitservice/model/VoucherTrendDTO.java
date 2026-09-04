package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record VoucherTrendDTO(
        List<TrendPoint> daily
) {
    public record TrendPoint(String date, long count, long amount) {}
}
