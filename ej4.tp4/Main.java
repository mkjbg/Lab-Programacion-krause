package ej4.tp4;

public class Main {

    public static void main(String[] args) {

        Cancion cancion =
                new Cancion("Imagine", 180);

        Playlist playlist =
                new Playlist("Favoritas",
                        "Rock");

        playlist.agregarCancion(cancion);

        System.out.println(
                playlist.getCanciones().size()
        );
    }
}