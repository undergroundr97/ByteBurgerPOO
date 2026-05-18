package org.SorteioDoDia;

import org.Pedido.Cardapio;
import org.Pedido.ItemCardapio;

public class SorteioDoDia {

    public static void sorteioDoDia() {

        int itemCardapioSorteado = (int) (Math.random() * 6);

        ItemCardapio itemSorteado = Cardapio.getItemCardapio(itemCardapioSorteado);

        double precoOriginal = itemSorteado.getPreco();

        double precoDesconto = precoOriginal * 0.80;

        System.out.println("\n------ SORTEIO DO DIA ------");
        System.out.println("O item sorteado do dia: " + itemSorteado.getNome() + " está com 20% de desconto!");
        System.out.printf("Preço original: R$ %.2f%n", precoOriginal);
        System.out.printf("Preço com desconto: R$ %.2f%n", precoDesconto);
    }
}