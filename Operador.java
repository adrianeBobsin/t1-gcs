public class Operador{

    public String nome;
    public String iniciais;

    public Operador(String nome, String iniciais) {
        this.nome = nome;
        this.iniciais = iniciais;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIniciais() {
        return this.iniciais;
    }

    public void setIniciais(String iniciais) {
        this.iniciais = iniciais;
    }

    
    public void escolheOperador(String nome){
        //procurar o operador 
        // retorna operador
        

    }

    public void registraEntrega(Entrega e, Morador m){
        //procurar a entrega 
        //procura o morador
        //registra os dados
        

    }


    //public void geraRelatorio({
        //gera o relatorio de todas as entregas, inclusive as que nao foram retiradas
    //}


    @Override
    public String toString() {
        return "Operador{" +
                "nome='" + nome + '\'' +
                ", iniciais='" + iniciais + '\'' +
                '}';
    }
}
