package exercicio.models.cliente;

public class Cliente {
    private Integer id;
    private String login;
    private String cpf;
    private TipoCliente tipo;
    private float credito;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public Cliente(Integer id, String login, String cpf, TipoCliente tipo, float credito) {
        this.id = id;
        this.login = login;
        this.cpf = cpf;
        this.tipo = tipo;
        this.credito = credito;
    }


}
