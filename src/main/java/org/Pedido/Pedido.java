package org.Pedido;

import javax.naming.CompositeName;
import java.util.ArrayList;

public class Pedido {
    ArrayList<ItemCardapio> itensSelecionados;
    String nome;

    public Pedido(String nome, ArrayList<ItemCardapio> itensSelecionados){
        this.nome = nome;
        this.itensSelecionados = itensSelecionados;
    }

    public void mostrarPedido(){
        System.out.println("---- RESUMO PEDIDO----");
        System.out.println("Nome: " + nome);
        for (ItemCardapio itensSelecionado : itensSelecionados) {
            System.out.println(" -> " + itensSelecionado.nome + " R$" + itensSelecionado.preco);
        }
    }

}
