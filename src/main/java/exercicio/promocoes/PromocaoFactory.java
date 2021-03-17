package exercicio.promocoes;

import exercicio.models.cliente.TipoCliente;

import static exercicio.models.cliente.TipoCliente.*;

public class PromocaoFactory {

    public static PromocaoInterface criarPromo(TipoCliente tipoCliente) {

        if (PESSOAFISICA.equals(tipoCliente)) {
            return new PromocaoPessoaFisica();

        } else if (PESSOAJURIDICA.equals(tipoCliente)) {
            return new PromocaoPessoaJuridica();

        } else if (FUNCIONARIO.equals(tipoCliente)) {
            return new PromocaoFuncionario();
        }
        return new PromocaoPessoaFisica();
    }
}

