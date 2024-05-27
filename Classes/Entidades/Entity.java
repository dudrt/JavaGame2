package Entidades;
public abstract class Entity {
    protected String image;
    protected String name;
    protected int HP;
    protected int maxHP;
    protected int attack;
    protected int defense;
    protected int speed;

    public Entity(String image, String name, int HP, int maxHP, int attack, int defense, int speed) {
        this.image = image;
        this.name = name;
        this.HP = HP;
        this.maxHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public String getImage() {
        System.out.println(this.image);
        return this.image;
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

    public int getMaxHp() {
        return this.maxHP;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String setImage(String image) {
        return this.image = image;
    }

    public int setHP(int HP){
        return this.HP = HP;
    }

    public void correctMaxHP() {
        if(this.HP > this.maxHP) {
            setHP(maxHP);
        }
    }

    public int Damage(Entity enemy) {
        int damage;
        if(this.attack >= enemy.getDefense()) {
            damage = this.attack * 2 - enemy.getDefense();
        }
        else {
            damage = this.attack * this.attack / enemy.getDefense();
        }
        return damage;
    }

    public int Attack(Entity enemy) {
        int dano;
        if(this.HP > 0) {
            dano = this.Damage(enemy);
        }
        else {
            dano = 0;
        }
        correctMaxHP();
        return dano;
    }
}
