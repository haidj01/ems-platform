package com.dkim.ems.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToInstantDeserializer extends JsonDeserializer<Instant> {
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

    @Override
    public Instant deserialize(JsonParser parser, DeserializationContext context)
        throws IOException {
        String dateString = parser.getText();

        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateString, FORMATTER);
            // 시간대를 명시적으로 설정 (필요에 따라 변경)
            return localDateTime.atZone(ZoneId.of("America/New_York")).toInstant();
        } catch (Exception e) {
            throw new IOException("날짜 파싱 실패: " + dateString, e);
        }
    }
}
