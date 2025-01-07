package com.example.buensaboruno.domain.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ErrorDto {
    @JsonProperty("error_code")
    private String errorMsg;
    @JsonProperty("error_message")
    private String errorClass;
}
