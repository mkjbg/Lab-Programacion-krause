package ej2.tp7;

public class Libro {

    private String titulo;
    private String isbn;
    private int cantidadPaginas;

    public Libro(String titulo, String isbn, int cantidadPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void mostrarLibro() {
        System.out.println("Título: " + titulo + " | ISBN: " + isbn + " | Páginas: " + cantidadPaginas);
    }
}
