package com.eazybyties.card.service;

import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.dto.ResponseDto;

public interface ICardService {

    /**
     * @param cardDto
     * @return Returns response code and message with responseDto object
     */
    ResponseDto createCard(CardDto cardDto);

    /**
     * @param mobileOrCardNumber value - mobileNumber or cardNumber
     * @return Returns card information with CardDto object
     */
    CardDto getCard(String mobileOrCardNumber);

    /**
     * @param mobileOrCardNumber value - mobileNumber or cardNumber
     * @return Returns boolean value indicating whether care is delete successfully or not
     */
    boolean deleteCard(String mobileOrCardNumber);

    /**
     * @param cardDto - the requestBody object
     * @return Returns boolean value indicating whether care is update successfully or not
     */
    boolean updateCard(CardDto cardDto);


}
