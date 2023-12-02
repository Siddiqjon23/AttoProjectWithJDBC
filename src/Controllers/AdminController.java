package Controllers;

import DTOs.CardDTO;
import Services.CardService;

import java.util.Scanner;

public class AdminController {

    CardService cardService = new CardService();

    public  void start(){
        boolean t = true;
        while (t){
            printMenu();
            int command = getAction();
            switch (command){
                case 1:
                    createCard();
                    break;
                case 2:
                    getAllCards();
                    break;
            }
        }
    }

    private void getAllCards() {
        var allCards  =  cardService.getAllCards();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Card Number", "Exp. Date", "Balance", "Status", "Phone", "Created Date");

        // Print each card information
        for (CardDTO cardDTO : allCards) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    cardDTO.getCardNumber(), cardDTO.getExpiredDate(), cardDTO.getBalance(),
                    cardDTO.getStatus(), cardDTO.getPhone(), cardDTO.getCreatedAt());
        }
    }

    private void createCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter card number  : ");
        String cardNumber  = scanner.nextLine();

        System.out.println("enter expired date : ");
        String expiredDate = scanner.nextLine();

        CardDTO cardDTO = new CardDTO();
        cardDTO.setCardNumber(cardNumber);
        cardDTO.setExpiredDate(expiredDate);
        cardService.add(cardDTO);


    }
    public void printMenu(){
        System.out.println("***Admin menu***");
        System.out.println("1=>Create card");
        System.out.println("2=>Car lists");
        System.out.println("3=>Update");
        System.out.println("3=>change card status ");
        System.out.println("5=>delete");
        System.out.println();
        System.out.println("choose one of them :");
    }
    public Integer getAction(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
