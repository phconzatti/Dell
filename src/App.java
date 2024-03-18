import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class App {
    private Aposta aposta;
    private Scanner sc;

    public App() {
        aposta = new Aposta();
        sc = new Scanner(System.in);
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
        System.out.println("Digite seu nome.");
        String nome = sc.nextLine();
        System.out.println("Digite seu CPF utilizando apenas números (sem os caracteres especiais)");
        String CPF = sc.nextLine();
        aposta.isCPF(CPF);

        System.out.println("Digite o primeiro número.");
        num[0] = sc.nextInt();
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
        System.out.println("Digite o terceiro número.");
        num[2] = sc.nextInt();
        while (num[2]< 0 || num[2] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[2] = sc.nextInt();
        }
        if (num[2] == num[1] || num[2] == num[0]){
            while (num[2] == num[1] || num[2] == num[0]){
                System.out.println("Número inválido. Digite um número de 1 a 50.");
                num[2] = sc.nextInt();
            }
        }
        System.out.println("Digite o quarto número.");
        num[3] = sc.nextInt();
        while (num[3]< 0 || num[3] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[3] = sc.nextInt();
        }
        if (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]) {
            while (num[3] == num[0] || num[3] == num[1] || num[3] == num[2]){
                System.out.println("Número inválido. Digite um número de 1 a 50.");
                num[3] = sc.nextInt();
            }
        }

        System.out.println("Digite o quinto número.");
        num[4] = sc.nextInt();
        while (num[4]< 0 || num[4] > 50) {
            System.out.println("Número inválido. Digite um número de 1 a 50.");
            num[4] = sc.nextInt();
        }
        if (num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
            while(num[4] == num[0] || num[4] == num[1] || num[4] == num[2] || num[4] == num[3]){
                System.out.println("Número inválido. Digite um número de 1 a 50.");
                num[4] = sc.nextInt();
            }
        }
        sc.nextLine();

        Apostador a = new Apostador(nome, CPF, num);
        aposta.setarCPF(CPF, a);
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
        System.out.println("Digite seu nome.");
        String nome = sc.nextLine();
        System.out.println("Digite seu CPF utilizando apenas números (sem os caracteres especiais)");
        String CPF = sc.nextLine();
        if (aposta.isCPF(CPF)){
            CPF = CPF;
        } else {
            while(!aposta.isCPF(CPF)){
                System.out.println("Número de CPF inválido. Por favor, digite um CPF válido.");
                CPF = sc.nextLine();
            }
        }
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

        Apostador a = new Apostador(nome, CPF, num);
        aposta.setarCPF(CPF, a);
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

    //public void

    public void finalizar(){

    }



}