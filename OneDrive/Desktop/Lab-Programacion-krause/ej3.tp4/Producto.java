package ej3.tp4;

public abstract class Producto {

    protected int codigo;
    private double precio;

    public Producto(int codigo,
                    double precio) {

        this.codigo = codigo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public abstract double calcularPrecioFinal();
}