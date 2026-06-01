package ej2.tp4;

public class Main {

    public static void main(String[] args) {

        Gerente gerente =
                new Gerente(100,
                        500000,
                        100000);

        System.out.println(
                gerente.getLegajo()
        );

        System.out.println(
                gerente.getBonoResponsabilidad()
        );
    }
}
