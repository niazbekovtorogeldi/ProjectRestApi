package com.example.projectrestapi.dto.simpleDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleRespons {
    private String status;
    private String message;

    public SimpleRespons(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
