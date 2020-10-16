public class Morador{

    public String nome;
    public String rg;
    public String numeroApartamento;

    public Morador(String nome,String rg, String numeroPartamento) {
        this.nome = nome;
        this.rg = rg;
        this.numeroApartamento = numeroPartamento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
    public void listarMoradores(String nome,String rg, String numeroApartamento){
        //listar todos os moradores
        

    }


    public void incluiMorador(String nome){
        //procurara para ver se ja existe, se nao, cria e adiciona
    }

}
