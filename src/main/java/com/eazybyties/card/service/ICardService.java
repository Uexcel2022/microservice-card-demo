package com.eazybyties.card.service;

import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.exception.InvalidArgumentException;
import com.eazybyties.card.dto.ResponseDto;

public interface ICardService {

    /**
     * @param cardDto - holds card details
     * @return Returns response code and message with responseDto object
     */
    ResponseDto createCard(CardDto cardDto);

    /**
     * @param mobileOrCardNumber value - mobileNumber or cardNumber
     * @return Returns card information with CardDto object
     */
    CardDto getCardDetails(String mobileOrCardNumber);

    /**
     * @param mobileOrCardNumber value - mobileNumber or cardNumber
     * @return Returns boolean value indicating whether care is delete successfully or not
     */
    boolean deleteCardDetails(String mobileOrCardNumber);

    /**
     * @param cardDto - the requestBody object
     * @return Returns boolean value indicating whether care is update successfully or not
     */
    boolean updateCardDetails(CardDto cardDto);

    default void validateCordOrMobilNumber(String mobileOrCardNumber) {
       boolean isValid = mobileOrCardNumber.matches(("^[1-9][0-9]{11}|0[7-9][01][0-9]{8}$"));
       if(!isValid){
           throw new InvalidArgumentException(
                   String.format("Card or mobile number %s is invalid", mobileOrCardNumber));
       }
    }


}
