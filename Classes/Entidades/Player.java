package Entidades;

public class Player extends Entity {

    private int mana;
    private int maxMana;
    private int level;

    public Player(String image, String name, int HP, int maxHP, int attack, int defense, int mana, int maxMana, int speed, int level) {
        super(image, name, HP, maxHP, attack, defense, speed);
        this.mana = mana;
        this.maxMana = maxMana;
        this.level = level;
    }

    public void getPlayerStats() {
        System.out.println(" ");
        System.out.println(this.name);
        System.out.println("HP: " + this.HP);
        System.out.println("Mana: " + this.mana);
    }

    public int getLevel() {
        return this.level;
    }

    public int getMana() {
        return this.mana;
    }

    public int setMana(int mana){
        return this.mana = mana;
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
