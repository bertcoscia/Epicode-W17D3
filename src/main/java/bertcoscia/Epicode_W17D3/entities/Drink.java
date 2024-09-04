package bertcoscia.Epicode_W17D3.entities;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Drink {
    private String name;
    private int calories;
    private double price;

    @Override
    public String toString() { return name + calories + price;}
}
