package Controllers;

import DTOs.User;
import Services.LoginAndRegistrationService;

import java.util.Scanner;

public class LoginAndRegistrationController {
    UserController userController = new UserController();
    public void start(){
        boolean t = true;
        while (t){
            printMenu();
            int action = getAction();
            switch (action){
                case 1 :
                    login();
                    break;
                case 2:
                    registration();
                    break;
            }
        }

    }

    private void registration() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter name :");
        String name  = scanner.nextLine();

        System.out.println("enter the surname : ");
        String surname = scanner.nextLine();

        System.out.println("enter phone : ");
        String phone = scanner.nextLine();

        System.out.println("enter password : ");
        String password = scanner.nextLine();

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setPassword(password);

        LoginAndRegistrationService loginAndRegistrationService = new LoginAndRegistrationService();
      var isRegistred = loginAndRegistrationService.register(user);
      if(isRegistred){
          System.out.println("registreted successfully");
      }

    }

    private void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter phone :");
        String phone = scanner.nextLine();

        System.out.println("enter password  : ");
        String password = scanner.nextLine();

        LoginAndRegistrationService loginAndRegistrationService = new LoginAndRegistrationService();
        var isExist = loginAndRegistrationService.login(phone,password);
        if(!isExist){
            System.out.println("user is not found ");
        }else{
          userController.start();
        }


    }

    public void printMenu(){
        System.out.println("1=>Login");
        System.out.println("2=>Registration");
    }
    public Integer getAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("choose one of them : ");
        return scanner.nextInt();
    }
}
