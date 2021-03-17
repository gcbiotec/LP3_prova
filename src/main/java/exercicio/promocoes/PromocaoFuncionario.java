package exercicio.promocoes;

import exercicio.Venda;
import exercicio.models.produto.Produto;

public class PromocaoFuncionario implements PromocaoInterface {

    @Override
    public void criarPromo(Venda venda) {

        venda.produto.setPreco(venda.produto.getPreco() - 30);

    }
}
