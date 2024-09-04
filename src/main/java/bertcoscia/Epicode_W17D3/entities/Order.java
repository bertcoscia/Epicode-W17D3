package bertcoscia.Epicode_W17D3.entities;

import bertcoscia.Epicode_W17D3.enums.State;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private int orderNumber;
    private State state;
    private int numCoperti;
    private LocalTime orderTime;
    private List<Item> orderedProducts;
    private Table table;

    public Order(int numCoperti, Table table) {
        Random random = new Random();
        if (table.getMaxCoperti() <= numCoperti)
            throw new RuntimeException("Numero coperti maggiore del numero massimo di coperti per il tavolo");
        this.orderNumber = random.nextInt(1000, 100000);
        this.state = State.IN_CORSO;
        this.numCoperti = numCoperti;
        this.orderTime = LocalTime.now();
        this.orderedProducts = new ArrayList<>();
        this.table = table;
    }

    public void addItem(Item item) { this.orderedProducts.add(item); }

    public double getTotal() {
        return this.orderedProducts.stream().mapToDouble(Item::getPrice).sum() + (this.table.getCostoCoperto() * this.numCoperti);
    }

    public void print() {
        System.out.println("Order n. " + this.orderNumber);
        System.out.println("State: " + this.state);
        System.out.println("Time: " + this.orderTime);
        System.out.println("Table n. " + this.table.getNumTable());
        System.out.println("List: ");
        this.orderedProducts.forEach(System.out::println);
        System.out.println("Total: $" + this.getTotal());
    }
}
