package entidades;

public class Venda {

    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private double valorTotal;
    private boolean concluida;
    private static int totalVendasConcluidas;

    public Venda() {
    }

    public Venda(Cliente clienteInit, Produto produtoInit) {
        cliente = clienteInit;
        produto = produtoInit;
        quantidade = 1;
    }

    public Venda(Cliente clienteInit,Produto produtoInit,int quantidadeInit) {
        cliente = clienteInit;
        produto = produtoInit;
        quantidade = quantidadeInit;
    }

    // Métodos obrigatórios

    public void calcularValorTotal() {
        if (produto != null && quantidade > 0) {
            valorTotal = produto.getPreco() * quantidade;
        } else {
            valorTotal = 0;
        }
    }

    public void concluirVenda() {

        if (concluida) {
            System.out.println("Esta venda já foi concluída.");
            return;
        }

        if (produto == null || cliente == null || quantidade <= 0) {
            System.out.println("Não foi possível concluir a venda: dados inválidos.");
            return;
        }

        calcularValorTotal();

        if (produto.getQuantidadeEstoque() < quantidade) {
            System.out.println("Não foi possível concluir a venda: estoque insuficiente.");
            return;
        }

        if (cliente.getSaldoCredito() < valorTotal) {
            System.out.println("Não foi possível concluir a venda: crédito insuficiente.");
            return;
        }

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);

        cliente.setSaldoCredito(cliente.getSaldoCredito() - valorTotal);

        concluida = true;
        totalVendasConcluidas++;

        System.out.println("Venda concluída com sucesso.");
    }

    public String obterInfo() {

        String nomeCliente = cliente != null ? cliente.getNome() : "Cliente não informado";

        String nomeProduto = produto != null ? produto.getNome() : "Produto não informado";

        return "Cliente: " + nomeCliente
                + "\nProduto: " + nomeProduto
                + "\nQuantidade: " + quantidade
                + "\nValor total: R$ " + valorTotal
                + "\nConcluída: " + concluida;
    }

    public static int getTotalVendasConcluidas() {
        return totalVendasConcluidas;
    }
}