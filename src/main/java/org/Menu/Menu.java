package org.Menu;

public class Menu {
    public static void exibirMenu(){
        System.out.println("1 - Novo Pedido");
        System.out.println("2 - Consultar Cardapio por " +
                "Categoria");
        System.out.println("3 - Calcular Troco");
        System.out.println("4 - Sorteio do Dia");
        System.out.println("0 - Encerrar o Sistema");
        System.out.println("Digite opção:");
    }
    public static void exibirSubMenu(){
        System.out.println("-------------------");
        System.out.println("1 - Lanches");
        System.out.println("2 - Acompanhmentos");
        System.out.println("3 - Bebidas");
        System.out.println("0 - Voltar");
        System.out.println("Digite opção:");
    }
}
