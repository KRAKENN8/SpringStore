package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.Product;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppRepository;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements AppService {
    private final AppHelper<Product> productAppHelper;
    private final AppRepository<Product> repository;

    @Autowired
    public ProductService(AppHelper<Product> productAppHelper, AppRepository<Product> repository) {
        this.productAppHelper = productAppHelper;
        this.repository = repository;
    }

    @Override
    public boolean add() {
        Optional<Product> product = productAppHelper.create();
        return product.filter(repository::save).isPresent();
    }
}
