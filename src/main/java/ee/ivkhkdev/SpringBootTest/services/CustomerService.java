package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.Customer;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppRepository;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements AppService {

    private final AppHelper<Customer> customerAppHelper;
    private final AppRepository<Customer> repository;

    @Autowired
    public CustomerService(AppHelper<Customer> customerAppHelper, AppRepository<Customer> repository) {
        this.customerAppHelper = customerAppHelper;
        this.repository = repository;
    }

    @Override
    public boolean add() {
        Optional<Customer> customer = customerAppHelper.create();
        return customer.filter(repository::save).isPresent();
    }
}
