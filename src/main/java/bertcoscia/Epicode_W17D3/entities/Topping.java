package bertcoscia.Epicode_W17D3.entities;
import lombok.*;

import java.util.Timer;


@Setter
@Getter
@ToString
public class Topping extends Item {
    private String name;

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    public String toString() { return name + calories + price; }
}
