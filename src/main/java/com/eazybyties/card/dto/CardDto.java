package com.eazybyties.card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(
        name = "Card",
        description = "Schema to hold card details"
)
@Getter @Setter @ToString
public class CardDto {
    private String cardNumber;
    @Pattern(regexp = "0[7-9][01][0-9]{8}",message = "Invalid nigeria mobile number")
    private String mobileNumber;
    @Pattern(regexp = "(visacard|mastercard|vervecard)",message = "Unacceptable card type")
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
