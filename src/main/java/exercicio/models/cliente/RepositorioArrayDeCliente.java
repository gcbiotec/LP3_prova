package exercicio.models.cliente;

import exercicio.models.produto.RepositorioDeProdutoInterface;

import java.util.ArrayList;
import java.util.Optional;

import static exercicio.models.cliente.TipoCliente.*;

public class RepositorioArrayDeCliente implements RepositorioDeClienteInterface{

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public RepositorioArrayDeCliente() {
        Cliente sabino = new Cliente(1, "Sabino", "4449995584", PESSOAFISICA, 100f);
        Cliente gabriel = new Cliente(2, "Gabriel", "4449995584", PESSOAJURIDICA, 200f);
        Cliente isadora = new Cliente(3, "Isadora", "4449995584", FUNCIONARIO, 300f);
        Cliente ronaldo = new Cliente(4, "Ronaldo", "4449995584", FUNCIONARIO, 400f);

        clientes.add(sabino);
        clientes.add(gabriel);
        clientes.add(isadora);
        clientes.add(ronaldo);
    }

    public Cliente buscarPeloId(Integer idDoCLiente) {
        if(idDoCLiente == null)
            throw new RuntimeException("A busca nao aceita nulo!");

        Optional<Cliente> cliente = clientes.stream()
                .filter(cli -> cli.getId() == idDoCLiente).findFirst();

        return cliente.get();
    }
}

