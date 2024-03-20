import java.util.ArrayList;

public class Aposta {
    private ArrayList<Apostador> apostas;

    //Construtor de Aposta inicializa o arraylist de Apostadores
    public Aposta() {
        apostas = new ArrayList<Apostador>();
    }

    //Método que recebe o apostador e adicona-o ao array
    //Marca o número do registro de cada apostador
    int cont = 1000;

    public void realizarAposta(Apostador a) {

        a.setRegistro(cont);
        apostas.add(a);
        cont++;
    }

    //Método utilizado para consultar as informaçoes dos apostadores registrados
    public void consultarDados() {
        if (!apostas.isEmpty()) {
            for (int i = 0; i < apostas.size(); i++) {
                Apostador a = apostas.get(i);
                System.out.println("Apostador " + (i + 1) + "\n" + a.toString());
            }
        }

    }

    //Método que vai retornar o array das apostas para, em outro método, comparar com o resultado
    public ArrayList<Apostador> compararAposta() {
        return apostas;
    }
}

