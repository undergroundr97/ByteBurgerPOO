package org.Pedido;

import java.util.ArrayList;

public class Cardapio {
     static ArrayList<ItemCardapio> itensDoCardapio = new ArrayList<>();

     static {
        ItemCardapio item1 = new ItemCardapio("Byte Burger Classico", 22.90);
        ItemCardapio item2 = new ItemCardapio("Byte Burger Duplo", 29.90);
        ItemCardapio item3 = new ItemCardapio("Batata Frita P", 12.90);
        ItemCardapio item4 = new ItemCardapio("Batata Frita G", 18.90);
        ItemCardapio item5 = new ItemCardapio("Refrigerante Lata", 10.90);
        ItemCardapio item6 = new ItemCardapio("Agua", 7.90);
        itensDoCardapio.add(item1);
        itensDoCardapio.add(item2);
        itensDoCardapio.add(item3);
        itensDoCardapio.add(item4);
        itensDoCardapio.add(item5);
        itensDoCardapio.add(item6);
    }
    public static ItemCardapio getItemCardapio(Integer selecionado){
         return itensDoCardapio.get(selecionado);
    }
    public static void cardapioExibirLanches(){
        int index = 0;
        for (ItemCardapio item : itensDoCardapio) {
            if(index == 2){
                break;
            }
            System.out.println(" -> " + item.getNome() + " R$" + String.format("%.2f", item.getPreco()));
            index++;
        }
    }
    public static void cardapioExibirAcompanhamentos(){
         int index = 2;
        for (ItemCardapio item : itensDoCardapio) {
            item = itensDoCardapio.get(index);
            if (index == 4){
                break;
            }
            System.out.println(" -> " + item.getNome() + " R$" + String.format("%.2f", item.getPreco()));
            index++;
        }
    }

    public static void cardapioExibirBebidas(){
        int index = 4;
        for (ItemCardapio item : itensDoCardapio) {
            if (index == 6){
                break;
            }
            item = itensDoCardapio.get(index);

            System.out.println(" -> " + item.getNome() + " R$" + String.format("%.2f", item.getPreco()));
            index++;
        }
    }


    public static void exibirCardapio() {
         int index = 1;
        System.out.println("--------- CARDAPIO --------");
        for (ItemCardapio itemCardapio : itensDoCardapio) {
            System.out.println(index + " - " + itemCardapio.getNome() + " R$" + String.format( "%.2f",
                    itemCardapio.getPreco()));
            index++;
        }
        System.out.println("Digite sua opcao: ");
    }


}
