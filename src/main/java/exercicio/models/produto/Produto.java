package exercicio.models.produto;

import exercicio.TipoProduto;

public class Produto {
    private Integer id;
    private String nome;
    private float preco;
    private Integer quantidade;
    private TipoProduto tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Produto(Integer id, String nome, float preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (Float.compare(produto.preco, preco) != 0) return false;
        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
        return nome != null ? nome.equals(produto.nome) : produto.nome == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != +0.0f ? Float.floatToIntBits(preco) : 0);
        return result;
    }

    public void diminuirQtdProdutoDoEstoque() {
        setQuantidade(getQuantidade() - 1);
    }
}
