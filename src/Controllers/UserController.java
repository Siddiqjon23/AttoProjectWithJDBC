package Controllers;

import DTOs.CardDTO;
import Services.CardService;

import java.util.Scanner;

public class UserController {
    CardService cardService = new CardService();

    public void start(){

        boolean t = true;
        while (t){
            printMenu();
            int command = getAction();
            switch (command){
                case 1:
                    addCard();
                    break;
                case 2:
                    cardLists();
                    break;
                case 3:
                    changeStatus();
                    break;
            }
        }
    }

    private void changeStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter card number : ");
        String cardNumber = scanner.nextLine();

       var isStatusChanged =  cardService.changeStatus(cardNumber);
       if(isStatusChanged){
           System.out.println("changed successfully");
       }

    }

    private void cardLists() {
      var allCards  =  cardService.getAllCards();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Card Number", "Exp. Date", "Balance", "Status", "Phone", "Created Date");

        // Print each card information
        for (CardDTO cardDTO : allCards) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    cardDTO.getCardNumber(), cardDTO.getExpiredDate(), cardDTO.getBalance(),
                    cardDTO.getStatus(), cardDTO.getPhone(), cardDTO.getCreatedAt());
        }
    }

    private void addCard() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        // number,exp_date,balance,status,phone,created_date
        System.out.println("enter card number : ");
        String cardNumber = scanner.nextLine();

        System.out.println("enter expired date : ");
        String expiredDate = scanner.nextLine();

        CardDTO cardDTO = new CardDTO();
        cardDTO.setCardNumber(cardNumber);
        cardDTO.setExpiredDate((expiredDate));


       Boolean isAdded =   cardService.add(cardDTO);
       if(isAdded){
           System.out.println("added successfully");
       }



    }

    public void printMenu(){
        System.out.println("1=>Add card");
        System.out.println("2=>Car lists");
        System.out.println("3=>Card change status");
        System.out.println("4=>delete card ");
        System.out.println("5=>refill");
        System.out.println();
        System.out.println("choose one of them :");

    }
    public Integer getAction(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
