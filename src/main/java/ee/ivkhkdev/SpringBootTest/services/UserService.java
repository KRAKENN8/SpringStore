package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.User;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppRepository;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements AppService{

    private final AppHelper<User> userAppHelper;
    private final AppRepository<User> repository;

    @Autowired
    public UserService(AppHelper<User> userAppHelper, AppRepository<User> repository) {
        this.userAppHelper = userAppHelper;
        this.repository = repository;
    }

    @Override
    public boolean add() {
        Optional<User> user = userAppHelper.create();
        return user.filter(repository::save).isPresent();
    }
}
