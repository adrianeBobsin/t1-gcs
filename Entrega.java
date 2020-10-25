public class Entrega{

    public String data;
    public String hora;
    public String descricao;
    public String numeroApartamento;
    public Operador p;
    public String id;
    public boolean retirada;

    public Entrega() {
    }

    public Entrega(String data, String hora, String descricao, String numeroApartamento, Operador p, String id,boolean retirada) {
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.numeroApartamento = numeroApartamento;
        this.p = p;
        this.id = id;
        this.retirada = false;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public void registraEntrega(String data, String hora, String descricao, String numeroApartamento, Operador p, String id){
    //procurar para ver se ja existe, se nao, cria e adiciona
    }

    public void procuraEntregas(String descricao){
        //procurar descricao
        //se achar, lista
        

    }

    public boolean isRetirada(){
        return retirada;
    }

 
    public void lista(){
        System.out.println("Data: " + data + "Hora: " + hora + " Descricao: " + descricao + " Numero Apartamento: " + numeroApartamento + " Operador: " + p.getNome() +  " Id: " + id + " Foi retirada?: " + retirada );

    }

}
