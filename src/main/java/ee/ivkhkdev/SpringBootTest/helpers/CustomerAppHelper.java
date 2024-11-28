package ee.ivkhkdev.SpringBootTest.helpers;

import ee.ivkhkdev.SpringBootTest.entities.Customer;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerAppHelper implements AppHelper<Customer> {
    private final Input input;

    @Autowired
    public CustomerAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public Optional<Customer> create() {
        Customer customer = new Customer();
        System.out.print("Имя клиента: ");
        customer.setName(input.nextLine());

        System.out.print("Email клиента: ");
        customer.setEmail(input.nextLine());

        return Optional.of(customer);
    }
}
