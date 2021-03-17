package exercicio.models.impostos;

import exercicio.Venda;
import exercicio.models.produto.Produto;

public class AplicaImpostoServico {

    public void aplicarImpostoServico(Venda venda){
        System.out.println("Aplicando imposto de serviço");
        venda.produto.setPreco(venda.produto.getPreco() + 20);
    }
}
