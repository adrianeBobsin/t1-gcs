import java.util.ArrayList;
import java.util.Scanner;

public class Menu{

    private static ArrayList<Morador> listaMoradores = new ArrayList<>();
    private static ArrayList<Operador> listaOperadores = new ArrayList<>();
    private static ArrayList<Entrega> listaEntregas = new ArrayList<>();
    private static ArrayList<Entrega> listaEntregasNRetiradas = new ArrayList<>();
    private static Operador operadorAtual = new Operador("Matheus Hrymalak Souza", "MHS");
    //private static Entrega e = new Entrega("dads","dasdasd","dsadas","sdasd","dasdsad",false);
    //private static Entrega e2 = new Entrega("15/10","15:10","dsadas","18","128903",false);


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
            if(morador.getNome().equalsIgnoreCase(nome));
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
        listaOperadores.add(operadorAtual);
        listaEntregas.add(new Entrega("2007-12-03","15:47","1x Pacote 5kg","418",operadorAtual));
        int opcao;
        Scanner entrada = new Scanner(System.in);
    

    do{
        menu();
        opcao = entrada.nextInt();
        entrada.nextLine();
        switch(opcao){
            case 1: 
                operadorAtual = escolherOperador(entrada);
                break;

            case 2: 
                incluirOperador(entrada);        
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
                
            case 6: 
                registraRetirada(entrada);             
                break;

            case 7: listaEntregasNRetiradas();
                
                break;    

            case 8: //procuraEntregas();

                break;   

            case 9: //gerarRelatorio();

            break;     
        
        default:
            System.out.println("\fOpção inválida.");
        }
    } while(opcao != 0);
}
    private static Operador escolherOperador(Scanner scanner){
        String nome = pegaNome(scanner, "operador");

        if(operadorAtual.getNome().equalsIgnoreCase(nome)){
            System.out.print("Esse operador já está selecionado");
            return operadorAtual;
        }
        for (Operador operador : listaOperadores) {
            if(operador.getNome().equalsIgnoreCase(nome)){
                return operador;
            }
        }
        System.out.println("Este Operador não encontrado");
        return operadorAtual;
    }
    private static void incluirOperador(Scanner scanner){
        String nome = pegaNome(scanner, "operador");

        for (Operador operador : listaOperadores) {
            if(operador.getNome().equalsIgnoreCase(nome)){
                System.out.println("Este Operador ja esta no sistema \n");
                return;
            }
        }
        String iniciais = pegaIniciais(nome.split(" "));
        listaOperadores.add(new Operador(nome, iniciais));
    }
    private static String pegaIniciais(String[] nomeSemEspaco){
        String iniciais = "";
        for(byte count = 0; count < nomeSemEspaco.length; count++){
            iniciais += nomeSemEspaco[count].charAt(0);
        }
        return iniciais;
    }


    private static void listaEntregasNRetiradas(){
        
        //testando
        //listaEntregas.add(e);
        //e2.retirada = true;
        //listaEntregas.add(e2);

        for (Entrega entrega : listaEntregas) {
            if(entrega.getRetirada()== null){
            listaEntregasNRetiradas.add(entrega);
            }
        }


    }


    private static String pegaNome(Scanner scanner, String queNome){
        String nome = "GCS";
        do{
            if(nome.isBlank()){
                System.out.println("\fOperação inválido "); 
                scanner.nextLine();
            }
            System.out.println("Informe o nome do "+queNome+": ");
            nome = scanner.nextLine();
        }while(nome.isBlank());
        return nome;
    }

    private static void registraRetirada(Scanner scanner){
        System.out.print("Digite o ID da entrega: ");
        String id = scanner.nextLine();
        Entrega entregaSelecionada = null;
        for(Entrega entrega : listaEntregas){
           if(entrega.getId().equals(id)){
                entregaSelecionada = entrega;
                break;
           }
        }
        if(entregaSelecionada == null){
            System.out.println("ID inválido");
            return;
        }
        String nome = pegaNome(scanner,"morador");
        Morador morador = null;
        for(Morador umMorador : listaMoradores){
            if(umMorador.getNome().equalsIgnoreCase(nome)){
                morador = umMorador;
                break;
            }
        }
        if(morador == null){
            System.out.println("Morador não encontrado");
            return;
        }
        Retirada retirada = new Retirada(nome);
        entregaSelecionada.setRetirada(retirada);
        System.out.println("Retirada, na data: "+retirada.getData().toString());
    }
}
