public class Automovil extends Vehiculo{
    //Atributos:
    private boolean tieneLlantaRepuesto;
    //Constructor:
    public Automovil(String color, String matricula, String modelo, Cliente cliente, boolean tieneLlantaRepuesto) {
        super(color, matricula, modelo, cliente);
        this.tieneLlantaRepuesto = tieneLlantaRepuesto;
    }
}
