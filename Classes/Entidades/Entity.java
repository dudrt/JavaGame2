package Entidades;
public abstract class Entity {
    private String name;
    private int HP;
    private int maxHP;
    private int attack;
    private int defense;
    private int speed;

    public Entity(String name, int HP, int maxHP, int attack, int defense, int mana, int maxMana, int speed) {
        this.name = name;
        this.HP = HP;
        this.maxHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }
}
