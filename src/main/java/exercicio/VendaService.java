package exercicio;

import exercicio.models.cliente.Cliente;
import exercicio.models.cliente.RepositorioArrayDeCliente;
import exercicio.models.cliente.RepositorioDeClienteInterface;
import exercicio.models.cliente.TipoCliente;
import exercicio.models.impostos.AplicaImpostoPadrao;
import exercicio.models.impostos.AplicaImpostoServico;
import exercicio.models.produto.Produto;
import exercicio.models.produto.RepositorioDeProdutoInterface;
import exercicio.promocoes.PromocaoFuncionario;
import exercicio.promocoes.PromocaoInterface;
import exercicio.promocoes.PromocaoPessoaFisica;
import exercicio.promocoes.PromocaoPessoaJuridica;
import exercicio.validacoes.InterfaceValidacoes;
import exercicio.validacoes.ValidarCreditoCliente;
import exercicio.validacoes.ValidarProdutoNulo;
import exercicio.validacoes.ValidarQuantidadeProdutoEmEstoque;
import terminal.EntradaTerminal;

import static exercicio.TipoProduto.PADRAO;
import static exercicio.TipoProduto.SERVICO;
import static exercicio.models.cliente.TipoCliente.*;

public class VendaService {

    RepositorioDeProdutoInterface repositorioDeProduto;

    RepositorioDeClienteInterface repositorioDeCliente;

    public VendaService(RepositorioDeProdutoInterface repositorioDeProduto, RepositorioDeClienteInterface repositorioDeCliente) {
        this.repositorioDeProduto = repositorioDeProduto;
        this.repositorioDeCliente = repositorioDeCliente;
    }

    public void processarVenda(InterfaceValidacoes validacoes, PromocaoInterface promocaoInterface){
        Integer idDoProduto = EntradaTerminal.entradaInteira("Escolha o seu produto!\n 1 - Camisa\n 2 - Calça\n 3 - Meia");
        Produto produto = repositorioDeProduto.buscarPeloId(idDoProduto);

        // 1) (2P) - DIP - Criar Interface de Repositorio de Cliente e injeta-la no construtor
        // Obs: Fazer o new na Classe Main
        // Utilizar o exemplo do repositorio de produto

        Integer idDoCliente = EntradaTerminal.entradaInteira("Escolha o cliente!\n 1 - Sabino (PF)\n 2 - Gabriel (PJ)\n 3 - Isadora (FUNC)\n 4 - Ronaldo (FUNC)");
        Cliente cliente = repositorioDeCliente.buscarPeloId(idDoCliente);
        //RepositorioArrayDeCliente repositorioArrayDeCliente = new RepositorioArrayDeCliente();
        //Cliente cliente = repositorioArrayDeCliente.buscarPeloId(idDoCliente);
        //------------------------------------------------------------------------------------------------------------

        // Standby - 2) (1P) - Acoplamento e testabilidade - Extrair New da classe Venda para a classe Main e Injeta-la no construtor
        // Vou botar outra classe para treinar a injeção de dependencia

        // Deixa aqui a venda!
        Venda venda = new Venda(cliente, produto);
        //-------------------------------------------------------------------------------------------------------------
        // 3) (1P) - Agrupar Acoplamento - Separar classes de validacoes em uma classe com a responsabilidade de instancia-las e usa-las
//        new ValidarProdutoNulo().validar(venda);
//        new ValidarCreditoCliente().validar(venda);
//        new ValidarQuantidadeProdutoEmEstoque().validar(venda);

        validacoes.realizarValidacao(venda);
        //-----------------------------------------------------------------------------------------------------------
        // 4) (2P) - SRP - Criar classes separadas para cada imposto
        // Responsabilidade: Calcular cada imposto separadamente em sua classe
        if(PADRAO.equals(produto.getTipo())){
            AplicaImpostoPadrao aplicaImpostoPadrao();
//            System.out.println("Aplicando imposto padrao");
//            produto.setPreco(venda.produto.getPreco() + 10);
        } else if(SERVICO.equals(venda.produto.getTipo())){
            AplicaImpostoServico aplicaImpostoServico();
//            System.out.println("Aplicando imposto de serviço");
//            produto.setPreco(venda.produto.getPreco() + 20);
        }

        // 5) (4P) - SRP e DIP - Aplicar Factory e Strategy em promoção
        // Responsabilidade: Separar escolha de promoção para a factory
        // Acoplamento/DIP: Retirar dependencias das classes indivicuais de promocoes
        // fazendo com que a classe atual dependa apenas da interface PromocaoInterface
//        if(PESSOAFISICA.equals(cliente.getTipo())){
//            new PromocaoPessoaFisica().aplicar(venda.produto);
//        } else if(PESSOAJURIDICA.equals(cliente.getTipo())){
//            new PromocaoPessoaJuridica().aplicar(venda.produto);
//        } else if(FUNCIONARIO.equals(cliente.getTipo())){
//            new PromocaoFuncionario().aplicar(venda.produto);
//        }
        promocaoInterface.criarPromo(venda);

        // Pontos extras
        // 6) (0,3P) - Aplicar encapsulamento mandando o cliente diminuir determinado valor em um metodo interno do Cliente
        venda.diminuirCreditoCliente();

        // 7) (0,3P) - Aplicar encapsulamento mandando o produto diminuor 1 quantidade (diminuir estoque)
        produto.diminuirQtdProdutoDoEstoque();

        // 8) (0,3P) - Transferir metodo para a classe venda (A venda possui tudo o que é utilizado aqui então é responsabilidade apenas dela)
        venda.apresentarAtributosDaVenda();

        // 9) (1P) - Refatoração e testes livres
    }

//    private void apresentarAtributosDaVenda(Venda venda) {
//        System.out.print("=====\nValor do produto na Venda: " + venda.produto.getPreco() + "\n");
//        System.out.print("Credito do cliente na Venda: " + venda.cliente.getCredito() + "\n=====\n");
    }
}
