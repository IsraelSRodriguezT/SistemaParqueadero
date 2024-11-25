public abstract class Persona {
    //Atributos:
    protected String nombre;
    protected String cedula;
    protected String telefono;
    //Constructor:
    public Persona(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }
    //Getter:
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
}
