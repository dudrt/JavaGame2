package Inimigos;

public class Bat extends Enemy {

    static int id = 1;
    static String name = "Morcego";
    static int maxHP = 10;
    static int HP = 10;
    static int attack = 5;
    static int defense = 5;
    static int speed = 5;
    static String image = "bat.png";
    
    public Bat() {
        super(id, name, maxHP,HP, attack, defense, speed, image);
    }
}
