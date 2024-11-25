import java.time.Duration;
import java.time.LocalTime;
public class PagoFinal {
    //Atributos:
    private float costoTotal;
    private int horasTranscurridas;
    //Asociacion:
    private Boleto boleto;
    //Enumerador:
    private MetodoPago metodoPago;
    //Constructor:
    public PagoFinal(Boleto boleto) {
        this.boleto = boleto;
        this.horasTranscurridas = calcularHorasTranscurridas();
        this.costoTotal = calcularCostoTotal();
    }
    //Getter:
    public float getCostoTotal() {
        return costoTotal;
    }
    //Metodos:
    public int calcularHorasTranscurridas() {
        LocalTime horaActual = LocalTime.now();
        Duration duracion = Duration.between(boleto.getHoraIngreso(), horaActual);
        return (int) duracion.toHours();
    }
    public float calcularCostoTotal(){
        if(horasTranscurridas==0){
            float costoTotal = boleto.getCostoHora();
        } else {
            float costoTotal = boleto.getCostoHora() * horasTranscurridas;
        }
        return costoTotal;
    }
}
