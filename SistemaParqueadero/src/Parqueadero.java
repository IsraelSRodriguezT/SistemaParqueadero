import java.util.ArrayList;
import java.util.List;
public class Parqueadero implements InteraccionCliente{
    //Atributos:
    private String nombre;
    private String numero;
    //Asociacion:
    private Direccion direccion;
    private List <Cliente> clientes;
    private List <Cajero> cajeros;
    private List <Supervisor> supervisores;
    private List <Boleto> boletos;
    private List <PagoFinal> pagoFinalList;
    //Composicion;
    private List <Piso> pisos;
    private List <Plaza> plazas;
    //Constructor:
    public Parqueadero(String nombre, String numero, Direccion direccion) {
        this.nombre = nombre;
        this.numero = numero;
        this.direccion = direccion;
        this.pisos = new ArrayList<>();
        this.plazas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.cajeros = new ArrayList<>();
        this.supervisores = new ArrayList<>();
        this.boletos = new ArrayList<>();
        this.pagoFinalList = new ArrayList<>();
    }
    //Metodos:
    public void agregarCajero(String nombre, String cedula, String telefono, float salario){
        cajeros.add(new Cajero(nombre,cedula,telefono,salario));
    }
    public void agregarSupervisor(String nombre, String cedula, String telefono, float salario){
        supervisores.add(new Supervisor(nombre,cedula,telefono,salario));
    }
    public void mostrarPlazasDisponibles(){
        System.out.println("<------------ PLazas Disponibles ------------>");
        for (Plaza plaza : plazas){
            if(plaza.isEstaDisponible()){
                System.out.println("| PLaza: "+plaza.getNumero()+" | Para: "+plaza.getTipoVehiculo()+" | <- Esta disponible");
            }
        }
        System.out.println("_____________________________________________");
    }
    public void generarPlazasPiso(int cantidadPLazas, int plazasAutomovil, int plazasBicicleta, int plazasMotocicleta){
        List <Plaza> plazasPiso = new ArrayList<>();
        if(plazasAutomovil+plazasBicicleta+plazasMotocicleta==cantidadPLazas){
            for(int i = 0 ; i < plazasAutomovil ; i++){
                Plaza plaza = new Plaza(TipoVehiculo.AUTOMOVIL);
                plazas.add(plaza);
                plazasPiso.add(plaza);
            }
            for(int i = 0 ; i < plazasBicicleta ; i++){
                Plaza plaza = new Plaza(TipoVehiculo.BICICLETA);
                plazas.add(plaza);
                plazasPiso.add(plaza);
            }
            for(int i = 0 ; i < plazasMotocicleta ; i++){
                Plaza plaza = new Plaza(TipoVehiculo.MOTOCICLETA);
                plazas.add(plaza);
                plazasPiso.add(plaza);
            }
            Piso piso = new Piso(plazasPiso);
            pisos.add(piso);
        } else{
            System.out.println("! La cantidad de plazas para cada vehiculo exceden al total de cantidad " +
                    "de plazas que deberian de existir !");
        }
    }
    @Override
    public void agregarCliente(String nombre, String cedula, String telefono) {
        clientes.add(new Cliente(nombre, cedula, telefono));
    }
    @Override
    public void agregarAutomovilCliente(String cedulaCliente,String color, String matricula,String modelo,
                                        boolean tieneLLantaRepuesto){
        Cliente clienteAgregar = comprobarCliente(cedulaCliente);
        if(clienteAgregar==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
            clienteAgregar.agregarVehiculo(new Automovil(color,matricula,modelo,clienteAgregar,tieneLLantaRepuesto));
        }
    }
    @Override
    public void agregarBicicletaCliente(String cedulaCliente, String color, String matricula,String modelo,
                                        boolean tieneCadenaSeguridad){
        Cliente clienteAgregar = comprobarCliente(cedulaCliente);
        if(clienteAgregar==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
            clienteAgregar.agregarVehiculo(new Bicicleta(color,matricula,modelo,clienteAgregar,tieneCadenaSeguridad));
        }
    }
    @Override
    public void agregarMotocicletaCliente(String cedulaCliente,String color, String matricula,String modelo,
                                          boolean tieneMaletero){
        Cliente clienteAgregar = comprobarCliente(cedulaCliente);
        if(clienteAgregar==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
            clienteAgregar.agregarVehiculo(new Motocicleta(color,matricula,modelo,clienteAgregar,tieneMaletero));
        }
    }
    @Override
    public void atenderCliente(String cedulaCliente) {
        Cliente clienteAtender = comprobarCliente(cedulaCliente);
        if (clienteAtender == null) {
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else {
            Boleto boleto = new Boleto(clienteAtender);
            clienteAtender.recibirBoleto(boleto);
            boletos.add(boleto);
        }
    }
    public Cliente comprobarCliente(String cedulaCliente){
        for (Cliente cliente :clientes){
            if(cliente.getCedula().equals(cedulaCliente)){
                return cliente;
            }
        }
        return null;
    }
    @Override
    public void comprarSuscripcion(String cedulaCliente,int cantidadMeses,MetodoPago metodoPago) {
        Cliente clienteSuscribirse = comprobarCliente(cedulaCliente);
        if(clienteSuscribirse==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
            clienteSuscribirse.suscribirse(cantidadMeses,metodoPago);
        }
    }
    @Override
    public void atenderSalidaCliente(String cedulaCliente) {
        Cliente clienteSalida = comprobarCliente(cedulaCliente);
        if(clienteSalida==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else {
            if (clienteSalida.esClienteRegular()) {
                for (Cajero cajero : cajeros) {
                    if (cajero.verificarBoleto(clienteSalida.getBoleto(), boletos)) {
                        PagoFinal pagoFinal = new PagoFinal(clienteSalida.getBoleto());
                        pagoFinalList.add(pagoFinal);
                        System.out.println(clienteSalida.getNombre() + " puede salir directamente debido a que " +
                                "posee suscripcion");
                        return;
                    }
                }
            } else {
                for (Cajero cajero : cajeros) {
                    if (cajero.verificarBoleto(clienteSalida.getBoleto(), boletos)) {
                        PagoFinal pagoFinal = new PagoFinal(clienteSalida.getBoleto());
                        pagoFinalList.add(pagoFinal);
                        System.out.println(clienteSalida.getNombre() + " debe de pagar para salir");
                        return;
                    }
                }
            }

        }
    }
    @Override
    public void reservarPlaza(String cedulaCliente, TipoVehiculo tipoVehiculo, int numero) {
        Cliente clienteReservar = comprobarCliente(cedulaCliente);
        if(clienteReservar==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
            boolean i = false;
            for(Plaza plaza : plazas){
                if(plaza.getNumero()==numero && plaza.isEstaDisponible() && plaza.getTipoVehiculo()==tipoVehiculo){
                    plaza.setEstaDisponible(false);
                    System.out.println("Se reservo la plaza "+plaza.getNumero()+" para "+clienteReservar.getNombre());
                    i = true;
                }
            }
            if(!i){
                System.out.println("! No se pudo reservar la plaza escogida!");
            }
        }
    }
}
