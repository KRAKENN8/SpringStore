package ee.ivkhkdev.SpringBootTest.helpers;

import ee.ivkhkdev.SpringBootTest.entities.Product;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductAppHelper implements AppHelper<Product> {
    @Override
    public Optional<Product> create() {
        return Optional.empty();
    }
}
