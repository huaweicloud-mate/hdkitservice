package com.huaweicloud.hdkitservice.model;

public record LoginResponse(String token, String username, int expiresInHours) {}
