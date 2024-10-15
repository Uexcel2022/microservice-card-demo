package com.eazybyties.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Schema(
        name = "ErrorResponse"
)
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private HttpStatus errorCode;
    private String statusMessage;
    private LocalDateTime errorTime;
}
