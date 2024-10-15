package com.eazybyties.card.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private String statusMessage;
    private String errorCode;
    private LocalDateTime errorTime;
}
