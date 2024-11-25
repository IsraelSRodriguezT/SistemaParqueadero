public class Main {
    public static void main(String[] args) {
        Direccion direccion = new Direccion("Olmedo","10 de agosto","Sector Centro");
        Parqueadero parqueadero = new Parqueadero("Parqueadero Central","0964389279",direccion);
        parqueadero.generarPlazasPiso(25,16,3,6);
        parqueadero.agregarCajero("Juan","1102863860","0943897890",500);
        parqueadero.agregarSupervisor("Jose","1108568790","0946823169",650);
        parqueadero.agregarCliente("Ivan","1109878970","0958979169");
        parqueadero.agregarCliente("Luis","1108769090","0913429867");
        parqueadero.agregarAutomovilCliente("1109878970","rojo","kls-002","2022",
                true);
        parqueadero.agregarMotocicletaCliente("1109878970","azul","xps-231","2024",
                false);
        parqueadero.agregarAutomovilCliente("1108769090","Gris","lso-143","2023",
                true);
        parqueadero.mostrarPlazasDisponibles();
        parqueadero.atenderCliente("1109878970");
        parqueadero.atenderCliente("1108769090");
        parqueadero.atenderSalidaCliente("1109878970");
        parqueadero.atenderSalidaCliente("1108769090");
        parqueadero.comprarSuscripcion("1109878970",3,MetodoPago.TARJETA);
        parqueadero.atenderCliente("1109878970");
        parqueadero.reservarPlaza("1108769090",TipoVehiculo.AUTOMOVIL,5);
        parqueadero.atenderCliente("1108769090");
        parqueadero.atenderSalidaCliente("1109878970");
        parqueadero.atenderSalidaCliente("1108769090");
    }
}