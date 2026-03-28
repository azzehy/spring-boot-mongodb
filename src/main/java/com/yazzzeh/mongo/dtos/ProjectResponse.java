package com.yazzzeh.mongo.dtos;

import java.time.LocalDate;

public record ProjectResponse(
        String id,
        String projectCode,
        String projectName,
        String clientName,
        String type,
        String location,
        LocalDate startDate,
        LocalDate lastUpdateDate,
        String status,
        Integer progressPercentage
) {
}