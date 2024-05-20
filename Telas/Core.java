package Telas;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.OptionalInt;
import java.awt.*;

public class Core {
    private JFrame tela;
    private JPanel panel;
    private JLabel label;
    private boolean batle = false;
    int vidaInimigo = 100;
    int vidaPersonagem = 100;
    String[][] mapaArray = {
            { "|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", "$", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", ".", ".", "%", ".", ".", "|" },
            { "|", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", "|", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", "|", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", "|", "_", "_", "_", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", ".", "_", "_", "_", "_", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", "_", "_", "_", "_", "_", ".", ".", ".", "|", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|" },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", "_", "_", "|", },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", ".", ".", ".", },
            { "|", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "|", ".", ".", ".", },
            { "|", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "|", ".", ".", ".", }
    };

    String[][] opcoesBatalha = {
            { "Porrada", "Soco", "Tiro de Trabuco", "Paulada" },
            // {"Magia","Fogareu","Cura",""},
            { "Fugir", "", "", "" }
    };

    String[][] posicaoOpcoesBatalha = {
            { "P", "", "", "" },
            { "", "", "", "" }
    };

    public Core(JFrame tela) {
        this.tela = tela;
        initUI();
    }

    public void EscolherOpcaoBatalha(){
        int[] posicao = obterPosicoes();
        String opcao = opcoesBatalha[posicao[0]][posicao[1]];
        switch (opcao) {
            case "Porrada":
                //chamar as funcoes aqui
                break;
            default:
                break;
        }


    }

    public void OpcoesBatalha(String key) {
        int[] posicao = obterPosicoes();
        if (key.equals("RIGHT")) {
            if (posicao[1] < posicaoOpcoesBatalha[posicao[0]].length - 1) {
                posicaoOpcoesBatalha[posicao[0]][posicao[1] + 1] = "P";
                posicaoOpcoesBatalha[posicao[0]][posicao[1]] = "";
            }
        } else if (key.equals("LEFT")) {
            if (posicao[1] > 0) {
                posicaoOpcoesBatalha[posicao[0]][posicao[1] - 1] = "P";
                posicaoOpcoesBatalha[posicao[0]][posicao[1]] = "";
            }
        } else if (key.equals("DOWN")) {
            System.out.print(posicao[0]);
            if (posicao[0] < 1) {
                posicaoOpcoesBatalha[posicao[0]][posicao[1]] = "";
                posicaoOpcoesBatalha[posicao[0] + 1][posicao[1]] = "P";
            }
        } else if (key.equals("UP")) {
            System.out.print(posicao[0]);
            if (posicao[0] > 0) {
                posicaoOpcoesBatalha[posicao[0]][posicao[1]] = "";
                posicaoOpcoesBatalha[posicao[0] - 1][posicao[1]] = "P";
            }
        }
        int[] posicaoFinal = obterPosicoes();
        GerarTelaBatalha(posicaoFinal);
    }

    public int[] obterPosicoes() {
        int[] posicao = { 0, 0 };
        int posicao1 = 0;
        int posicao2 = 0;
        for (String[] linha : posicaoOpcoesBatalha) {
            posicao2 = 0;
            for (String elemento : linha) {
                if (elemento.equals("P")) {
                    posicao[0] = posicao1;
                    posicao[1] = posicao2;
                    break;
                }
                posicao2++;
            }
            posicao1++;
        }
        return posicao;
    }

    public void GerarTelaBatalha(int[] array) {
        StringBuilder tela = new StringBuilder("<html><head><style>")
                .append("table { border-collapse: collapse; margin:0px;margin: 0px; padding: 0px;border:0px }")
                .append("td { width: 150px; height: 150px; text-align: center; margin: 0px; padding: 0px;border-color:black}")
                .append(".vazio { background-color: transparent;width: 200px; height: 50px; }")
                .append(".jogador { background-color: transparent; color: white; }")
                .append(".inimigo { background-color: transparent; color: red; }")
                .append(".opcao { background-color: yellow; color: red; width: 50px; height: 50px;}")
                .append(".opcaoEscolhida { background-color: black; color: red; width: 50px; height: 50px;}")
                .append("</style></head><body><table>")
                .append("<tr><td class='vazio'><td class='vazio'></td><td class='vazio'>HP:"+vidaInimigo+"</td><td class='vazio'></tr>")
                .append("<tr><td class='vazio'><td class='vazio''>HP:"+vidaPersonagem+"</td><td class='inimigo'><img src='file:img/inimigo.png' width='200' height='250'></td><td class='vazio'></tr>")
                .append("<tr><td class='vazio'><td class='jogador'><img src='file:img/player.png' width='200' height='250'></td><td class='vazio'></td><td class='vazio'></tr>");

        int interacao = 0;
        for (String[] linha : opcoesBatalha) {
            tela.append("<tr>");
            int opcao = 0;
            for (String elemento : linha) {

                // System.out.println(array[0]+","+array[1]);
                if (array[0] == interacao && array[1] == opcao) {
                    tela.append("<td class='opcaoEscolhida'>" + elemento + "</td>");
                } else if (elemento.equals("")) {
                    tela.append("<td class='vazio'></td>");
                } else {
                    tela.append("<td class='opcao'>" + elemento + "</td>");
                }

                opcao++;
            }
            tela.append("</tr>"); // Fecha a linha da tabela
            interacao++;
        }

        label.setText(tela.toString()); // Atualizar o texto do JLabel com o novo mapa
        panel.revalidate(); // Atualizar o painel
        panel.repaint();

    }

