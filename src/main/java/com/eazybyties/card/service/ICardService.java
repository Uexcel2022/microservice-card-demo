package com.eazybyties.card.service;

import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.exception.InvalidArgumentException;
import com.eazybyties.card.dto.ResponseDto;

public interface ICardService {

    /**
     * @param mobileNumber - mobileNumber
     * @return Returns response code and message with responseDto object
     */
    ResponseDto createCard(String mobileNumber);

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

    /**
     * @param mobileNumber - mobile number
     */
    default void validateMobileNumber(String mobileNumber) {
        boolean isValid = mobileNumber.matches(("^0[7-9][01][0-9]{8}$"));
        if(!isValid){
            throw new InvalidArgumentException(
                    String.format("Mobile number %s is invalid", mobileNumber));
        }

    }



}
