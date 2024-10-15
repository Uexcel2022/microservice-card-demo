package com.eazybyties.card.service;

import com.eazybyties.card.constants.CardConstants;
import com.eazybyties.card.dto.CardDto;
import com.eazybyties.card.dto.ResponseDto;
import com.eazybyties.card.entity.Card;
import com.eazybyties.card.mapper.CardMapper;
import com.eazybyties.card.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

    private final CardRepository cardRepository;

    /**
     * @param cardDto
     * @return returns response code and message with responseDto object
     */
    @Override
    public ResponseDto createCard(CardDto cardDto) {
        cardRepository
                .save(CardMapper.mapToCard(cardDto,new Card()));
        return new ResponseDto(
                CardConstants.STATUSCODE_201,CardConstants.MESSAGE_201
        );
    }
}
