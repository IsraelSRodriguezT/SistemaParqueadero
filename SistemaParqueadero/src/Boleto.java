import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Boleto {
    //Atributos:
    private int codigo;
    private static int contador = 1;
    private float costoHora = 1.5f;
    private LocalDate fechaActual;
    private LocalTime horaIngreso;
    private boolean estaSuscrito;
    //Asociacion:
    private Cliente cliente;
    //Constructor:
    public Boleto(Cliente cliente) {
        this.codigo = contador;
        this.fechaActual = LocalDate.now();
        this.horaIngreso = LocalTime.now();
        this.cliente = cliente;
        this.estaSuscrito = verificarSuscripcion();
        mostrarInformacion();
        contador++;
    }
    //Getter:
    public int getCodigo() {
        return codigo;
    }
    public float getCostoHora() {
        return costoHora;
    }
    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }
    //Metodos:
    public void mostrarInformacion(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        if(estaSuscrito){
            System.out.println("| Boleto: "+codigo+" | Fecha: "+fechaActual+" | Hora de Ingreso: "+
                    horaIngreso.format(formatter)+ " | Cliente: "+cliente.getNombre()+" | Cedula: "+
                    cliente.getCedula()+" | Tiene suscripcion : Si |");
        } else {
            System.out.println("| Boleto: "+codigo+" | Fecha: "+fechaActual+" | Hora de Ingreso: "+
                    horaIngreso.format(formatter)+ " | Cliente: "+cliente.getNombre()+" | Cedula: "+
                    cliente.getCedula()+" | Precio por c/h: "+ costoHora+" |");
        }
    }
    public boolean verificarSuscripcion(){
        if(cliente.esClienteRegular()){
            return true;
        }
        return false;
    }
}
