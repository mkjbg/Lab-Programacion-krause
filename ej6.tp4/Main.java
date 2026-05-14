package ej6.tp4;

public class Main {

    public static void main(String[] args) {

        Colectivo colectivo =
                new Colectivo(
                        1,
                        40,
                        152
                );

        Tren tren =
                new Tren(
                        2,
                        300,
                        8
                );

        colectivo.arrancar();
        colectivo.frenar();

        tren.arrancar();
        tren.frenar();

        System.out.println(
                "Línea: "
                + colectivo.getNumeroLinea()
        );

        System.out.println(
                "Cantidad de vagones: "
                + tren.getCantidadVagones()
        );
    }
}