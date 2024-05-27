package Entidades;

public abstract class Enemy extends Entity {

    protected int id;

    public Enemy(int id, String image, String name, int HP, int maxHP, int attack, int defense, int speed) {
        super(image, name, HP, maxHP, attack, defense, speed);
        this.id = id;
    }

    public void getEnemyStats() {
        System.out.println(" ");
        System.out.println(this.name);
        System.out.println("HP: " + this.HP);
    }
}
