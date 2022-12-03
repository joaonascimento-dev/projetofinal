package br.joaonascimento.model;

import java.util.ArrayList;
import java.util.List;

public class Cesta {
    private List<Produto> itens = new ArrayList<>();

    //Adicionei o get da lista para poder verificar se não está vazia
    public List<Produto> getItens() {
        return itens;
    }

    public void adicionarItem(Produto p) {
        itens.add(p);
    }

    private double calcularTotal() {
        return itens.stream().mapToDouble(p -> p.getPreco()).sum();
    }

    //Era void mas eu troquei para String para poder usar dentro do JOptionPane
    public String exibirLista() {
        String lista = "";
        for (Produto produto : itens) {
            lista += produto.toString() + "\r\n";
        }
        lista += "\r\n\r\nTotal: " + calcularTotal();
        return lista;
    }

    
}
