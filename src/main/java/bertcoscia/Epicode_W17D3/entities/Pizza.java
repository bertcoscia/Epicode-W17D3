package bertcoscia.Epicode_W17D3.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Pizza extends Item {
    private String name;
    private List<Topping> toppingList;
    private boolean isXl = false;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(700, 4.3);
        this.name = name;
        this.toppingList = toppingList;
        this.isXl = isXl;
    }

    /*@Override
    public int getCalories() {
        return super.getCalories() + this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
    }*/

    public void addTopping(Topping topping) {
        this.getToppingList().add(topping);
        this.setCalories(this.calories + topping.getCalories());
        this.setPrice(this.price + topping.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder toppingsBuilder = new StringBuilder();
        this.toppingList.forEach(topping -> toppingsBuilder.append(topping.getName()).append(", "));
        if (!toppingsBuilder.isEmpty()) {
            toppingsBuilder.setLength(toppingsBuilder.length() - 2);
        }
        return name + " (" + toppingsBuilder + ") " + calories + " kcal, $" + price;
    }
}
