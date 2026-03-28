package com.yazzzeh.mongo.dtos;

import java.time.LocalDate;

public record ProjectRequest(
        String projectCode,
        String projectName,
        String clientName,
        String type,
        String location,
        LocalDate startDate
) {
}