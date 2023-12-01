import Controllers.LoginAndRegistrationController;
import Db.DbUtill;
import Services.LoginAndRegistrationService;

public class Main {
    public static void main(String[] args) {

        DbUtill.createUserTable();
        LoginAndRegistrationController loginAndRegistrationController = new LoginAndRegistrationController();
        loginAndRegistrationController.start();

    }
}