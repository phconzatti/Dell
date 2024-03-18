import java.util.ArrayList;
import java.util.InputMismatchException;

public class Aposta {
    private ArrayList <Apostador> apostas;

    //Construtor de Aposta inicializa o arraylist de Apostadores
    public Aposta(){
        apostas = new ArrayList<Apostador>();
    }

    //Método que recebe o apostador e adicona-o ao array
    //Marca o número do registro de cada apostador
    int cont = 1000;
    public void realizarAposta(Apostador a){

        a.setRegistro(cont);
        apostas.add(a);
        cont++;
    }

    //Método utilizado para consultar as informaçoes dos apostadores registrados
    public void consultarDados(){
        if(!apostas.isEmpty()) {
            for (int i = 0; i < apostas.size(); i++) {
                Apostador a = apostas.get(i);
                System.out.println("Apostador "+(i+1)+"\n"+a.toString());
            }
        }

    }



    //Método que vai retornar o array das apostas para, em outro método, comparar com o resultado
    public Apostador compararAposta(){
        return null;
    }


    //Método que vai verificar a validade do CPF digitado
    //A fonte para a criação do método foi o site https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097. Acessado em 10/03/2024.

    public boolean isCPF(String CPF){
        if (CPF.equals("00000000000")||CPF.equals("11111111111")||CPF.equals("22222222222")||CPF.equals("33333333333")||CPF.equals("44444444444")||
                CPF.equals("55555555555")||CPF.equals("66666666666")||CPF.equals("77777777777")||CPF.equals("88888888888")||CPF.equals("99999999999")|| (CPF.length() != 11)){
            return false;
        }
        //Início da verificação do décimo número do CPF ou primeiro dígito verificador
        String d10, d11;
        int sm, r, num, peso;
        try{
            sm = 0;
            peso = 10;
            for (int i = 0; i < 9; i++){
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if (r == 10 || r == 11){
                d10 = "0";
            } else {
                d10 = String.valueOf((char)(r + 48)); //Aqui acaba a verificação do décimo número ou primeiro dígito verificador
            }
            sm = 0;
            peso = 11;
            for (int i = 0; i < 10; i++){
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if (r == 10 || r == 11){
                d11 = "0";

            } else {
                d11 = String.valueOf((char)(r = 48));
            }
            if (d10 == CPF.charAt(9) && d11 == CPF.charAt(10)){
                return true;
            } else {
                return false;
            }
        } catch (InputMismatchException error){
            return false;
        }

    }
    public void setarCPF(String CPF, Apostador a){
        if (isCPF(CPF)){
            CPF = CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
            a.setCpf(CPF);
        }
    }

}
