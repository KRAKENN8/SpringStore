package ee.ivkhkdev.SpringBootTest.services;

import ee.ivkhkdev.SpringBootTest.entities.PetProduct;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.AppRepository;
import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetProductService implements AppService {
    private final AppHelper<PetProduct> petProductAppHelper;
    private final AppRepository<PetProduct> repository;

    @Autowired
    public PetProductService(AppHelper<PetProduct> petProductAppHelper, AppRepository<PetProduct> repository) {
        this.petProductAppHelper = petProductAppHelper;
        this.repository = repository;
    }

    @Override
    public boolean add() {
        Optional<PetProduct> petProduct = petProductAppHelper.create();
        return petProduct.filter(repository::save).isPresent();
    }
}
