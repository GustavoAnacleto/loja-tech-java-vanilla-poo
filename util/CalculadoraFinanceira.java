package util;

public class CalculadoraFinanceira{

	public static double aplicarDesconto(double preco, double desconto){
		if(preco < 0){
			preco = 0;
		}

		if(desconto < 0){
			desconto = 0;
		}

		return preco - desconto;
	}

	public static double aplicarDesconto(double preco, int porcentagem){
		if(preco < 0){
			preco = 0;
		}
		if(porcentagem < 0){
			porcentagem = 0;
		}
		if(porcentagem > 100){
			porcentagem = 100;
		}
		double resultado = preco * porcentagem / 100;

		return preco - resultado;
	}

	public static double aplicarAcrescimo(double preco, int porcentagem){
		if(preco < 0){
			preco = 0;
		}
		if(porcentagem < 0){
			porcentagem = 0;
		}
		if (porcentagem > 100) {
		    porcentagem = 100;
		}
		double resultado = preco * porcentagem / 100;

		return preco + resultado;
	} 

	public static double calcularTotal(double preco, int quantidade){
		if(preco < 0){
			preco = 0;
		}
		return preco * quantidade;
	}

	public static void exibirValor(String descricao, double valor){

		System.out.printf("%s: R$ %.2f%n", descricao, valor);
	}

}