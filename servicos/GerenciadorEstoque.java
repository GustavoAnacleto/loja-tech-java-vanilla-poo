package servicos;

import entidades.Produto;

public class GerenciadorEstoque {

    public void adicionarEstoque(Produto produto, int quantidade) {
        produto.setQuantidadeEstoque(
            produto.getQuantidadeEstoque() + quantidade
        );
    }

    public void removerEstoque(Produto produto, int quantidade) {
        if (produto.getQuantidadeEstoque() >= quantidade) {
            produto.setQuantidadeEstoque(
                produto.getQuantidadeEstoque() - quantidade
            );
        }
    }

    public void tentarAlterarEstoque(int estoque) {
        estoque += 100;
    }
}