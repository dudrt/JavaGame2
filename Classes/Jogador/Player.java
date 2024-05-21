package Jogador;
import Inimigos.Enemy;

public class Player {

    private String name;
    private int HP;
    private int maxHP;
    private int attack;
    private int defense;
    private int mana;
    private int maxMana;
    private int speed;
    private int level;

    public Player(String name, int HP, int maxHP, int attack, int defense, int mana, int maxMana, int speed, int level) {
        this.name = name;
        this.HP = HP;
        this.maxHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.mana = mana;
        this.maxMana = maxMana;
        this.speed = speed;
        this.level = level;
    }

    public int attackDamage(Enemy enemy) {
        int damage;
        if(this.attack >= enemy.getDefense()) {
            damage = this.attack * 2 - enemy.getDefense();
        }
        else {
            damage = this.attack * this.attack / enemy.getDefense();
        }
        return damage;
    }

    public int playerAttack(Enemy enemy) {
        int dano;
        if(this.HP > 0) {
            dano = this.attackDamage(enemy);
        }
        else {
            dano = 0;
        }
        correctValues();
        return dano;
    }

    public void getPlayerStats() {
        System.out.println(" ");
        System.out.println(this.name);
        System.out.println("HP: " + this.HP);
        System.out.println("Mana: " + this.mana);
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getSpeed() {
        return this.speed;
    }
    
    public int getLevel() {
        return this.level;
    }

    public int getMana() {
        return this.mana;
    }

    public int setHP(int HP){
        return this.HP = HP;
    }

    public int setMana(int mana){
        return this.mana = mana;
    }

    public void correctMaxHP() {
        if(this.HP > this.maxHP) {
            setHP(maxHP);
        }
    }

    public void correctMaxMana() {
        if(this.mana > this.maxMana) {
            setMana(maxMana);
        }
        if(this.mana < 0) {
            this.mana = 0;
        }
    }

    public void correctValues() {
        correctMaxHP();
        correctMaxMana();
    }

    public void cura() {
        if(this.mana >= 7 && this.HP < this.maxHP) {
            setHP(getHP() + (int) (this.mana * 0.35));
            setMana(this.mana - 7);
            correctValues();
        }
    }
}
