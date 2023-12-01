package Services;

import DTOs.CardDTO;
import Enums.CardStatus;
import Repositories.CardRepository;

import java.time.LocalDateTime;
import java.util.List;

public class CardService {
    CardRepository cardRepository = new CardRepository();
    public Boolean add(CardDTO cardDTO) {
        cardDTO.setCreatedAt(LocalDateTime.now());
        cardDTO.setStatus(CardStatus.Active);
        cardDTO.setBalance(0.0);
       return  cardRepository.add(cardDTO);
    }

     public List<CardDTO> getAllCards() {
        if(cardRepository.getAllCards().isEmpty()){
            System.out.println("no card");
            return null;
        }
       return cardRepository.getAllCards();

    }

    public Boolean changeStatus(String cardNumber) {

        return cardRepository.changeStatus(cardNumber);
    }
}
