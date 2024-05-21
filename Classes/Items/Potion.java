package Items;
import Jogador.Player;

public class Potion extends Item {

    static int id = 1;
    static String name = "Poção";
    static String type = "Cura";
    static int price = 10; // O price é preço para se comprar, para vender vou fazer price = price - price * 0.20.

    public Potion() {
        super(id, name, type, price);
    }

    public void useItem(Player player) {
        player.setHP(player.getHP() + 20);
        player.correctValues();
        System.out.println(" ");
        System.out.println("A poção curou 20 de HP de " + player.getName());
        System.out.println(" ");
    }
}