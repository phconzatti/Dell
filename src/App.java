import java.util.*;
import java.util.ArrayList;

public class App {
    private Aposta aposta;
    private Scanner sc;
    private ArrayList<Integer> numeros;

    public App() {
        aposta = new Aposta();
        sc = new Scanner(System.in);
        numeros = new ArrayList<Integer>();
    }

    Random gerar = new Random();

    //Menu
    public void executar(){
        System.out.println("\nInício de uma nova fase de apostas.");
       menu();
        int opcao = sc.nextInt();
        sc.nextLine();
        System.out.println("\n");
        while(opcao != 0){
            switch (opcao){
                case 1:
                    apostaNormal();
                    break;
                case 2:
                    apostaSurpresa();
                    break;
                case 3:
                    aposta.consultarDados();

                    break;
                case 4:
                    sorteio(aposta);
                    contagemNum(numeros);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
            }
            if (opcao == 4){
                break;
            }
            menu();
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("\n");
        }
    }


    //Método que cria o menu de opções
    public void menu(){
        System.out.println("\nEscolha uma das opções disponíveis.");
        System.out.println("[1] Realizar uma aposta normal (escolhendo os cinco números).");
        System.out.println("[2] Realizar uma aposta surpresa (os cinco números são aleatórios).");
        System.out.println("[3] Consultar os dados das apostas já registradas.");
        System.out.println("[4] Finalizar a fase de apostas.");
        System.out.println("[0] Sair.");
    }

