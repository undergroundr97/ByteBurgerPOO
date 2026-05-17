package org.Pedido;

import javax.naming.CompositeName;
import java.util.ArrayList;

public class Pedido {
    private static Integer numeroTotalPedidos = 1;
    ArrayList<ItemCardapio> itensSelecionados;
    public String nome;
    private Double totalPedido = 0.0;
    public Pedido(String nome, ArrayList<ItemCardapio> itensSelecionados){
        this.nome = nome;
        this.itensSelecionados = itensSelecionados;
    }
    public Double getTotalPedido(){
        return totalPedido;
    }

    public void mostrarPedido(){
        System.out.println("------- RESUMO PEDIDO -------");
        System.out.println(" -> Numero do pedido: " + getNumeroTotalPedidos());
        System.out.println(" -> Nome: " + nome.toUpperCase());
        for (ItemCardapio itensSelecionado : itensSelecionados) {
            System.out.println(" -> " + itensSelecionado.getNome() + " - R$" + String.format("%.2f",
                    itensSelecionado.getPreco()) );
            totalPedido += itensSelecionado.getPreco();

        }
        System.out.println("----------- TOTAL ------------ ");
        System.out.println(" == Total do pedido: R$"+String.format("%.2f", getTotalPedido())+  " ");
    }

    public static void increaseNumeroPedidos(){
        numeroTotalPedidos++;
    }
    public static Integer getNumeroTotalPedidos() {
        return numeroTotalPedidos;
    }
}
