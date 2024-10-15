package com.eazybyties.card.controller;

import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.dto.ResponseDto;
import com.eazybyties.card.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {
    private final ICardService iCardService;
    @RequestMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestBody CardDto cardDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCardService.createCard(cardDto));
    }
}
