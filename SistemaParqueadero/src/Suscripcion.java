import java.time.LocalDate;
import java.util.List;

public class Suscripcion {
    //Atributos:
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadMeses;
    private float valorFinal;
    private float valorMes = 32.5f;
    //Asociacion:
    private Cliente cliente;
    private List <Vehiculo> vehiculos;
    //Enumerador:
    private MetodoPago metodoPago;
    //Constructor:
    public Suscripcion(int cantidadMeses, MetodoPago metodoPago, Cliente cliente) {
        this.fechaInicio = LocalDate.now();
        this.cantidadMeses = cantidadMeses;
        this.cliente = cliente;
        this.fechaFin = fechaInicio.plusMonths(cantidadMeses);
        this.metodoPago = metodoPago;
        this.vehiculos = cliente.getVehiculos();
        this.valorFinal = valorMes*cantidadMeses;
        System.out.println("{ El cliente "+cliente.getNombre()+" se suscribio por "+cantidadMeses+" meses }");
        System.out.println("{ La suscripcion cuesta $"+valorMes+" por mes, y en total se pago $"+valorFinal+" }");
    }
}
