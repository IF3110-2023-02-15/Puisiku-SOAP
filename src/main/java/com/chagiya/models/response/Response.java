package com.chagiya.models.response;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Response {
    private int status;
    private String message;
}

