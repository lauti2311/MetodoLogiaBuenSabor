package com.example.buensaboruno.config.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private int numOfErrors;
    private String message;
}
