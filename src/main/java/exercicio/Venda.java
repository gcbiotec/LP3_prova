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
}
