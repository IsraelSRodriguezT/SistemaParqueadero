import java.util.List;
public class Cajero extends Empleado{
    //Constructor:
    public Cajero(String nombre, String cedula, String telefono, float salario) {
        super(nombre, cedula, telefono, salario);
    }
    //Metodos:
    public boolean verificarBoleto(Boleto boleto, List <Boleto> boletoList){
        if(boletoList.contains(boleto)){
            return true;
        }
        return false;
    }
}
