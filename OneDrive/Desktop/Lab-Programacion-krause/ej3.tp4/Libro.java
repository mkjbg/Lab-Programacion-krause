package ej3.tp4;

public class Libro extends Producto {

    private String autor;

    public Libro(int codigo,
                 double precio,
                 String autor) {

        super(codigo, precio);

        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio() * 1.10;
    }
}
