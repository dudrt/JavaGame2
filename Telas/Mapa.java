package Telas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Mapa extends JPanel {
    Screen tela;
    public TitleScreen(Screen tela) {
        this.tela = tela;
        // Adiciona um rótulo ao JFrame
        JPanel panel = new JPanel();
        add(panel);
        JButton new_game = new JButton("Novo Jogo");
        JButton load_game = new JButton("Carregar Jogo");
        JButton credits = new JButton("Créditos");
        JButton close = new JButton("Sair");

        panel.add(new_game);
        panel.add(load_game);
        panel.add(credits);
        panel.add(close);
        panel.revalidate();
        panel.repaint();

        JLabel labelUsuario = new JLabel("Nome do seu personagem:");
        JTextField nameTextField = new JTextField(15);
        JButton send = new JButton(">");

        new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão for clicado
                panel.removeAll();
                tela.setPanelOnScreen(2);
                panel.add(labelUsuario);
                panel.add(nameTextField);
                panel.add(send);
                
                panel.revalidate();
                panel.repaint();

                send.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = nameTextField.getText();
                        // Bag bolsa = new Bag();
                        // Initial initial = new Initial(0, 0, "up");
                        // Player player = new Player(name, 50, 50, 10, 10, 10, 10, 10, 1, bolsa, initial);
                        tela.setPanelOnScreen(2);
                    }
                });
            }
        });

        load_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
            }
        });
    } 
}
