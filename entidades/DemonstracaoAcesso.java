package entidades;

public class DemonstracaoAcesso{

	public String publico;
	private String privado;
	protected String protegido;
	String padrao;

	public void exibirDentroDaClasse(){

		publico = "Atributo público acessado dentro da própria classe";
		privado = "Atributo privado acessado dentro da própria classe";
		protegido = "Atributo protegido acessado dentro da própria classe";
        padrao = "Atributo padrão acessado dentro da própria classe";

        System.out.println(publico);
        System.out.println(privado);
        System.out.println(protegido);
        System.out.println(padrao);
	}
}