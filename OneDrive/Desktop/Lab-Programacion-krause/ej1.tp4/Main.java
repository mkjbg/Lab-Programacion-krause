package ej1.tp4;

public class Main {

    public static void main(String[] args) {

        Socio socio =
                new Socio(1, "Juan");

        Reserva reserva =
                new Reserva("10/05/2026",
                        "Fútbol",
                        socio);

        socio.agregarReserva(reserva);

        System.out.println(
                socio.getReservas().size()
        );
    }
}
