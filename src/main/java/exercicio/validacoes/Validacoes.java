package exercicio.validacoes;

import exercicio.Venda;

public class Validacoes implements InterfaceValidacoes {

    public void realizarValidacao(Venda venda){

        new ValidarCreditoCliente().validar(venda);
        new ValidarProdutoNulo().validar(venda);
        new ValidarQuantidadeProdutoEmEstoque().validar(venda);
    }
}
