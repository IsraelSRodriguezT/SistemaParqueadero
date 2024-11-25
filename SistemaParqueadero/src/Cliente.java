import java.util.ArrayList;
import java.util.List;
public class Cliente extends Persona{
    //Atributos:
    private boolean esClienteRegular;
    //Asociacion:
    private Suscripcion suscripcion;
    private List <Vehiculo> vehiculos;
    private Boleto boleto;
    //Constructor:
    public Cliente(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.vehiculos = new ArrayList<>();
        this.esClienteRegular = false;
    }
    //Getter:
    public boolean esClienteRegular() {
        return esClienteRegular;
    }
    public Suscripcion getSuscripcion() {
        return suscripcion;
    }
    public Boleto getBoleto() {
        return boleto;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setEsClienteRegular(boolean esClienteRegular) {
        this.esClienteRegular = esClienteRegular;
    }
    //Metodos:
    public void suscribirse(int cantidadMeses, MetodoPago metodoPago){
        this.suscripcion = new Suscripcion(cantidadMeses,metodoPago,this);
        setEsClienteRegular(true);
    }
    public void recibirBoleto(Boleto boleto){
        this.boleto = boleto;
        System.out.println(nombre+" recibio el boleto "+boleto.getCodigo());
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
}
