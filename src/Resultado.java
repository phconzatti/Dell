import java.util.Arrays;

public class Resultado {
    private int [] resultado;

    public Resultado(int [] resultado){
        this.resultado = resultado;
    }

    public int[] getResultado() {
        return resultado;
    }

    public void setResultado(int[] resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "resultado=" + Arrays.toString(resultado) +
                '}';
    }
}
