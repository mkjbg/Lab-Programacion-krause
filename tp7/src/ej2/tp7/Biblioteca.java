package ej2.tp7;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libro;

    public Biblioteca() {
        libro = new ArrayList<>();
    }

    public void agregarLibro(Libro Libro) {
        libro.add(Libro);
    }

    public void listarLibro() {
        for (Libro libro : libro) {
            libro.mostrarLibro();
        }
    }

    public int cantidadLibros() {
        return libro.size();
    }
}