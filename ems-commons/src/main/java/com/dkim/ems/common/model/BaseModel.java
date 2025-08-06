package com.dkim.ems.common.model;

import lombok.Data;

import java.time.Instant;

@Data
public class BaseModel {
    private String groupId;
    private String eventId;
    private Instant eventTime;
}
