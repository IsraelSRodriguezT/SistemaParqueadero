public class Motocicleta extends Vehiculo{
    //Atributos:
    private boolean tieneMaletero;
    //Constructor;
    public Motocicleta(String color, String matricula, String modelo, Cliente cliente, boolean tieneMaletero) {
        super(color, matricula, modelo, cliente);
        this.tieneMaletero = tieneMaletero;
    }
}
