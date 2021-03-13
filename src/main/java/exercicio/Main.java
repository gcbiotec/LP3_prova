package exercicio;

import exercicio.models.produto.RepositorioArrayDeProduto;
import exercicio.models.produto.RepositorioDeProdutoInterface;

public class Main {


    private Integer idTipoCliente;
    private Integer idDoProduto;

    // Controller Venda
    public static void main(String[] args) throws Exception {

        // @Autowired Gerencia as dependências (Controller não faz isso, mas algum lugar do sistema deve fazer)
        RepositorioDeProdutoInterface repositorioArrayDeProduto = new RepositorioArrayDeProduto();

        // ========================================================================================


        // Criando o serviço de venda com suas dependencias no construtor (injetando)
        VendaService vendaService = new VendaService(repositorioArrayDeProduto);

        // Chamada o metodo do serviço
        vendaService.processarVenda();
    }

}
