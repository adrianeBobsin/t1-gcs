import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    private static ArrayList<Operador> listaOperadores = new ArrayList<>();
    public static void menu(){
        System.out.println("Escolha uma opcao");
        System.out.println("0. Fim");
        System.out.println("1. Escolher operador");
        System.out.println("2. Incluir operador");
        System.out.println("3. Registrar entrega");
        System.out.println("4. Listar moradores");
        System.out.println("5. Incluir novo morador");
        System.out.println("6. Registrar retirada de uma entrega");
        System.out.println("7. Listar entregas nao retiradas");
        System.out.println("8. Procurar entregas");
        System.out.println("9. Gerar relatorio");
        System.out.println("Opcao:");
    }
public static void main (String[] args){

    int opcao;
    Scanner entrada = new Scanner(System.in);
    
    do{
        menu();
        opcao = entrada.nextInt();
        entrada.nextLine();
        switch(opcao){
        case 1: //escolheOperador();
                
            break;
            
        case 2: 
        incluirOperador(entrada);        
            break;
        
        case 3: //registraEntrega();               
            
            break;

        case 4: ///listaMoradores();                
            
            break;             
        
        case 5: //incluiMorador();          
    
            break;    
            
         case 6: //registraRetirada();             

            break;

        case 7: //listaEntregasNRetiradas();
            
            break;    

        case 8: //procuraEntregas();

            break;   

        case 9: //gerarRelatorio();

            break;     
        
        default:
            System.out.println("Opção inválida.");
        }
    } while(opcao != 0);
}
    private static void incluirOperador(Scanner scanner){

        System.out.println("informe o nome completo do operador: ");
        String nome = scanner.nextLine();

        for (Operador operador : listaOperadores) {
            if(operador.getNome().equalsIgnoreCase(nome)){
                System.out.println("Este Operador ja esta no sistema \n");
                return;
            }
        }
        String iniciais = pegaIniciais(nome.split(" "));
        listaOperadores.add(new Operador(nome,iniciais));
        System.out.println("Operador "+nome+" adicionado ao sistema "+ "\n");
    }
    private static String pegaIniciais(String[] nomeSemEspaco){
        String iniciais = "";
        for(byte count = 0; count < nomeSemEspaco.length; count++){
            iniciais += nomeSemEspaco[count].charAt(0);
        }
        return iniciais;
    }
}