import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Retirada {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String nome;
    private LocalDateTime data;

    public Retirada (String nome){
        this.nome = nome;
        this.data = DataETempo.getDataHoraAgora();
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public LocalDateTime getData(){
        return this.data;
    }
    public void setNome(LocalDateTime data){
        this.data = data;
    }


}

