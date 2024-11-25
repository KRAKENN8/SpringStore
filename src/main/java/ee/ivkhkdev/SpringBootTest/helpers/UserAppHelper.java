package ee.ivkhkdev.SpringBootTest.helpers;

import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.entities.User;
import ee.ivkhkdev.SpringBootTest.interfaces.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAppHelper implements AppHelper<User> {
    private final Input input;
    @Autowired
    public UserAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public Optional<User> create() {
        User user = new User();
        System.out.print("Имя пользователя: ");
        user.setName(input.nextLine());
        return Optional.of(user);
    }
}
