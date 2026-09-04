package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record ActivitySummaryDTO(
        long totalParticipants,
        long chapter1Completed,
        long chapter2Completed,
        long chapter3Completed,
        double chapter1Rate,
        double chapter2Rate,
        double chapter3Rate,
        List<FunnelStage> funnel
) {
    public record FunnelStage(String name, long value, double rate) {}
}
