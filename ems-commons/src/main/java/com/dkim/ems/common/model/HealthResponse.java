package com.dkim.ems.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class HealthResponse {
    private String status;
    private String applicationName;
    private Instant checkingTime;
}
