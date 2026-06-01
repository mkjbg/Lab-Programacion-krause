package ej3.tp4;

public class Main {

    public static void main(String[] args) {

        Libro libro =
                new Libro(1,
                        20000,
                        "Borges");

        System.out.println(
                libro.calcularPrecioFinal()
        );
    }
}
