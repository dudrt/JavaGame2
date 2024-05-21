package Inimigos;

public class Orc extends Enemy {

    static int id = 3;
    static String name = "Orc";
    static int maxHP = 40;
    static int HP = 40;
    static int attack = 12;
    static int defense = 7;
    static int speed = 4;
    static String image = "orc.png";

    public Orc() {
        super(id, name, maxHP, HP, attack, defense, speed, image);
    }
}
