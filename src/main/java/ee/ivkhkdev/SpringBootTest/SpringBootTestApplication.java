package ee.ivkhkdev.SpringBootTest;

import ee.ivkhkdev.SpringBootTest.interfaces.AppService;
import ee.ivkhkdev.SpringBootTest.interfaces.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication implements CommandLineRunner {

	private final Input input;
	private final AppService customerService;
	private final AppService petProductService;

	@Autowired
	public SpringBootTestApplication(Input input, AppService customerService, AppService petProductService) {
		this.input = input;
		this.customerService = customerService;
		this.petProductService = petProductService;
	}

	@Override
	public void run(String... args) {
		boolean repeat = true;
		do {
			System.out.println("Список задач: ");
			System.out.println("0. Выход");
			System.out.println("1. Добавить клиента");
			System.out.println("2. Добавить товар для животного");

			System.out.print("Выберите задачу из списка: ");
			int task = Integer.parseInt(input.nextLine());
			switch (task) {
				case 0:
					repeat = false;
					break;
				case 1:
					if (customerService.add()) {
						System.out.println("Клиент добавлен");
					} else {
						System.out.println("Не удалось добавить клиента");
					}
					break;
				case 2:
					if (petProductService.add()) {
						System.out.println("Товар для животного добавлен");
					} else {
						System.out.println("Не удалось добавить товар для животного");
					}
					break;
				default:
					System.out.println("Выбрана неверная задача!");
					break;
			}
		} while (repeat);
		System.out.println("До свидания");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
