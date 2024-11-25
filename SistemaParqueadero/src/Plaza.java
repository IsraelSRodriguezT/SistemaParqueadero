public class Plaza {
    //Atributos:
    private boolean estaDisponible;
    private int numero;
    private static int contador = 1;
    //Asociacion:
    private TipoVehiculo tipoVehiculo;
    //Constructor:
    public Plaza(TipoVehiculo tipoVehiculo) {
        this.estaDisponible = true;
        this.numero = contador;
        this.tipoVehiculo = tipoVehiculo;
        contador++;
    }
    //Getter:
    public boolean isEstaDisponible() {
        return estaDisponible;
    }
    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
    public int getNumero() {
        return numero;
    }
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}
