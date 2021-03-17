package exercicio.models.impostos;

import exercicio.Venda;
import exercicio.models.produto.Produto;

public class AplicaImpostoServico {

    public void aplicarImpostoServico(Produto produto, Venda venda){
        System.out.println("Aplicando imposto de serviço");
        produto.setPreco(venda.produto.getPreco() + 20);
    }
}
