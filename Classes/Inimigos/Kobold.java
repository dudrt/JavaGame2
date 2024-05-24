package Inimigos;

import Entidades.Enemy;

public class Kobold extends Enemy {

    static int id = 4;
    static String name = "Kobold";
    static int maxHP = 15;
    static int HP = 15;
    static int attack = 10;
    static int defense = 8;
    static int speed = 4;
    static String image = "kobold.png";

    public Kobold() {
        super(id, name, maxHP, HP, attack, defense, speed, image);
    }
}
