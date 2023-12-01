package Services;

import DTOs.User;
import Enums.UserRole;
import Enums.UserStatus;
import Repositories.LoginAndRegistrationRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LoginAndRegistrationService {

    LoginAndRegistrationRepository loginAndRegistrationRepository = new LoginAndRegistrationRepository();

    public Boolean register(User user){
        user.setUserStatus(UserStatus.Active);
        user.setRole(UserRole.User);
        user.setCreatedAt(LocalDateTime.now());

       return loginAndRegistrationRepository.Register(user);

    }

    public Boolean login(String phone, String password) {
        var check = loginAndRegistrationRepository.getUserByPhoneAndPassword(phone,password);
        return check != null;

    }
}
