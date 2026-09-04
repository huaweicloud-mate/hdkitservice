package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record SandboxDurationDTO(
    String statDate,
    List<BucketItem> buckets
) {
    public record BucketItem(String label, int order, int count) {}
}
