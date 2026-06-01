package ej5.tp4;

public class Main {

    public static void main(String[] args) {

        MenuVegano menuVegano =
                new MenuVegano(
                        "Lunes",
                        1200,
                        35
                );

        MenuCeliaco menuCeliaco =
                new MenuCeliaco(
                        "Martes",
                        900,
                        true
                );

        Cocinero cocinero =
                new Cocinero("Carlos");

        cocinero.agregarMenu(menuVegano);
        cocinero.agregarMenu(menuCeliaco);

        System.out.println(
                "Cantidad de menús: "
                + cocinero.getMenus().size()
        );

        System.out.println(
                menuVegano.getProteinaVegetal()
        );

        System.out.println(
                menuCeliaco.getCertificadoSinTACC()
        );
    }
}