package org.SwitchUserInput;

import com.sun.source.doctree.EscapeTree;
import org.InputValidor.InputValidator;
import org.Menu.Menu;
import org.Pedido.Cardapio;
import org.Pedido.ItemCardapio;
import org.Pedido.Pedido;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SwitchInput {
    static Scanner scanner = new Scanner(System.in);
    public static void clienteInput(Integer input){
        Pedido pedido;
        do {
            switch (input) {
                case 0 -> {
                    break;
                }
                case 1 -> {
                    ArrayList<ItemCardapio> itensPedido = new ArrayList<>();
                    System.out.println("Digite seu nome para identificacao do pedido: ");
                    String adicionarItemAoPedido;
                    String nomeProPedido = scanner.nextLine();;
                    do {
                        Cardapio.getCardapio();
                        InputValidator.intValidator(scanner);
                        Integer itemSelecionado = scanner.nextInt();
                        itemSelecionado = InputValidator.inputInRange1to7(itemSelecionado);
                        scanner.nextLine();
                        itensPedido.add(Cardapio.getItemCardapio((itemSelecionado - 1)));
                        System.out.println(Cardapio.getItemCardapio((itemSelecionado - 1)).getNome() + " adicionado " +
                                "ao pedido.");
                        System.out.println("Deseja adicionar outro item ao pedido? (S/N)");
                        adicionarItemAoPedido = scanner.nextLine();
                        adicionarItemAoPedido = InputValidator.yesNoValidator(adicionarItemAoPedido);
                    } while (!adicionarItemAoPedido.equals("n"));
                    pedido = new Pedido(nomeProPedido, itensPedido);
                    pedido.mostrarPedido();
                    System.out.println("Confirmar Pedido? (TECLA N CANCELA PEDIDO)");
                    String confirmarPedido = scanner.nextLine();
                    if(confirmarPedido.equalsIgnoreCase("n")){
                        pedido = null;
                        try {
                            System.out.println("Cancelando pedido...");
                            Thread.sleep(900);
                            System.out.println("Pedido cancelado com sucesso!");
                            Thread.sleep(700);
                            System.out.println("Voltando ao menu...");
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        try {
                            Pedido.increaseNumeroPedidos();
                            System.out.println("Processando pedido, aguarde...");
                            Thread.sleep(900);
                            System.out.println("Pedido realizado com sucesso!");
                            Thread.sleep(700);
                            System.out.println("Obrigado pela preferência!");
                            Thread.sleep(700);
                            System.out.println("Voltando ao menu...");
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Menu.exibirMenu();
                    InputValidator.intValidator(scanner);
                    input = scanner.nextInt();
                    scanner.nextLine();
                }

            }
        } while (input != 0);
    }
}
