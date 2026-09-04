package com.huaweicloud.hdkitservice.model;

import java.util.List;

public record SandboxHourlyDTO(
    String statDate,
    List<HourlyPoint> hourly
) {
    public record HourlyPoint(int hour, int count) {}
}
