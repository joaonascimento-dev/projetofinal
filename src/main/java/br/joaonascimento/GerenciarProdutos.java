package br.joaonascimento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import br.joaonascimento.model.Cesta;
import br.joaonascimento.model.Contato;
import br.joaonascimento.model.Fornecedor;
import br.joaonascimento.model.Produto;

public class GerenciarProdutos {
        public static void main(String[] args) {

                // Obs: Na tarefa no Teams dizia que não precisava de interface gráfica, mas no
                // documento falava pra fazer, então fiquei no meio termo e usei JOptionPanes

                List<Fornecedor> listFornecedor = new ArrayList<>();
                List<Produto> listProduto = new ArrayList<>();
                // List<Cesta> listCesta = new ArrayList<>();
                Cesta cesta = new Cesta();

                int controlador = 0;
                do {
                        try {

                                String resposta = JOptionPane.showInputDialog(null,
                                                "Escolha uma opção: \r\n"
                                                                + "1 - Cadastrar Fornecedor \r\n"
                                                                + "2 - Cadastrar Produto \r\n"
                                                                + "3 - Cadastrar Cesta \r\n"
                                                                + "4 - Listar Cesta \r\n"
                                                                + "0 - Sair",
                                                "Menu Gerenciar Produtos", JOptionPane.PLAIN_MESSAGE);

                                switch (resposta) {
                                        case "1":
                                                controlador = 1;
                                                String codigoFornecedor = JOptionPane.showInputDialog(null,
                                                                "Informe o código:",
                                                                "Cadastrar Fornecedor", JOptionPane.PLAIN_MESSAGE);
                                                String razaoSocial = JOptionPane.showInputDialog(null,
                                                                "Informe a razão social:",
                                                                "Cadastrar Fornecedor", JOptionPane.PLAIN_MESSAGE);
                                                String endereco = JOptionPane.showInputDialog(null,
                                                                "Informe o endereço:",
                                                                "Cadastrar Fornecedor",
                                                                JOptionPane.PLAIN_MESSAGE);

                                                Contato contato = null;

                                                if (JOptionPane.showConfirmDialog(null,
                                                                "Deseja informar o contato do fornecedor?", "Confirmar",
                                                                JOptionPane.YES_NO_OPTION) == 0) {
                                                        String nome = JOptionPane.showInputDialog(null,
                                                                        "Informe o nome do contato:",
                                                                        "Cadastrar Contato",
                                                                        JOptionPane.PLAIN_MESSAGE);
                                                        String telefone = JOptionPane.showInputDialog(null,
                                                                        "Informe o telefone:",
                                                                        "Cadastrar Contato",
                                                                        JOptionPane.PLAIN_MESSAGE);
                                                        String email = JOptionPane.showInputDialog(null,
                                                                        "Informe o email:",
                                                                        "Cadastrar Contato",
                                                                        JOptionPane.PLAIN_MESSAGE);
                                                        contato = new Contato();
                                                        contato.setNome(nome);
                                                        contato.setTelefone(telefone);
                                                        contato.setEmail(email);
                                                }
                                                
                                                Fornecedor fornecedor = new Fornecedor(
                                                                Integer.parseInt(codigoFornecedor), razaoSocial,
                                                                endereco,
                                                                contato);
                                                listFornecedor.add(fornecedor);
                                                break;
                                        case "2":
                                                controlador = 2;
                                                if (listFornecedor.isEmpty()) {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Cadastre ao menos um fornecedor para prosseguir!",
                                                                        "Atenção", JOptionPane.WARNING_MESSAGE);
                                                        break;
                                                }
                                                String fornecedoresDisponiveis = "";
                                                for (Fornecedor f : listFornecedor) {
                                                        fornecedoresDisponiveis += f.getCodigo() + " - "
                                                                        + f.getRazaoSocial() + "\r\n";
                                                }

                                                String codigoProduto = JOptionPane.showInputDialog(null,
                                                                "Informe o código:",
                                                                "Cadastrar Produto",
                                                                JOptionPane.PLAIN_MESSAGE);
                                                String descricao = JOptionPane.showInputDialog(null,
                                                                "Informe a descrição:",
                                                                "Cadastrar Produto",
                                                                JOptionPane.PLAIN_MESSAGE);
                                                String preco = JOptionPane.showInputDialog(null, "Informe o preço:",
                                                                "Cadastrar Produto",
                                                                JOptionPane.PLAIN_MESSAGE);
                                                String quantidade = JOptionPane.showInputDialog(null,
                                                                "Informe a quantidade:",
                                                                "Cadastrar Produto",
                                                                JOptionPane.PLAIN_MESSAGE);
                                                String codigoFornecedorProduto = JOptionPane.showInputDialog(null,
                                                                "Informe o código do fornecedor: \r\n"
                                                                                + fornecedoresDisponiveis,
                                                                "Cadastrar Produto",
                                                                JOptionPane.PLAIN_MESSAGE);

                                                Produto produto = new Produto(Integer.parseInt(codigoProduto),
                                                                descricao,
                                                                Double.parseDouble(preco),
                                                                Integer.parseInt(quantidade),
                                                                listFornecedor.stream()
                                                                                .filter(f -> f.getCodigo() == Integer
                                                                                                .parseInt(codigoFornecedorProduto))
                                                                                .collect(Collectors.toList()).get(0));
                                                listProduto.add(produto);
                                                break;
                                        case "3":
                                                controlador = 3;
                                                if (listProduto.isEmpty()) {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Cadastre ao menos um produto para prosseguir!",
                                                                        "Atenção",
                                                                        JOptionPane.WARNING_MESSAGE);
                                                        break;
                                                }
                                                String produtosDisponiveis = "";
                                                for (Produto p : listProduto) {
                                                        produtosDisponiveis += p.getCodigo() + " - " + p.getDescricao()
                                                                        + "\r\n";
                                                }

                                                cesta = new Cesta();

                                                boolean sair = false;
                                                while (!sair) {
                                                        String codigoProdutoCesta = JOptionPane.showInputDialog(null,
                                                                        "Informe o código do produto: \r\n"
                                                                                        + produtosDisponiveis,
                                                                        "Cadastrar Cesta",
                                                                        JOptionPane.PLAIN_MESSAGE);
                                                        Produto produtoCesta = listProduto.stream()
                                                                        .filter(p -> p.getCodigo() == Integer
                                                                                        .parseInt(codigoProdutoCesta))
                                                                        .collect(Collectors.toList()).get(0);

                                                        cesta.adicionarItem(produtoCesta);

                                                        if (JOptionPane.showConfirmDialog(null,
                                                                        "Deseja inserir outro produto?", "Confirmar",
                                                                        JOptionPane.YES_NO_OPTION) != 0) {
                                                                sair = true;
                                                        }
                                                }
                                                break;

                                        case "4":
                                                controlador = 4;
                                                if (cesta.getItens().isEmpty()) {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "Insira ao menos um produto na cesta para prosseguir!",
                                                                        "Atenção",
                                                                        JOptionPane.WARNING_MESSAGE);
                                                        break;
                                                }
                                                JOptionPane.showMessageDialog(null, cesta.exibirLista(), "Total",
                                                                JOptionPane.PLAIN_MESSAGE);
                                                break;
                                        case "0":
                                                controlador = 0;
                                                break;
                                        default:
                                                JOptionPane.showMessageDialog(null, "Insira um valor válido!",
                                                                "Atenção",
                                                                JOptionPane.WARNING_MESSAGE);
                                                controlador = 1;
                                                break;
                                }
                        } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                                "Ocorreu um Erro: \r\n" + e + "\r\n\r\nTente novamente", "Erro",
                                                JOptionPane.ERROR_MESSAGE);
                                controlador = 1;
                        }
                } while (controlador != 0);

        }
}
