import java.time.LocalDateTime;
public class Entrega{

    public String dataHora;
    public String descricao;
    public String numeroApartamento;
    public Operador operador;
    public String id;
    public Retirada retirada;

    private static int idCounter = 0;
    public Entrega() {
    }

    public Entrega(String data, String hora, String descricao, String numeroApartamento, Operador operador, String id) {
        this.dataHora = DataETempo.getDataHora(data,hora);
        this.descricao = descricao.toLowerCase();
        this.numeroApartamento = numeroApartamento;
        this.operador = operador;
        this.id = String.valueOf(idCounter++);
        this.retirada = null;
    }

    public Entrega(String data, String hora, String descricao, String numeroApartamento, Operador operador, Retirada retirada) {
        this.dataHora = DataETempo.getDataHora(data,hora);
        this.descricao = descricao.toLowerCase();
        this.numeroApartamento = numeroApartamento;
        this.operador = operador;
        this.id = String.valueOf(idCounter++);
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

    public Operador getOperador() {
        return this.operador;
    }

    public void setP(Operador p) {
        this.operador = operador;
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
    public void lista(){
        if(this.retirada != null)
            System.out.println("  "+id + "\t\t\t"+ dataHora + "\t\t" + descricao + "\t\t\t\t"  + numeroApartamento + "\t\t" +"  "+ operador.getIniciais()  + "\t\t\t" +retirada.getData() +"\t\t" + retirada.getNome());
        else
            System.out.println("  "+id + "\t\t\t" +dataHora + "\t\t" + descricao + "\t\t\t\t" +  numeroApartamento + "\t\t" +"  "+operador.getIniciais());

    }

}
