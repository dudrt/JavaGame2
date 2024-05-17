import javax.swing.JFrame;

import Telas.MinhaClasse;
public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        // Criação da instância da classe que adiciona o JLabel
        new MinhaClasse(frame);
        
        // Exibe a tela
        frame.setVisible(true);
    }
    }
