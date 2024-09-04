package bertcoscia.Epicode_W17D3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Table {
    private int numTable;
    private int maxCoperti;
    private boolean isFree;
    private double costoCoperto;

    public void print() {
        System.out.println("Table n. " + numTable);
        System.out.println("Max. coperti: " + maxCoperti);
        System.out.println("Free/Busy : " + (this.isFree ? "Free" : "Busy"));
    }
}
