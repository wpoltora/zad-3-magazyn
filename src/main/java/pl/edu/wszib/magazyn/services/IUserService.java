package pl.edu.wszib.magazyn.services;

import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
}
