import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DataETempo {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public static String getDataHora(String data, String hora){

        LocalDateTime dataHora = LocalDateTime.parse(data+"T"+hora);
        return dataHora.format(formatter);
    }
    
    
    public static String getDataHoraAgora(){
        LocalDateTime dateNow = LocalDateTime.now();
        return dateNow.format(formatter);
    }
}