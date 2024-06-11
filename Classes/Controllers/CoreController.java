package Controllers;

import Entidades.Enemy;

public class CoreController {
    MusicController musica = new MusicController();

    public static Enemy criarInimigo() {
        int inimigo = (int) (Math.random() * 50) + 1;
        if(inimigo < 10) {
            Enemy enemy = new Enemy(3, "orc.png", "Orc", 50, 50, 15, 10, 5);
            return enemy;
        }
        else if(inimigo > 10 && inimigo < 40) {
            Enemy enemy = new Enemy(3, "kobold.png", "Kobold", 15, 15, 7, 8, 15);
            return enemy;
        }
        else if(inimigo > 40 && inimigo < 80) {
            Enemy enemy = new Enemy(2, "goblin.png", "Goblin", 20, 20, 7, 6, 10);
            return enemy;
        }
        else {
            Enemy enemy = new Enemy(1, "bat.png", "Morcego", 5, 5, 5, 4, 20);
            return enemy;
        }
    }  

    public void Batalha() {
        musica.stop();
        musica.playAudio("./audio/battle.wav");
        battle = true;
        enemy = criarInimigo();
        OpcoesBatalha("LEFT");
        int[] arr = { 0, 0 };
        GerarTelaBatalha(arr);
    }
}
