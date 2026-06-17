import java.util.Scanner;

import entidades.Produto;
import entidades.Cliente;
import entidades.Venda;
import entidades.DemonstracaoAcesso;
import servicos.Caixa;
import servicos.GerenciadorEstoque;
import util.CalculadoraFinanceira;

public class Aplicacao {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=====================================");
		System.out.println("Testes da class Produto");
		System.out.println("=====================================");

		System.out.println("\n--- Teste 1: Construtores ---");

		Produto produtoA = new Produto();
		Produto produtoB = new Produto("Tenis Adidas", 450.00);
		Produto produtoC = new Produto("Tenis Puma", 350.00, 5);

		System.out.println(produtoA.obterInfo());
		System.out.println(produtoB.obterInfo());
		System.out.println(produtoC.obterInfo());

		System.out.println("\n--- Teste 2: Getters ---");

		System.out.println("Código do Tenis Adidas: " + produtoB.getCodigo());
		System.out.println("Nome do Produto A: " + produtoA.getNome());
		System.out.println("Preço do Tenis Puma: " + produtoC.getPreco());
		System.out.println("Estoque do Produto Tenis Puma: " + produtoC.getQuantidadeEstoque());

		System.out.println("Total de produtos criados: " + Produto.getTotalProdutosCriados());

		System.out.println("\nResumo dos testes 1 e 2:");
		System.out.println("Neste bloco foram testados os construtores e os getters da classe Produto.");
		System.out.println("Os construtores criaram objetos diferentes usando formas diferentes de inicialização.");
		System.out.println("O produtoA foi criado com o construtor vazio.");
		System.out.println("O produtoB foi criado com nome e preço.");
		System.out.println("O produtoC foi criado com nome, preço e quantidade em estoque.");
		System.out.println("Também foi possível observar que o código dos produtos foi gerado automaticamente.");
		System.out.println("Cada novo produto recebeu um código com incremento de 3 em 3.");
		System.out.println("Os getters foram usados para acessar os atributos privados de forma segura.");
		System.out.println("O total de produtos criados pertence à classe Produto, por isso foi acessado com Produto.getTotalProdutosCriados().");

		pausar(scanner);
		limparTela();

		scanner.close();
	}

	private static void pausar(Scanner scanner) {
    System.out.println("\nPressione ENTER para continuar...");
    scanner.nextLine();
	}

	private static void limparTela() {
	    for (int i = 0; i < 30; i++) {
	        System.out.println();
	    }
	}
}