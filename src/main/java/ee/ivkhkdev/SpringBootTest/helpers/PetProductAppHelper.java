package ee.ivkhkdev.SpringBootTest.helpers;

import ee.ivkhkdev.SpringBootTest.entities.PetProduct;
import ee.ivkhkdev.SpringBootTest.interfaces.AppHelper;
import ee.ivkhkdev.SpringBootTest.interfaces.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PetProductAppHelper implements AppHelper<PetProduct> {

    private final Input input;

    @Autowired
    public PetProductAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public Optional<PetProduct> create() {
        PetProduct petProduct = new PetProduct();

        // Логика для ввода данных товара
        System.out.print("Имя товара: ");
        petProduct.setName(input.nextLine());

        System.out.print("Тип животного (собака, кошка и т.д.): ");
        petProduct.setAnimalType(input.nextLine());

        System.out.print("Цена товара: ");
        petProduct.setPrice(Double.parseDouble(input.nextLine()));

        return Optional.of(petProduct);
    }
}
