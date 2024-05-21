package Items;

import Jogador.Player;
import Inimigos.Enemy;

public abstract class Item {
    protected int id;
    protected String name;
    protected String type;
    protected int price;

    public Item(int id, String name, String type, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public void useItem() {
        // Cada item vai ter sua função
    }

    public void useItem(Player player) {
        // Cada item vai ter sua função
    }

    public void useItem(Enemy enemy) {
        // Cada item vai ter sua função
    }
}
