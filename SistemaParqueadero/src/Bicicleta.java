public class Bicicleta extends Vehiculo {
    //Atributos:
    private boolean tieneCadenaSeguridad;
    //Constructor:
    public Bicicleta(String color, String matricula, String modelo, Cliente cliente, boolean tieneCadenaSeguridad) {
        super(color, matricula, modelo, cliente);
        this.tieneCadenaSeguridad = tieneCadenaSeguridad;
    }
}
