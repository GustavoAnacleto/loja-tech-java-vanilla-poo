package entidades;

public class Cliente{

	private String nome;
	private String cpf;
	private double saldoCredito;
	private static int totalClientesCriados = 0;

    public Cliente() {
        nome = "Cliente não informado";
        cpf = "CPF não informado";
        saldoCredito = 0;

        totalClientesCriados++;
    }

    public Cliente(String nomeInit) {
        nome = "Cliente não informado";
        cpf = "CPF não informado";
        saldoCredito = 0;

        setNome(nomeInit);

        totalClientesCriados++;
    }

	public Cliente(String nomeInit, String cpfInit, double saldoCreditoInit){
        nome = "Cliente não informado";
        cpf = "CPF não informado";
        saldoCredito = 0;

        setNome(nomeInit);
        setCpf(cpfInit);
        setSaldoCredito(saldoCreditoInit);

        totalClientesCriados++;
    }

	//Métodos getters e setters

	public String getNome(){
		return nome;
	}
	public String getCpf(){
		return cpf;
	}
	public double getSaldoCredito(){
		return saldoCredito;
	}
	public static int getTotalClientesCriados(){
		return totalClientesCriados;
	}

	public void setNome(String novoNome){
		if(novoNome != null && !novoNome.trim().isEmpty()){
			nome = novoNome.trim();
		}
	}

	public void setCpf(String novoCpf){
		if(novoCpf != null && !novoCpf.trim().isEmpty()){
			cpf = novoCpf.trim();
		}
	}

	public void setSaldoCredito(double novoSaldoCredito){
		if(novoSaldoCredito >= 0){
			saldoCredito = novoSaldoCredito;
		}
	}

	public String obterInfo(){

		return "Cliente: " + nome
			  +"\n    CPF: " + cpf
			  +"\n Saldo de Credito: " + saldoCredito
			  +"\n_______________________________________";
	}
}
