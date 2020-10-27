import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu{

    private static ArrayList<Morador> listaMoradores = new ArrayList<>();
    private static ArrayList<Operador> listaOperadores = new ArrayList<>();
    private static ArrayList<Entrega> listaEntregas = new ArrayList<>();
    private static Operador operadorAtual = new Operador("Matheus Hrymalak", "MH");


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
            if(morador.getNome().equalsIgnoreCase(nome)){
                existe= true;
            }
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
        listaMoradores.add(new Morador("Luis Felipe Moreira","3124567589","312"));
        listaOperadores.add(operadorAtual);
        listaEntregas.add(new Entrega("03/12/2017","15:47","1x Pacote 5kg","418",operadorAtual));
        listaEntregas.add(new Entrega("23/09/2020","09:37","2x Pacote 2kg","312",operadorAtual, new Retirada("Luis Felipe Moreira")));
        int opcao;
        Scanner entrada = new Scanner(System.in);


        do{
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                case 0:
                    System.out.println("Finalizando programa.");
                    break;

                case 1:
                    for (Operador op : listaOperadores) {
                        System.out.println(op);
                    }
                    operadorAtual = escolherOperador(entrada);
                    break;

                case 2:
                    incluirOperador(entrada);
                    break;

                case 3:
                    registraEntrega();
                    break;

                case 4:
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

                case 7:
                    listarEntregasNaoRetiradas();
                    break;

                case 8: procuraEntregas(entrada);

                    break;

                case 9:
                    gerarRelatorio();
                    break;

                default:
                    System.out.println("\fOpção inválida.");
            }
        } while(opcao != 0);
    }

    private static Operador escolherOperador(Scanner scanner){
        String nome = garanteString(scanner, "nome do operador");

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
        String nome = garanteString(scanner, "nome do operador");

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

    public static void registraEntrega(){
        String id = "1";
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a data de realização da entrega no formato dd/mm/aaaa: ");
        String data = scan.nextLine();
        System.out.println("Digite a hora de realização da entrega no formato hh:mm: ");
        String hora = scan.nextLine();
        System.out.println("Digite a descrição da entrega: ");
        String descricao = scan.nextLine();
        System.out.println("Digite o numero do Apartamento de entrega: ");
        String numeroApartamento = scan.nextLine();
        boolean exist = false;
        Entrega ent = new Entrega(data,hora,descricao,numeroApartamento,operadorAtual);

        for (Entrega entrega : listaEntregas) {
            if (!entrega.possuiRetirada() && entrega.getId().equals(id)) {
                exist = true;
            }
        }
        if(exist){
            System.out.println("Já possui uma entrega com o mesmo ID");
        }else {
            listaEntregas.add(ent);
            System.out.println("Entrega de número " + id + "registrada com sucesso");
        }

    }


    private static void listarEntregasNaoRetiradas(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Entrega entrega : listaEntregas) {
            if(!entrega.possuiRetirada()){
                stringBuilder.append(entrega);
            }
        }

        if (0 < stringBuilder.length()) {
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("Nenhum registro encontrado.");
        }
    }


    private static String garanteString(Scanner scanner, String queNome){
        String nome = "GCS";
        do{
            if(nome.isBlank()){
                System.out.println("\fOperação inválido ");
                scanner.nextLine();
            }
            System.out.println("Informe o "+queNome+": ");
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
        String nome = garanteString(scanner,"o nome do morador");
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
        System.out.println("Retirada, na data: "+retirada.getData());
    }

    private static void procuraEntregas(Scanner scanner){
        String descricao = garanteString(scanner, "o que procura");
        System.out.println("Entrega\t\t" +"Horário do registro\t\t"  +"Descrição\t\t\t\t\t" + "Apto\t" + "Operador\t\t" +"Retirada\t\t\t\t" + "Morador");
        for(Entrega umaEntrega: listaEntregas){
            if(umaEntrega.getDescricao().contains(descricao.toLowerCase())){
                umaEntrega.lista();
            }
        }
    }

    private static void gerarRelatorio() {
        Scanner scanner = new Scanner(System.in);
        ValidaData validacaoData = new ValidaData();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean ret;
        String dataInicial;
        do {
            System.out.println("Informe a data inicial para pesquisa no formato dd/mm/aaaa: ");
            dataInicial = scanner.nextLine();
            ret = validacaoData.dataValida(dataInicial);
        } while (ret == false);
        LocalDate dI = LocalDate.parse(dataInicial, formatter);

        String dataFinal;
        do {
            System.out.println("Informe a data final para pesquisa no formato dd/mm/aaaa: ");
            dataFinal = scanner.nextLine();
            ret = validacaoData.dataValida(dataFinal);
        } while(ret == false);
        LocalDate dF = LocalDate.parse(dataFinal, formatter);

        System.out.println("Entrega\t\t" + "Horário do registro\t\t" + "Descrição\t\t\t\t\t" + "Apto\t" + "Operador\t\t" + "Retirada\t\t\t\t" + "Morador");
        for (Entrega umaEntrega : listaEntregas) {
            String[] entrega = umaEntrega.getDataHora().split(" ");
            LocalDate dataEntrega = LocalDate.parse(entrega[0], formatter);
            if (dI.isBefore(dataEntrega) && dF.isAfter(dataEntrega)) {
                umaEntrega.lista();
            }
        }

        // == Submenu da consulta ==
        System.out.println("\nEscolha uma opção: ");
        System.out.println("0. Retornar ao menu");
        System.out.println("1. Realizar nova pesquisa por data");
        int submenu = scanner.nextInt();

        switch(submenu) {
            case 0:
                break;

            case 1:
                gerarRelatorio();
                break;

            default:
                break;
        }
    }
}