import java.util.*;

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
                    contagemNum(numeros);
                    //for (int i = 0; i < numeros.size(); i++){
                    //    System.out.println(numeros.get(i));
                    //}
                    break;
                case 4:
                    sorteio();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
            }
            menu();
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("\n");
        }
    }


    //Método que cria o menu de opções
    public void menu(){
        System.out.println("Bem vindo(a) à fase de apostas.\nEscolha uma das opções disponíveis.");
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
        System.out.println("Confira se suas informações pessoais estão corretas.");
        System.out.println("Nome: "+nome+"\nCPF: "+CPF);
        System.out.println("[1] Sim, estão corretas.\n[2]Não, digitar novemente.");
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
        numeros.add(num[0]);
        num[1] = gerar.nextInt(51);
        if (num[1] == num[0]){
            while (num[1] == num [0]){
                num[1] = gerar.nextInt(51);
            }
        }
        numeros.add(num[1]);
        num[2] = gerar.nextInt(51);
        if (num[2] == num[1] || num[2] == num[0]){
            while (num[2] == num[1] || num[2] == num[0]){
                num[2] = gerar.nextInt(51);
            }
        }
        numeros.add(num[2]);
        num[3] = gerar.nextInt(51);
        if (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]) {
            while (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]){
                num[3] = gerar.nextInt(51);
            }
        }
        numeros.add(num[3]);
        num[4] = gerar.nextInt(51);
        if (num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
            while(num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
                num[4] = gerar.nextInt(51);
            }
        }
        numeros.add(num[4]);
        System.out.println("Confira se suas informações pessoais estão corretas.");
        System.out.println("Nome: "+nome+"\nCPF: "+CPF);
        System.out.println("[1] Sim, estão corretas.\n[2]Não, digitar novemente.");
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
    public void sorteio(){
        Resultado resultado;
        int[] num = new int[5];
        num[0] = gerar.nextInt(51);
        num[1] = gerar.nextInt(51);
        if (num[1] == num[0]){
            while (num[1] == num [0]){
                num[1] = gerar.nextInt(51);
            }
        }
        num[2] = gerar.nextInt(51);
        if (num[2] == num[1] || num[2] == num[0]){
            while (num[2] == num[1] || num[2] == num[0]){
                num[2] = gerar.nextInt(51);
            }
        }
        num[3] = gerar.nextInt(51);
        if (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]) {
            while (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]){
                num[3] = gerar.nextInt(51);
            }
        }
        num[4] = gerar.nextInt(51);
        if (num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
            while(num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
                num[4] = gerar.nextInt(51);
            }
        }
        resultado = new Resultado(num);
    }


    //Método que vai contar as repetições dos números apostados
    //Referência para a criação do método https://www.paradoxofinal.com.br/2011/06/arrays-elementos-repetidos-e-numero-de.html. Acesso em 19/03/2024
    private boolean encontrou;
    public void contagemNum(ArrayList <Integer> n){
        ArrayList<Numeros> lista = new ArrayList<Numeros>();
        for (int i = 0; i< n.size(); i++){
            encontrou = false;
            for (int j = 0; j < lista.size(); j++){
                if (n.get(i).equals(lista.get(j))){
                    lista.get(j).cont++;
                    encontrou = true;
                    break;
                }
            }
            if (!encontrou){
                lista.add(new Numeros(n.get(i), 1));
            }
        }
        System.out.println("[Número, Repetições]");
        for(Numeros n1 : lista){
            System.out.println("[" + n1.valor + ", " + n1.cont + "]");
        }
    }



}