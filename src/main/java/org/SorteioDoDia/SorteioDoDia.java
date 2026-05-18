package org.SorteioDoDia;

import org.Pedido.Cardapio;
import org.Pedido.ItemCardapio;

public class SorteioDoDia {

    static int itemCardapioSorteado = (int) (Math.random() * 6);
    static ItemCardapio itemSorteado = Cardapio.getItemCardapio(itemCardapioSorteado);
    static double precoOriginal = itemSorteado.getPreco();
    static double precoDesconto = itemSorteado.getPreco() * 0.80;

    public static void sorteioDoDia() {

        System.out.println("\n------ SORTEIO DO DIA ------");
        System.out.println("O item sorteado do dia: " + itemSorteado.getNome() + " está com 20% de desconto!");
        System.out.printf("Preço original: R$ %.2f%n", precoOriginal);
        System.out.printf("Preço com desconto: R$ %.2f%n", precoDesconto);
    }

    public static void descontoSorteado() {
        itemSorteado.setPreco(precoDesconto);
    }
}