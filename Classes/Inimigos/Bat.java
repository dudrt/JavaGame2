package Inimigos;

import Entidades.Enemy;

public class Bat extends Enemy {

    private static int id = 1;
    private static String image = "bat.png";
    private static String name = "Morcego";
    
    public Bat(int HP, int maxHP, int attack, int defense, int speed) {
        super(id, image,name, HP, maxHP, attack, defense, speed);
    }
}
