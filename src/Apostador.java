import java.util.Arrays;
import java.util.InputMismatchException;

public class Apostador {
    private String nome, cpf;
    private int[] aposta = new int[5];
    private int registro;

    //Construtor de Apostador, que registra os dados da pessoa e a aposta realizada.
    public Apostador(String nome, String cpf, int[] aposta) {
        this.nome = nome;
        this.cpf = cpf;
        this.aposta = aposta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int[] getAposta() {
        return aposta;
    }

    public void setAposta(int[] aposta) {
        this.aposta = aposta;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Apostador{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", aposta=" + Arrays.toString(aposta) +
                ", registro=" + registro +
                '}';
    }
}

