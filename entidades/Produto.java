package entidades;

public class Produto{

	private int codigo;
	private String nome = "Produto não informado";
	private double preco;
	private int quantidadeEstoque;
	private static int totalProdutosCriados = 0;
	private static int proximoCodigo = 1000;

	public Produto(){
		codigo = proximoCodigo;
		proximoCodigo += 3;
		totalProdutosCriados++;

		nome = "Produto não informado";
		preco = 0;
		quantidadeEstoque = 0;
	}

	public Produto(String nomeInit, double precoInit){
		codigo = proximoCodigo;
		proximoCodigo += 3;
		totalProdutosCriados++;

		setNome(nomeInit);
		setPreco(precoInit);
		quantidadeEstoque = 0;
	}

	public Produto(String nomeInit, double precoInit, int quantidadeEstoqueInit){
		codigo = proximoCodigo;
		proximoCodigo += 3;
		totalProdutosCriados++;

		setNome(nomeInit);
		setPreco(precoInit);
		setQuantidadeEstoque(quantidadeEstoqueInit);	
	}

    // Metodos getters

	public int getCodigo(){
		return codigo;
	}
	public String getNome(){
		return nome;
	}
	public double getPreco(){
		return preco;
	}
	public int getQuantidadeEstoque(){
		return quantidadeEstoque;
	}
	public static int getTotalProdutosCriados(){
		return totalProdutosCriados;
	}

	//Metodos Setters

	public void setNome(String novoNome){
		if(novoNome != null && !novoNome.trim().isEmpty()){
			nome = novoNome;
		}
	}
	public void setPreco(double novoPreco){
		if(novoPreco >= 0){
			preco = novoPreco;
		}
	}
	public void setQuantidadeEstoque(int novaQuantidadeEstoque){
		if(novaQuantidadeEstoque >= 0){
			quantidadeEstoque = novaQuantidadeEstoque;
		}
	} 

	//Regras de negocios da classe.

	public String obterInfo() {
	    return "Código do produto: " + codigo
	            + "\nNome do produto: " + nome
	            + "\nValor: R$ " + preco
	            + "\nEstoque: " + quantidadeEstoque
	            + "\n_______________________________________";
	}

	public void aplicarDesconto(double valor) {

	    if (valor <= 0) {
	        System.out.println("O valor do desconto deve ser maior que zero.");
	        return;
	    }

	    if (valor > preco) {
	        System.out.println("O desconto não pode ser maior que o preço do produto.");
	        return;
	    }

	    preco -= valor;
	}

	public void aplicarDesconto(int porcentagem) {

	    if (porcentagem <= 0 || porcentagem > 100) {
	        System.out.println("A porcentagem deve estar entre 1 e 100.");
	        return;
	    }

	    double valorDesconto = preco * porcentagem / 100.0;
	    preco -= valorDesconto;
	}

	public void aplicarDesconto(int porcentagem, int quantidadeMinimaEstoque) {

	    if (quantidadeMinimaEstoque <= 0) {
	        System.out.println("A quantidade mínima deve ser maior que zero.");
	        return;
	    }

	    if (quantidadeEstoque < quantidadeMinimaEstoque) {
	        System.out.println("Estoque insuficiente para aplicar este desconto.");
	        return;
	    }

	    aplicarDesconto(porcentagem);
	}		

}