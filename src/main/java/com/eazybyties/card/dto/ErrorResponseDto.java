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
    @Schema(
            description = "Endpoint invoked when the error occurred",example = "uri=/api/fetch"
    )
    private String apiPath;
    @Schema(
            description = "Response", example = "400"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error message", example = "Required parameter 'mobileOrCardNumber' is not present"
    )
    private String statusMessage;
    @Schema(
            description = "The date and date error occurred", example = "2024-10-16T17:10:22.5514261"
    )

    private LocalDateTime errorTime;
}
