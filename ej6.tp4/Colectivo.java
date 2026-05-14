package ej6.tp4;

public class Colectivo extends Unidad {

    private int numeroLinea;

    public Colectivo(int idInterno,
                      int capacidadPasajeros,
                      int numeroLinea) {

        super(idInterno, capacidadPasajeros);

        this.numeroLinea = numeroLinea;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public void arrancar() {
        System.out.println("El colectivo arrancó");
    }

    public void frenar() {
        System.out.println("El colectivo frenó");
    }
}
