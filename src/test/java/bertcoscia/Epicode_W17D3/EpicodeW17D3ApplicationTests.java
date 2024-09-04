package bertcoscia.Epicode_W17D3;

import bertcoscia.Epicode_W17D3.entities.Menu;
import bertcoscia.Epicode_W17D3.entities.Pizza;
import bertcoscia.Epicode_W17D3.entities.Topping;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EpicodeW17D3ApplicationTests {

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EpicodeW17D3Application.class);

	@Test
	void contextLoads() {
	}

	@Test
	void testAddTopping(@Qualifier("toppings_salami") Topping topping) {
		Pizza pizza = (Pizza) ctx.getBean("pizza_margherita");
		pizza.addTopping(topping);
		List<Topping> result = pizza.getToppingList();
		assertTrue(result.contains(topping));
	}

	@Test
	void testAddAlreadyExistingTopping(@Qualifier("toppings_salami") Topping topping) {
		Pizza pizza = (Pizza) ctx.getBean("salami_pizza");
		Long initialSize = pizza.getToppingList().stream()
						.filter(topping1 -> topping1.getName().equals("Salami"))
								.count();
		pizza.addTopping(topping);
		Long resultSize = pizza.getToppingList().stream()
						.filter(topping1 -> topping1.getName().equals("Salami"))
								.count();
		assertNotEquals(resultSize, initialSize);
	}
}