    public void Batalha() {
        batle = true;
        OpcoesBatalha("LEFT");
        int[] arr = { 0, 0 };
        GerarTelaBatalha(arr);
    }

    private void initUI() {
        // Criação do painel
        JFrame frame = new JFrame("Eventos de Teclado - Setas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setFocusable(true); // Permitindo que o painel tenha o foco de entrada
        panel.requestFocusInWindow(); // Solicitando o foco de entrada imediatamente
        frame.add(panel);

        String mapa = MontarMapa();

        // Criação do JLabel com o texto
        label = new JLabel(mapa, SwingConstants.CENTER);
        label.setBounds(0, 0, tela.getWidth(), tela.getHeight());

        // Adiciona o JLabel ao painel
        panel.add(label);

        // Adiciona o painel à tela
        tela.add(panel);
        // Atualiza o painel
        panel.revalidate();
        panel.repaint();
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        if (!batle) {
                            RemontarMapa("UP");
                        }else {
                            OpcoesBatalha("UP");
                        }

                        break;
                    case KeyEvent.VK_DOWN:
                        if (!batle) {
                            RemontarMapa("DOWN");
                        }else {
                            OpcoesBatalha("DOWN");
                        }

                        break;
                    case KeyEvent.VK_LEFT:
                        if (!batle) {
                            RemontarMapa("LEFT");
                        } else {
                            OpcoesBatalha("LEFT");
                        }

                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!batle) {
                            RemontarMapa("RIGHT");
                        } else {
                            OpcoesBatalha("RIGHT");
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if (batle) {
                            EscolherOpcaoBatalha();
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
        });
    }

    public void RemontarMapa(String key) {

        boolean encontrou = false;
        int posiY = 0;
        int posiX = 0;

        for (String[] linha : mapaArray) {
            for (String elemento : linha) {
                if (elemento.equals("$")) {
                    System.out.println(posiY + "." + posiX);
                    encontrou = true;
                    switch (key) {
                        case "UP":
                            if (mapaArray[posiY - 1][posiX] != "_" && mapaArray[posiY - 1][posiX] != "|") {
                                if (mapaArray[posiY - 1][posiX] == "%") {

                                    Batalha();
                                    System.out.println("Batalha");
                                } else {

                                    mapaArray[posiY][posiX] = ".";
                                    mapaArray[posiY - 1][posiX] = "$";
                                }
                            }
                            break;
                        case "DOWN":
                            if (mapaArray[posiY + 1][posiX] != "_" && mapaArray[posiY + 1][posiX] != "|") {
                                if (mapaArray[posiY + 1][posiX] == "%") {
                                    Batalha();
                                    System.out.println("Batalha");
                                } else {
                                    mapaArray[posiY][posiX] = ".";
                                    mapaArray[posiY + 1][posiX] = "$";
                                }
                            }
                            break;
                        case "LEFT":
                            if (mapaArray[posiY][posiX - 1] != "|" && mapaArray[posiY][posiX - 1] != "_") {
                                if (mapaArray[posiY][posiX - 1] == "%") {
                                    Batalha();
                                    System.out.println("Batalha");
                                } else {
                                    mapaArray[posiY][posiX] = ".";
                                    mapaArray[posiY][posiX - 1] = "$";
                                }
                            }
                            break;
                        case "RIGHT":
                            if (mapaArray[posiY][posiX + 1] != "|" && mapaArray[posiY][posiX + 1] != "_") {
                                if (mapaArray[posiY][posiX + 1] == "%") {
                                    Batalha();
                                    System.out.println("Batalha");
                                } else {
                                    mapaArray[posiY][posiX] = ".";
                                    mapaArray[posiY][posiX + 1] = "$";
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (encontrou)
                    break;
                posiX++;
            }
            if (encontrou)
                break;
            posiX = 0;
            posiY++;
        }
        String novoMapa = MontarMapa(); // Obter o novo mapa
        label.setText(novoMapa); // Atualizar o texto do JLabel com o novo mapa
        panel.revalidate(); // Atualizar o painel
        panel.repaint();
    }

    public String MontarMapa() {

        StringBuilder mapaVisivel = new StringBuilder("<html><head><style>")
                .append("table { border-collapse: collapse; margin:0px;margin: 0px; padding: 0px;border:0px }")
                .append("td { width: 20px; height: 20px; text-align: center; margin: 0px; padding: 0px;border-color:black}")
                .append(".parede { background-color: black; }")
                .append(".vazio { background-color: white; }")
                .append(".nada { background-color: unset; }")
                .append(".jogador { background-color: blue; color: white; }")
                .append(".inimigo { background-color: red; color: red; }")
                .append("</style></head><body><table>");

        for (String[] linha : mapaArray) {
            mapaVisivel.append("<tr>");
            for (String elemento : linha) {
                switch (elemento) {
                    case ".":
                        mapaVisivel.append("<td class='vazio'></td>");
                        break;
                    case "|":
                    case "_":
                        mapaVisivel.append("<td class='parede'></td>");
                        break;
                    case "$":
                        mapaVisivel.append("<td class='jogador'>$</td>");
                        break;
                    case "%":
                        mapaVisivel.append("<td class='inimigo'>$</td>");
                        break;
                    case "":
                        mapaVisivel.append("<td class='nada'></td>");
                    default:
                        mapaVisivel.append("<td class='vazio'></td>");
                        break;
                }
            }
            mapaVisivel.append("</tr>"); // Fecha a linha da tabela
        }
        mapaVisivel.append("</table></body></html>");

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setText(mapaVisivel.toString());

        return mapaVisivel.toString();
    }
}
