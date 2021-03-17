package exercicio.models.impostos;

import exercicio.Venda;
import exercicio.models.produto.Produto;

public class AplicaImpostoPadrao {

    public void aplicarImpostoPadrao(Venda venda) {
        System.out.println("Aplicando imposto padrao");
        venda.produto.setPreco(venda.produto.getPreco() + 10);
    }
}
