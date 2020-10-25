import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DataETempo {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public static LocalDateTime getDataHora(String data, String hora){

        LocalDateTime dataHora = LocalDateTime.parse(data+"T"+hora);
        String text = dataHora.format(formatter);
        return LocalDateTime.parse(text, formatter);
    }
    
    
    public static LocalDateTime getDataHoraAgora(){
        LocalDateTime dateNow = LocalDateTime.now();
        String text = dateNow.format(formatter);
        return LocalDateTime.parse(text, formatter);
    }
}
