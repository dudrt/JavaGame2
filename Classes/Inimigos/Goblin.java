package Inimigos;

public class Goblin extends Enemy {

    static int id = 2;
    static String name = "Goblin";
    static int maxHP = 20;
    static int HP = 20;
    static int attack = 7;
    static int defense = 7;
    static int speed = 4;
    static String image = "goblin.png";

    public Goblin() {
        super(id, name, maxHP, HP, attack, defense, speed, image);
    }
}
