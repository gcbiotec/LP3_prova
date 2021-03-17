package exercicio;

import exercicio.models.cliente.RepositorioArrayDeCliente;
import exercicio.models.cliente.RepositorioDeClienteInterface;
import exercicio.models.produto.RepositorioArrayDeProduto;
import exercicio.models.produto.RepositorioDeProdutoInterface;
import exercicio.promocoes.PromocaoFactory;
import exercicio.promocoes.PromocaoInterface;
import exercicio.validacoes.InterfaceValidacoes;
import exercicio.validacoes.Validacoes;

public class Main {


    private Integer idTipoCliente;
    private Integer idDoProduto;

    // Controller Venda
    public static void main(String[] args) throws Exception {

        //Venda venda = new Venda(cliente, produto);

        // @Autowired Gerencia as dependências (Controller não faz isso, mas algum lugar do sistema deve fazer)
        RepositorioDeProdutoInterface repositorioArrayDeProduto = new RepositorioArrayDeProduto();

        RepositorioDeClienteInterface repositorioArrayDeCliente = new RepositorioArrayDeCliente();

        // ========================================================================================

        // Criando o serviço de venda com suas dependencias no construtor (injetando)
        VendaService vendaService = new VendaService(repositorioArrayDeProduto, repositorioArrayDeCliente);

        InterfaceValidacoes validacoes = new Validacoes();

        // Chamada o metodo do serviço
        vendaService.processarVenda(validacoes);
    }

}
