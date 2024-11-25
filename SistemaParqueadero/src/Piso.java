import java.util.List;
public class Piso {
    //Atributos:
    private int numero;
    private static int contador = 1;
    //Asociacion:
    private List <Plaza> plazas;
    public Piso(List <Plaza> plazas) {
        this.numero = contador;
        this.plazas = plazas;
        contador++;
    }
}
