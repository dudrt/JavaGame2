package Inimigos;
import Jogador.Player;

public abstract class Enemy {
    protected int id;
    protected String name;
    protected int maxHP;
    protected int HP;
    protected int attack;
    protected int defense;
    protected int speed;
    protected String image;

    public Enemy(int id, String name, int maxHP, int HP, int attack, int defense, int speed, String image) {
        this.id = id;
        this.name = name;
        this.maxHP = HP;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.image = image;
    }

    public int attackDamage(Player player) {
        int attackDamage;
        if(this.attack >=  player.getDefense()) {
            attackDamage = this.attack * 2 - player.getDefense();
        }
        else {
            attackDamage = this.attack * this.attack / player.getDefense();
        }
        return attackDamage;
    }

    public int enemyAttack(Player player) {
        int dano;
        if(this.HP > 0) {
            dano =  this.attackDamage(player);
        }
        else {
            dano = 0;
        }
        player.correctValues();
        return dano;
    }

    public void getEnemyStats() {
        System.out.println(" ");
        System.out.println(this.name);
        System.out.println("HP: " + this.HP);
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.HP;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getImage() {
        return this.image;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
