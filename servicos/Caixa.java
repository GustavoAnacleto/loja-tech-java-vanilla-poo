package servicos;

import entidades.Cliente;
import entidades.Produto;
import entidades.Venda;
import util.CalculadoraFinanceira;

public class Caixa{

	public void processarVenda(Venda venda){
		if(venda != null){
			venda.concluirVenda();
		}
	}

	public Venda criarVenda(Cliente cliente, Produto produto, int quantidade){
		return new Venda(cliente, produto, quantidade);
	}

	public void aplicarDescontoNoProduto(Produto produto, int porcentagem){
		if(produto != null){
			double novoPreco = CalculadoraFinanceira.aplicarDesconto(produto.getPreco(), porcentagem);

			produto.setPreco(novoPreco);
		}
	}

	public void tentarAlterarPreco(double preco){

		preco -= 100;
	}
}