package ej6.tp4;

public class Tren extends Unidad {

    private int cantidadVagones;

    public Tren(int idInterno,
                int capacidadPasajeros,
                int cantidadVagones) {

        super(idInterno, capacidadPasajeros);

        this.cantidadVagones = cantidadVagones;
    }

    public int getCantidadVagones() {
        return cantidadVagones;
    }

    public void setCantidadVagones(int cantidadVagones) {

        if (cantidadVagones > 0) {
            this.cantidadVagones = cantidadVagones;
        } else {
            System.out.println("Debe haber al menos un vagón");
        }
    }

    public void arrancar() {
        System.out.println("El tren arrancó");
    }

    public void frenar() {
        System.out.println("El tren frenó");
    }
}