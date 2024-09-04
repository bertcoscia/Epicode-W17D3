package bertcoscia.Epicode_W17D3.entities;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Topping {
    private String name;
    private int calories;
    private double price;

    public String toString() { return name + calories + price; }
}
