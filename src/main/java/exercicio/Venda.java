package exercicio;

import exercicio.models.cliente.Cliente;
import exercicio.models.produto.Produto;

public class Venda {

    public Produto produto;
    public Cliente cliente;

    public Venda(Cliente cliente, Produto produto) {
        this.produto = produto;
        this.cliente = cliente;
    }

    public void diminuirCreditoCliente() {
        cliente.setCredito(cliente.getCredito() - produto.getPreco());
    }

    public void apresentarAtributosDaVenda() {
        System.out.print("=====\nValor do produto na Venda: " + this.produto.getPreco() + "\n");
        System.out.print("Credito do cliente na Venda: " + this.cliente.getCredito() + "\n=====\n");

    }
}
