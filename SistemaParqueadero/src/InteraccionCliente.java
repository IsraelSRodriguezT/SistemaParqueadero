public interface InteraccionCliente {
    public void agregarCliente(String nombre, String cedula, String telefono);
    public void agregarAutomovilCliente(String cedulaCliente,String color, String matricula,String modelo,
                                        boolean tieneLLantaRepuesto);
    public void agregarBicicletaCliente(String cedulaCliente, String color, String matricula,String modelo,
                                        boolean tieneCadenaSeguridad);
    public void agregarMotocicletaCliente(String cedulaCliente,String color, String matricula,String modelo,
                                          boolean tieneMaletero);
    public void atenderCliente(String cedulaCliente);
    public void atenderSalidaCliente(String cedulaCliente);
    public void comprarSuscripcion(String cedulaCliente,int cantidadMeses,MetodoPago metodoPago);
    public void reservarPlaza(String cedulaCliente, TipoVehiculo tipoVehiculo, int numero);
}
