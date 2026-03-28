package com.yazzzeh.mongo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "projects")
@Data
@Builder
public class Project {
    @Id
    private String id;

    private String projectCode;          // Unique project identifier
    private String projectName;
    private String clientName;

    private String type;                  // e.g. Construction, Maintenance, Inspection
    private String location;              // Site location

    private LocalDate startDate;
    private LocalDate lastUpdateDate;

    private String status;                // PLANNING, ACTIVE, COMPLETED, ON_HOLD
    private Integer progressPercentage;   // 0-100

}
