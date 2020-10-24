import java.util.ArrayList;
import java.util.Scanner;

public class Menu{

    private static  ArrayList<Morador> listaMoradores = new ArrayList<Morador>();
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

    public static void incluiMorador(){
        boolean existe=false;
        Scanner entrada= new Scanner(System.in);
        System.out.println("informe os dados do morador na seguinte ordem: Nome, rg e numero do apartamento");
        System.out.println("Nome:");
        String nome = entrada.nextLine();
        System.out.println("Rg:");
        String rg= entrada.nextLine();
        System.out.println("Numero do Apartamento:");
        String nroApartamento = entrada.nextLine();
        Morador aux= new Morador(nome,rg,nroApartamento);

        for (Morador morador : listaMoradores) {
            if(morador.getNome().equalsIgnoreCase(nome))
            existe= true;
        }
        if(existe){
            System.out.println("Este morador ja esta no sistema \n");
        }else {
            listaMoradores.add(aux);
            System.out.println("Morador "+nome+" adcionado ao sistema "+ "\n");
        } 
    }
    public static void main (String[] args){ 
        listaMoradores.add(new Morador("Seige","214646178","101"));
        int opcao;
        Scanner entrada = new Scanner(System.in);
    
        do{
            menu();
            opcao = entrada.nextInt();
        
            switch(opcao){
            case 1: //escolheOperador();
                    
                break;
                
            case 2: //incluirOperador();
                    
                break;
            
            case 3: //registraEntrega();               
                
                break;

            case 4: ///listaMoradores();                
                for (Morador morador : listaMoradores) {
                    System.out.println(morador);
                }
                break;             
            
            case 5: 
                incluiMorador(); 
            
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
}