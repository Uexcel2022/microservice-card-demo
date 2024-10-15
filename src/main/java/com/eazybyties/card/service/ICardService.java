package com.eazybyties.card.service;

import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.dto.ResponseDto;

public interface ICardService {

    /**
     * @param cardDto
     * @return returns response code and message with responseDto object
     */
    ResponseDto createCard(CardDto cardDto);
}
