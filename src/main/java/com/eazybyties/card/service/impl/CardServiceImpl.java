package com.eazybyties.card.service.impl;

import com.eazybyties.card.constants.CardConstants;
import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.exception.UsedMobileNumberException;
import com.eazybyties.card.dto.ResponseDto;
import com.eazybyties.card.entity.Card;
import com.eazybyties.card.exception.CardNotValidException;
import com.eazybyties.card.exception.ResourceNotFoundException;
import com.eazybyties.card.mapper.CardMapper;
import com.eazybyties.card.repository.CardRepository;
import com.eazybyties.card.service.ICardService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;



@Service
@Transactional
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

    private final CardRepository cardRepository;

    /**
     * @param cardDto - holds card details
     * @return Returns response code and message with responseDto object
     */
    @Override
    public ResponseDto createCard(CardDto cardDto) {
        if(cardRepository.existsByMobileNumber(cardDto.getMobileNumber())) {
            throw new UsedMobileNumberException(cardDto.getMobileNumber());
        }
        long number = 100000000000L+ new Random().nextInt(900000000);
        Card card = new Card();
        card.setCardNumber(Long.toString(number));
        cardRepository
                .save(CardMapper.mapToCard(cardDto,card));
        return new ResponseDto(
                CardConstants.STATUS_CODE_201,CardConstants.MESSAGE_201
        );
    }

    /**
     * @param mobileOrCardNumber value - mobileNumber or cardNumber
     * @return Returns card information with CardDto object
     */
    @Override
    public CardDto getCardDetails(String mobileOrCardNumber) {
      Card card =  cardExists(mobileOrCardNumber);
        return CardMapper.mapToCardDto(card,new CardDto());
    }

    /**
     * @param cardDto - the requestBody object
     * @return Returns boolean value indicating whether care is update successfully or not
     */
    @Override
    public boolean updateCardDetails(CardDto cardDto) {
        if(cardDto.getCardNumber()== null ||
                cardDto.getCardNumber().length()<12) {
            throw new CardNotValidException("Invalid card number. It must be 12 digits");
        }
        Card card = cardExists(cardDto.getCardNumber());
        cardRepository.save(CardMapper.mapToCard(cardDto,card));
        return true;
    }

    /**
     * @param mobileOrCardNumber value - mobileNumber or cardNumber
     * @return Returns boolean value indicating whether care is delete successfully or not
     */
    @Override
    public boolean deleteCardDetails(String mobileOrCardNumber) {
        cardRepository.delete(cardExists(mobileOrCardNumber));
        return true;
    }

    public  Card cardExists(String mobileOrCardNumber){
       return   cardRepository.findByCardNumberOrMobileNumber(mobileOrCardNumber,mobileOrCardNumber)
                .orElseThrow(()->
                        new ResourceNotFoundException(
                                "Card","CordNumber or MobileNumber",mobileOrCardNumber));
      }

}
