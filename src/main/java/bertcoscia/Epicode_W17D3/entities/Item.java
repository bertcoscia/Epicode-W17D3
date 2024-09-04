package bertcoscia.Epicode_W17D3.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    protected int calories;
    protected double price;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }
}
