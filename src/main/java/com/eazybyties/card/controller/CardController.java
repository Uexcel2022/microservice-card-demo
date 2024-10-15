package com.eazybyties.card.controller;

import com.eazybyties.card.constants.CardConstants;
import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.dto.ErrorResponseDto;
import com.eazybyties.card.dto.ResponseDto;
import com.eazybyties.card.exception.CardNotValidException;
import com.eazybyties.card.service.ICardService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "EazyBank CRUD REST APIs ",
        description =  "CRUD REST APIs in EazyBank to CREATE,FETCH,UPDATE AND DELETE card details"
)


@RestController
@AllArgsConstructor
@Validated
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {

    private final ICardService iCardService;

    @Operation(
            summary = "REST API To Create Card Details",
            description = "REST API to create card in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Card created successfully",
                            content = @Content(
                               schema = @Schema(implementation = ResponseDto.class)
                            )

                    ),

                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )

                    )

            }


    )

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestBody CardDto cardDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCardService.createCard(cardDto));
    }


    @Operation(
            summary = "REST API to fetch card Details",
            description = "REST API for fetching card details in EazyBank",
             responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = CardDto.class)
                            )
                    ),
                     @ApiResponse(
                             responseCode = "500",
                             description = "Internal Server Error",
                             content = @Content(
                                     schema = @Schema(implementation = ErrorResponseDto.class)
                             )

                     )
             }
    )

    @GetMapping("/fetch")
    public ResponseEntity<CardDto> updateCard(@RequestParam String mobileOrCardNumber) {
      return   ResponseEntity.ok().body(iCardService.getCard(mobileOrCardNumber));
    }

    @Operation(
            summary = "REST API To Update Card Details",
            description = "REST API for updating card details in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Card updated successfully",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseDto.class)
                            )

                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )

                    ),

                    @ApiResponse(
                            responseCode = "404",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )
                    ),


                    @ApiResponse(
                            responseCode = "417",
                            description = "Exception fail",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseDto.class)
                            )

                    ),
            }

    )

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody CardDto cardDto) {
        boolean success = iCardService.updateCard(cardDto);
        if (success) {
            return ResponseEntity.ok().body(new ResponseDto(
                    CardConstants.STATUS_CODE_200,CardConstants.MESSAGE_200_UPDATE));
        }else {
            return ResponseEntity.ok().body(new ResponseDto(
                    CardConstants.STATUS_CODE_417,CardConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "REST API To Delete Card Details",
            description = "REST API for delete card details in EazyBank",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Card deleted successfully",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseDto.class)
                            )

                    ),
                    @ApiResponse(
                            responseCode = "417",
                            description = "Exception fail",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseDto.class)
                            )


                    ),

                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponseDto.class)
                            )

                    )
            }

    )

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam String mobileOrCardNumber) {
        boolean success = iCardService.deleteCard(mobileOrCardNumber);
        if (success) {
           return ResponseEntity.ok().body(new ResponseDto(
                   CardConstants.STATUS_CODE_200,CardConstants.MESSAGE_200_Delete));
        }else {
            return ResponseEntity.ok().body(new ResponseDto(
                    CardConstants.STATUS_CODE_417,CardConstants.MESSAGE_417_DELETE));
        }
    }
}
