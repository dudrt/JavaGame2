package Inimigos;

import Entidades.Enemy;

public class Goblin extends Enemy {

    static int id = 2;
    static String image = "goblin.png";
    static String name = "Goblin";

    public Goblin(int HP, int maxHP, int attack, int defense, int speed) {
        super(id, image,name, HP, maxHP, attack, defense, speed);
    }
}