    //Método que recebe os dados e a aposta do apostador
    //Os números apostados devem estar entre 1 e 50 e não podem ser repetidos
    public void apostaNormal(){
        int[] num = new int[5];
        System.out.println("Digite seu nome completo.");
        String nome = sc.nextLine();
        System.out.println("Digite seu CPF.");
        String CPF = sc.nextLine();


        System.out.println("Digite o primeiro número.");
        num[0] = sc.nextInt();
        numeros.add(num[0]);
        while (num[0]< 0 || num[0] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[0] = sc.nextInt();
        }

        System.out.println("Digite o segundo número.");
        num[1] = sc.nextInt();
        while (num[1]< 0 || num[1] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[1] = sc.nextInt();
        }
        if (num[1] == num[0]){
            while (num[1] == num [0]){
                System.out.println("Número repetido. Digite um número diferente");
                num[1] = sc.nextInt();
            }
        }
        numeros.add(num[1]);

        System.out.println("Digite o terceiro número.");
        num[2] = sc.nextInt();
        while (num[2]< 0 || num[2] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[2] = sc.nextInt();
        }
        if (num[2] == num[1] || num[2] == num[0]){
            while (num[2] == num[1] || num[2] == num[0]){
                System.out.println("Número repetido. Digite um número diferente");
                num[2] = sc.nextInt();
            }
        }
        numeros.add(num[2]);

        System.out.println("Digite o quarto número.");
        num[3] = sc.nextInt();
        while (num[3]< 0 || num[3] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[3] = sc.nextInt();
        }
        if (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]) {
            while (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]){
                System.out.println("Número repetido. Digite um número diferente");
                num[3] = sc.nextInt();
            }
        }
        numeros.add(num[3]);

        System.out.println("Digite o quinto número.");
        num[4] = sc.nextInt();
        while (num[4]< 0 || num[4] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[4] = sc.nextInt();
        }
        if (num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
            while(num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
                System.out.println("Número repetido. Digite um número diferente");
                num[4] = sc.nextInt();
            }
        }
        numeros.add(num[4]);

        sc.nextLine();
        System.out.println("\nConfira se suas informações pessoais estão corretas e selecione uma das opções disponíveis.");
        System.out.println("Nome: "+nome+"\nCPF: "+CPF);
        System.out.println("\n[1] Sim, estão corretas.\n[2]Não, digitar novemente.");
        int opcao2 = sc.nextInt();
        sc.nextLine();
        switch (opcao2){
            case 1:
                break;
            case 2:
                System.out.println("Digite seu nome completo.");
                nome = sc.nextLine();
                System.out.println("Digite seu CPF.");
                CPF = sc.nextLine();
                break;
        }

        Apostador a = new Apostador(nome, CPF, num);
        aposta.realizarAposta(a);
        System.out.println("Aposta realizada!");
        System.out.println("Apostador: "+a.getNome());
        System.out.println("CPF: "+a.getCpf());
        System.out.println("Números apostados: "+Arrays.toString(num));
        System.out.println("\n=========================");
    }


    //Método para a aposta surpresa
    //Também verifica se os números não se repetem. Caso seja gerado um número repetido, ele será sorteado novamente.
    public void apostaSurpresa(){
        int[] num = new int[5];
        System.out.println("Digite seu nome completo.");
        String nome = sc.nextLine();
        System.out.println("Digite seu CPF.");
        String CPF = sc.nextLine();
        num[0] = gerar.nextInt(51);
            while (num[0] == 0){
                num[0] = gerar.nextInt(51);
            }
        numeros.add(num[0]);
        num[1] = gerar.nextInt(51);
        if (num[1] == num[0] || num [1] == 0){
            while (num[1] == num [0] || num [1] == 0){
                num[1] = gerar.nextInt(51);
            }
        }
        numeros.add(num[1]);
        num[2] = gerar.nextInt(51);
        if (num[2] == num[1] || num[2] == num[0] || num[2] == 0){
            while (num[2] == num[1] || num[2] == num[0] || num[2] == 0){
                num[2] = gerar.nextInt(51);
            }
        }
        numeros.add(num[2]);
        num[3] = gerar.nextInt(51);
        if (num[3] == num[0] || num[3] == num[1] || num[3] == num[2] || num[3] == 0) {
            while (num[3] == num[0] || num[3] == num[1] || num[3] == num[2] || num[3] == 0){
                num[3] = gerar.nextInt(51);
            }
        }
        numeros.add(num[3]);
        num[4] = gerar.nextInt(51);
        if (num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3] || num[4] == 0){
            while(num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3] || num[4] == 0){
                num[4] = gerar.nextInt(51);
            }
        }
        numeros.add(num[4]);
        System.out.println("\nConfira se suas informações pessoais estão corretas e selecione uma das opções disponíveis.");
        System.out.println("Nome: "+nome+"\nCPF: "+CPF);
        System.out.println("\n[1] Sim, estão corretas.\n[2]Não, digitar novemente.");
        int opcao2 = sc.nextInt();
        sc.nextLine();
        switch (opcao2){
            case 1:
                break;
            case 2:
                System.out.println("Digite seu nome completo.");
                nome = sc.nextLine();
                System.out.println("Digite seu CPF.");
                CPF = sc.nextLine();
                break;
        }

        Apostador a = new Apostador(nome, CPF, num);
        aposta.realizarAposta(a);
        System.out.println("Aposta realizada!");
        System.out.println("Apostador: "+a.getNome());
        System.out.println("CPF: "+a.getCpf());
        System.out.println("Número de registro da aposta: "+a.getRegistro());
        System.out.println("Números apostados: "+Arrays.toString(num));
        System.out.println("\n=========================");
    }


    //Método que realiza o sorteio dos números vencedores
    //O resultado pode possuir números repetidos, ou seja, os números são aleatórios e não serão sorteados novamente
    int numAdd = 5;
    public void sorteio(Aposta a) {
        System.out.println("Encerrar a fase de apostas e ir para o sorteio?");
        System.out.println("[1] Sim \n[2] Não");

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:

            //ArrayList <Integer> resultado = new ArrayList<Integer>();
            ArrayList<Apostador> vencedores = new ArrayList<Apostador>();

            int[] result = new int[5];
            //int[] result = new int[5];
            result[0] = gerar.nextInt(51);
            while (result[0] == 0) {
                result[0] = gerar.nextInt(51);
            }


            result[1] = gerar.nextInt(51);
            if (result[1] == result[0] || result[1] == 0) {
                while (result[1] == result[0] || result[1] == 0) {
                    result[1] = gerar.nextInt(51);
                }
            }


            result[2] = gerar.nextInt(51);
            if (result[2] == result[1] || result[2] == result[0] || result[2] == 0) {
                while (result[2] == result[1] || result[2] == result[0] || result[2] == 0) {
                    result[2] = gerar.nextInt(51);
                }
            }


            result[3] = gerar.nextInt(51);
            if (result[3] == result[0] || result[3] == result[1] || result[3] == result[2] || result[3] == 0) {
                while (result[3] == result[0] || result[3] == result[1] || result[3] == result[2] || result[3] == 0) {
                    result[3] = gerar.nextInt(51);
                }
            }


            result[4] = gerar.nextInt(51);
            if (result[4] == result[0] || result[4] == result[1] || result[4] == result[2] || result[4] == result[3] || result[4] == 0) {
                while (result[4] == result[0] || result[4] == result[1] || result[4] == result[2] || result[4] == result[3] || result[4] == 0) {
                    result[4] = gerar.nextInt(51);
                }
            }
            //result[0] = 1;
            //result[1] = 2;
            //result[2] = 3;
            //result[3] = 4;
            //result[4] = 5;

            ArrayList<Apostador> vencedor = new ArrayList<Apostador>();
            System.out.println("Números sorteados: " + Arrays.toString(result));

            int numAd = 5;
            int v = 0;
            for (int i = 0; i < aposta.compararAposta().size(); i++) {
                int[] b = aposta.compararAposta().get(i).getAposta();
                int quant = 0;
                for (int j = 0; j < b.length; j++) {
                    for (int k = 0; k < result.length; k++) {
                        if (b[i] == result[k]) {
                            quant++;
                            //break;
                        }
                    }
                }
                if (quant == 5) {
                    vencedor.add(aposta.compararAposta().get(i));
                    v++;
                } else {

                    //System.out.println(Arrays.toString(result));
                    break;

                }


            }
            if (vencedor.isEmpty()) {
                System.out.println("Não há vencedores.");
            } else {
                System.out.println("Vencedores:\n" + vencedor);
                System.out.println("\nNúmero total de vencedores: " + v);
                System.out.println("Parabéns aos vencedores!!!! Programem-se para retirar seu prêmio!!!!!");
            }
            break;
            case 2:
                break;
            default:
                System.out.println("Opção inválida. Digite uma opção válida.");

        }
    }


    public void contagemNum(ArrayList <Integer> n){
        ArrayList<Numeros> lista = new ArrayList<Numeros>(50);
        for (int k = 1; k <= 50; k++) {
            Numeros n1 = new Numeros(k, 0);
            lista.add(n1);
        }
        for (int i = 0; i< n.size(); i++){
            //Método que vai contar as repetições dos números apostados
            //Referência para a criação do método https://www.paradoxofinal.com.br/2011/06/arrays-elementos-repetidos-e-numero-de.html. Acesso em 19/03/2024
            boolean encontrou = false;
            for (int j = 0; j < lista.size(); j++){
                //lista.get(j).setValor(j);
                if (n.get(i).equals(lista.get(j).getValor())){
                    lista.get(j).cont++;
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou){
                lista.add(new Numeros(n.get(i), 1));
            }
        }
        lista.sort(Comparator.comparing(Numeros:: getCont).reversed());
        System.out.println("[Número, Repetições]");
        for(Numeros n1 : lista){

            System.out.println("[" + n1.valor + ", " + n1.cont + "]");
        }
    }



}