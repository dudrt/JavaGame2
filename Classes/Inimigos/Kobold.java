package Inimigos;

import Entidades.Enemy;

public class Kobold extends Enemy {

    static int id = 4;
    static String image = "kobold.png";
    static String name = "Kobold";

    public Kobold(int HP, int maxHP, int attack, int defense, int speed) {
        super(id, image,name, HP, maxHP, attack, defense, speed);
    }
}
