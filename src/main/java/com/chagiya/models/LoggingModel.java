package com.chagiya.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@NonNull
@AllArgsConstructor
public class LoggingModel {
    private String description;
    private String ipAddress;
    private String endpoint;
    private String requester;
}

