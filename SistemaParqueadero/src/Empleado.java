public abstract class Empleado extends Persona {
    //Atributos:
    private static int contador = 1;
    protected String identificacion;
    protected float salario;
    //Constructor:
    public Empleado(String nombre, String cedula, String telefono, float salario) {
        super(nombre, cedula, telefono);
        this.identificacion = "E"+contador;
        this.salario = salario;
        contador++;
    }
}
