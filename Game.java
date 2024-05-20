import javax.swing.JFrame;

import Telas.Core;
public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de JLabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        // Criação da instância da classe que adiciona o JLabel
        new Core(frame);
        
        // Exibe a tela
        frame.setVisible(true);
    }
    }
