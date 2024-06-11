package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Telas.Core;

public class InputController implements KeyListener {
    Core core;

    public InputController(Core core) {
        this.core = core;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch (keyCode) {
        case KeyEvent.VK_UP:
            if (!core.battle) {
                core.RemontarMapa("UP");
            }else {
                core.OpcoesBatalha("UP");
            }

            break;
        case KeyEvent.VK_DOWN:
            if (!core.battle) {
                core.RemontarMapa("DOWN");
            }else {
                core.OpcoesBatalha("DOWN");
            }

            break;
        case KeyEvent.VK_LEFT:
            if (!core.battle) {
                core.RemontarMapa("LEFT");
            } else {
                core.OpcoesBatalha("LEFT");
            }

            break;
        case KeyEvent.VK_RIGHT:
            if (!core.battle) {
                core.RemontarMapa("RIGHT");
            } else {
                core.OpcoesBatalha("RIGHT");
            }
            break;
        case KeyEvent.VK_ENTER:
            if (core.battle) {
                core.EscolherOpcaoBatalha();
                core.panel.revalidate(); // Atualizar o painel
                core.panel.repaint();
            }
        default:
            break;
    }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Método necessário para a interface KeyListener
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Método necessário para a interface KeyListener
    } 
}
