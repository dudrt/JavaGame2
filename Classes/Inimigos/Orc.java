package Inimigos;

public class Orc extends Enemy {

    static int id = 3;
    static String name = "Orc";
    static String image = "orc.png";

    public Orc(int maxHP, int HP, int attack, int defense, int speed) {
        super(id, name, maxHP, HP, attack, defense, speed, image);
    }
}
