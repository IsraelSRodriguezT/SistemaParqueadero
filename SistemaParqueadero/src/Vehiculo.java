public abstract class Vehiculo {
    //Atributos:
    protected String color;
    protected String matricula;
    protected String modelo;
    //Agregacion:
    protected Cliente cliente;
    //Constructor:
    public Vehiculo(String color, String matricula, String modelo, Cliente cliente) {
        this.color = color;
        this.matricula = matricula;
        this.modelo = modelo;
    }
    //Getter:
    public String getMatricula() {
        return matricula;
    }
}
