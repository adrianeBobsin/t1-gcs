import java.time.LocalDateTime;
public class Entrega{

    public String dataHora;
    public String descricao;
    public String numeroApartamento;
    public Operador p;
    public String id;
    public Retirada retirada;

    private int idCounter = 0;
    public Entrega() {
    }

    public Entrega(String data, String hora, String descricao, String numeroApartamento, Operador p) {
        this.dataHora = DataETempo.getDataHora(data,hora);
        this.descricao = descricao;
        this.numeroApartamento = numeroApartamento;
        this.p = p;
        this.id = String.valueOf(idCounter++);
        this.retirada = null;
    }

    public Entrega(String data, String hora, String descricao, String numeroApartamento, Operador p, Retirada retirada) {
        this.dataHora = DataETempo.getDataHora(data,hora);
        this.descricao = descricao;
        this.numeroApartamento = numeroApartamento;
        this.p = p;
        this.id = id;
        this.retirada = retirada;
    }



    public String getDataHora() {
        return this.dataHora;
    }

    public void setHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getnumeroApartamento() {
        return this.numeroApartamento;
    }

    public void setnumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public Operador getP() {
        return this.p;
    }

    public void setP(Operador p) {
        this.p = p;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Retirada getRetirada() {
        return this.retirada;
    }

    public void setRetirada(Retirada retirada) {
        this.retirada = retirada;
    }

}
