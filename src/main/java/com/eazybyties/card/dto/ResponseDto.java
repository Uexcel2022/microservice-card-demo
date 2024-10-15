package com.eazybyties.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        name="Response"
)
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResponseDto {
    private String statusCode;
    private String statusMessage;
}
