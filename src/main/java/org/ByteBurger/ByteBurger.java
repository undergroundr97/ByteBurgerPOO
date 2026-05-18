package org.ByteBurger;

import org.InputValidor.InputValidator;
import org.Menu.Menu;
import org.Pedido.Cardapio;
import org.Pedido.ItemCardapio;
import org.Pedido.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

import static org.InputValidor.InputValidator.getClienteInput;

public class ByteBurger {
    static Scanner scanner = new Scanner(System.in);
    public static void byteBurgerStart(){
        System.out.println("Bem vindo ao byteBurger");
        Menu.exibirMenu();
        Integer opcaoCliente = getClienteInput();
        Pedido pedido = new Pedido();
        do {
            switch (opcaoCliente) {
                case 0 -> {

                }
                case 1 -> {
                    ArrayList<ItemCardapio> itensPedido = new ArrayList<>();
                    System.out.println("Digite seu nome para identificacao do pedido: ");
                    String adicionarItemAoPedido;
                    String nomeProPedido = scanner.nextLine();
                    Pedido.increaseNumeroPedidos();
                    do {
                        Cardapio.exibirCardapio();
                        Integer itemSelecionado = getClienteInput();
                        itemSelecionado = InputValidator.inputInRange1to7(itemSelecionado);
                        itensPedido.add(Cardapio.getItemCardapio((itemSelecionado - 1)));
                        System.out.println(Cardapio.getItemCardapio((itemSelecionado - 1)).getNome() + " adicionado " +
                                "ao pedido.");
                        System.out.println("Deseja adicionar outro item ao pedido? (S/N)");
                        adicionarItemAoPedido = scanner.nextLine();
                        adicionarItemAoPedido = InputValidator.yesNoValidator(adicionarItemAoPedido);
                    } while (!adicionarItemAoPedido.equalsIgnoreCase("n"));
                    pedido = new Pedido(nomeProPedido, itensPedido);
                    pedido.adicionarValoresPedido();
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
                    opcaoCliente = getClienteInput();
                }
                case 2 -> {
                    Menu.exibirSubMenu();
                    Integer opcaoSubMenu = getClienteInput();
                    do {
                        switch(opcaoSubMenu){
                            case 0 -> {

                            }
                            case 1 -> {
                                Cardapio.cardapioExibirLanches();
                                System.out.println("Digite qualquer tecla para voltar");
                                String confirma = scanner.nextLine();
                                Menu.exibirSubMenu();
                                opcaoSubMenu = getClienteInput();
                            }
                            case 2 -> {
                                Cardapio.cardapioExibirAcompanhamentos();
                                System.out.println("Digite qualquer tecla para voltar");
                                String confirma = scanner.nextLine();
                                Menu.exibirSubMenu();
                                opcaoSubMenu = getClienteInput();
                            }
                            case 3 -> {
                                Cardapio.cardapioExibirBebidas();
                                System.out.println("Digite qualquer tecla para voltar");
                                String confirma = scanner.nextLine();
                                Menu.exibirSubMenu();
                                opcaoSubMenu = getClienteInput();
                            }
                            default ->{
                                System.out.println("Opção não encontrada!");
                                opcaoSubMenu = getClienteInput();
                            }
                        }
                    } while(opcaoSubMenu != 0);
                    Menu.exibirMenu();
                    opcaoCliente = getClienteInput();
                }
                case 3 -> {
                    Double valorRecebido = 0.0;
                    if(pedido.getTotalPedido() == 0.0){
                        System.out.println("Nenhum pedido a ser processado!");
                        Menu.exibirMenu();
                        opcaoCliente = getClienteInput();
                        break;
                    }
                    System.out.println("Seu pedido foi: ");
                    pedido.mostrarPedido();
                    System.out.println("Adicione fundos para realizar pagamento: ");
                    InputValidator.doubleValidator(scanner);
                    valorRecebido += scanner.nextDouble();
                    System.out.println("Você adicionou: R$" + valorRecebido);
                    while(valorRecebido < pedido.getTotalPedido()){
                        System.out.println("Valor insuficiente, adicione mais fundos!");
                        System.out.println("Fundos adicionados: R$" + valorRecebido);
                        InputValidator.doubleValidator(scanner);
                        valorRecebido += scanner.nextDouble();
                    }
                    try {
                        System.out.println("Pagamento suficente recebido, verificando troco...");
                        Thread.sleep(500);
                        if(valorRecebido > pedido.getTotalPedido()){
                            System.out.println("Troco de: " + String.format("%.2f",
                                    (valorRecebido - pedido.getTotalPedido())));
                            Thread.sleep(500);
                            System.out.println("Voltando ao menu...");
                            Thread.sleep(500);
                        } else {
                            System.out.println("Nenhum troco!");
                            Thread.sleep(500);
                            System.out.println("Voltando ao menu...");
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    pedido = new Pedido();
                    Menu.exibirMenu();
                    opcaoCliente = getClienteInput();
                }

            }
        } while (opcaoCliente != 0);
    }
//    static Integer getClienteInput(){
//        InputValidator.intValidator(scanner);
//        Integer input = scanner.nextInt();
//        scanner.nextLine();
//        return input;
//    }
}
