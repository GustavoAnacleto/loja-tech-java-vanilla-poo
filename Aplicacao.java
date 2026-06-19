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

		System.out.println("\n--- Teste 3: Setters com valores válidos ---");

		System.out.println("Produto A antes das alterações:");
		System.out.println(produtoA.obterInfo());

		produtoA.setNome("Tênis Nike");
		produtoA.setPreco(550.00);
		produtoA.setQuantidadeEstoque(10);

		System.out.println("Produto A depois das alterações válidas:");
		System.out.println(produtoA.obterInfo());

		System.out.println("\n--- Teste 4: Setters com valores inválidos ---");	
		
		produtoA.setNome("");
		produtoA.setPreco(-550.00);
		produtoA.setQuantidadeEstoque(-10);	

		System.out.println("Produto A depois das tentativas inválidas:");
		System.out.println(produtoA.obterInfo());

		System.out.println("\n\n\nResumo dos teste 3 e 4:");
		System.out.println("Neste bloco foram testados os setters da classe Produto.");
		System.out.println("Primeiro, alterei o produtoA com valores válidos.");
		System.out.println("Depois, Tentei alterar o mesmo produto com valores inválidos para testar as validações aplicadas na classe Produto.");
		System.out.println("Como os atributos da classe Produto são privado, a alteração passa pelos setters.");
		System.out.println("Os setters protegem o objeto contra dados ruins, podendo serem fortemente validados, como nome vazio, número negativo e etc.");

		pausar(scanner);
		limparTela();

		System.out.println("\n--- Teste 5: Desconto com valor fixo ---");

		System.out.println("Antes do Desconto:");
		System.out.println(produtoB.obterInfo());

		produtoB.aplicarDesconto(50.00);

		System.out.println("Depois do desconto de R$ 50.00:");
		System.out.println(produtoB.obterInfo());

		System.out.println("\n--- Teste 6: Desconto com valor inválido ---");
		produtoB.aplicarDesconto(0.00);
		produtoB.aplicarDesconto(-10.00);
		produtoB.aplicarDesconto(9999.00);

		System.out.println("Após tentar aplicar valores inválidos");
		System.out.println(produtoB.obterInfo());

		System.out.println("\n\n\nResumo dos testes 5 e 6:");
		System.out.println("Neste bloco foi testada a aplicação de desconto por valor fixo.");
		System.out.println("Primeiro, apliquei um desconto válido no produtoB.");
		System.out.println("Depois, tentei aplicar descontos inválidos no mesmo produto para testar as validações da classe Produto.");
		System.out.println("Para elaborar os testes, foi chamado o método aplicarDesconto com parâmetro double.");
			
		pausar(scanner);
		limparTela();

		System.out.println("\n--- Teste 7: Desconto por porcentagem ---");

		System.out.println("Antes do desconto por porcentagem:");
		System.out.println(produtoB.obterInfo());

		produtoB.aplicarDesconto(10);

		System.out.println("Depois do desconto de 10%:");
		System.out.println(produtoB.obterInfo());

		System.out.println("\n--- Teste 8: Desconto por porcentagem inválida ---");

		produtoB.aplicarDesconto(0);
		produtoB.aplicarDesconto(-5);
		produtoB.aplicarDesconto(101);

		System.out.println("Após tentar aplicar porcentagens inválidas:");
		System.out.println(produtoB.obterInfo());

		System.out.println("\nResumo dos testes 7 e 8:");
		System.out.println("Neste bloco foi testada a aplicação de desconto por porcentagem.");
		System.out.println("Primeiro, apliquei um desconto válido de 10% no produtoB.");
		System.out.println("Depois, tentei aplicar porcentagens inválidas para testar as validações da classe Produto.");
		System.out.println("Para elaborar os testes, foi chamado o método aplicarDesconto com parâmetro int.");

		pausar(scanner);
		limparTela();

		System.out.println("\n--- Teste 9: Desconto por porcentagem com estoque mínimo válido ---");

		System.out.println("Antes do desconto com estoque mínimo válido:");
		System.out.println(produtoC.obterInfo());

		produtoC.aplicarDesconto(10, 3);

		System.out.println("Depois do desconto de 10% com estoque mínimo 3:");
		System.out.println(produtoC.obterInfo());

		System.out.println("\n--- Teste 10: Desconto por porcentagem com estoque mínimo inválido ---");

		produtoC.aplicarDesconto(10, 100);

		System.out.println("Após tentar aplicar desconto com estoque mínimo inválido:");
		System.out.println(produtoC.obterInfo());

		System.out.println("\nResumo dos testes 9 e 10:");
		System.out.println("Neste bloco foi testado o desconto por porcentagem condicionado ao estoque mínimo.");
		System.out.println("Primeiro, o desconto foi aplicado porque o produtoC tinha estoque suficiente.");
		System.out.println("Depois, o desconto foi recusado porque a quantidade mínima exigida era maior que o estoque disponível.");
		System.out.println("Para elaborar os testes, foi chamado o método aplicarDesconto com dois parâmetros: int porcentagem e int quantidadeMinimaEstoque.");

		pausar(scanner);
		limparTela();

		System.out.println("\n--- Teste 11: Desconto com quantidade mínima inválida ---");

		System.out.println("Antes das tentativas com quantidade mínima inválida:");
		System.out.println(produtoC.obterInfo());

		produtoC.aplicarDesconto(10, 0);
		produtoC.aplicarDesconto(10, -1);

		System.out.println("Depois das tentativas com quantidade mínima inválida:");
		System.out.println(produtoC.obterInfo());

		System.out.println("\n--- Teste 12: Criando produto com Scanner ---");

		System.out.print("Digite o nome do produto: ");
		String nomeDigitado = scanner.nextLine();

		System.out.print("Digite o preço do produto: ");
		double precoDigitado = Double.parseDouble(scanner.nextLine().replace(",", "."));

		System.out.print("Digite a quantidade em estoque: ");
		int estoqueDigitado = Integer.parseInt(scanner.nextLine());

		Produto produtoDigitado = new Produto(nomeDigitado, precoDigitado, estoqueDigitado);

		System.out.println("\nProduto criado com dados digitados pelo usuário:");
		System.out.println(produtoDigitado.obterInfo());

		System.out.println("Total de produtos criados após o cadastro com Scanner: " + Produto.getTotalProdutosCriados());

		System.out.println("\nResumo dos testes 11 e 12:");
		System.out.println("No teste 11, foi validado que a classe Produto não aceita quantidade mínima zero ou negativa para aplicar desconto.");
		System.out.println("No teste 12, foi simulada a criação de um produto com dados digitados pelo usuário.");
		System.out.println("Esse teste mostra que o usuário informa os dados, mas quem cria o objeto é o programa.");
		System.out.println("O produtoDigitado é uma referência para o novo objeto Produto criado em memória.");

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