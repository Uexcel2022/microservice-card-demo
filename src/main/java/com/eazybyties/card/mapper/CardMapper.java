package com.eazybyties.card.mapper;

import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.entity.Card;

import java.util.Random;

public class CardMapper {

    public static Card mapToCard(CardDto cardDto, Card card) {
        card.setCardType(cardDto.getCardType());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setMobileNumber(cardDto.getMobileNumber());
        return card;
    }

    public static CardDto mapToCardDto(Card card, CardDto cardDto) {
        cardDto.setCardType(card.getCardType());
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setCardNumber(card.getCardNumber());
        return cardDto;
    }

}


//private String cardNumber;
//private String mobileNumber;
//private String cardType;
//private int totalLimit;
//private int amountUsed;
//private int availableAmount;