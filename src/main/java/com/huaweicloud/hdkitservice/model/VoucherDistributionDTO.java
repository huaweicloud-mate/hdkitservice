package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record VoucherDistributionDTO(
        List<FaceValueItem> items
) {
    public record FaceValueItem(int faceAmount, int claimCount, double percentage) {}
}
