package Inimigos;
import Entidades.Enemy;

public class Orc extends Enemy {

    static int id = 3;
    static String image = "orc.png";
    static String name = "Orc";

    public Orc(int HP, int maxHP, int attack, int defense, int speed) {
        super(id, image,name, HP, maxHP, attack, defense, speed);
    }
}
