package br.joaonascimento.model;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private Fornecedor fornecedor;

    public Produto(int codigo, String descricao, double preco, int quantidade, Fornecedor fornecedor) {
        if(codigo < 0){
            throw new IllegalArgumentException("Codigo não pode ser negativo!");
        }
        if(preco < 0){
            throw new IllegalArgumentException("Preço não pode ser negativo!");
        }
        if(quantidade < 0){
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        }

        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        if(codigo < 0){
            throw new IllegalArgumentException("Codigo não pode ser negativo!");
        }
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if(preco < 0){
            throw new IllegalArgumentException("Preço não pode ser negativo!");
        }
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if(quantidade < 0){
            throw new IllegalArgumentException("Quantidade não pode ser negativo!");
        }

        this.quantidade = quantidade;
    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade="
                + quantidade + ", fornecedor=" + fornecedor + "]";
    }
    
}
