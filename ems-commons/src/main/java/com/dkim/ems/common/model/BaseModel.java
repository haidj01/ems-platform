package com.dkim.ems.common.model;

import com.dkim.ems.common.util.LocalDateTimeToInstantDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.Instant;

@Data
public class BaseModel {
    private String groupId;
    private String eventId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    @JsonDeserialize(using = LocalDateTimeToInstantDeserializer.class)
    private Instant eventTime;
}
