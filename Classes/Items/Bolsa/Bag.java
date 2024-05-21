package Items.Bolsa;
import java.util.HashMap;
import java.util.Scanner;

import Items.Item;
import Jogador.Player;

public class Bag {
    private HashMap<Integer, Integer> bag; // Para Eduardo. o HashMap é o Dictionary do Python, só que mais chato.
    private HashMap<Integer, Item> itemMap; // Mapeia ID do item para o objeto Item correspondente

    public Bag() {
        bag = new HashMap<>();
        itemMap = new HashMap<>();
    }

    public void addItems(Item item, int quantity) {
        int id = item.getId();
        if (bag.containsKey(id)) {
            int currentQuantity = bag.get(id);
            bag.put(id, currentQuantity + quantity);
        } else {
            bag.put(id, quantity);
            itemMap.put(id, item); // Mapeia o ID do item para o objeto Item correspondente
        }
    }

    public void removeItems(Item item, int quantity) {
        int id = item.getId();
        if (bag.containsKey(id)) {
            int currentQuantity = bag.get(id);
            bag.put(id, currentQuantity - quantity);
        } else {
            bag.remove(id, quantity);
            bag.remove(id, item); // Mapeia o ID do item para o objeto Item correspondente
        }
    }

    public void displayItems(Player player) {
        System.out.println("Itens na bolsa:");
        System.out.println(" ");
        for (Integer id : bag.keySet()) {
            Item item = itemMap.get(id); // Obtém o objeto Item correspondente ao ID
            int quantity = bag.get(id);
            System.out.println("Id " + item.getId() + ", Nome: " + item.getName() + ", Quantidade: " + quantity);
        }
        System.out.println(" ");
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Usar algum item");
        System.out.println("2 - Voltar para batalha.");
        int escolha = scan.nextInt();
        if(escolha == 1) {
            useItem(player);
        }
    }

    public void useItem(Player player) {
        System.out.println(" ");
        System.out.println("Escolha o item: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        Item item = itemMap.get(id);
        if(item != null) {
            item.useItem(player);
            removeItems(item, id);
        }
        else {
            System.out.println("Valor inválido");
            useItem(player);
        }
    }
}
