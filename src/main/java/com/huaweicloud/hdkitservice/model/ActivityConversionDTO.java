package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record ActivityConversionDTO(
        List<ConvItem> stages
) {
    public record ConvItem(String label, double rate) {}
}
