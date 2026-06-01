package ej6.tp4;

public class Unidad {

    private int idInterno;
    private int capacidadPasajeros;

    public Unidad(int idInterno, int capacidadPasajeros) {
        this.idInterno = idInterno;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(int idInterno) {
        this.idInterno = idInterno;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {

        if (capacidadPasajeros >= 0) {
            this.capacidadPasajeros = capacidadPasajeros;
        } else {
            System.out.println("La capacidad no puede ser negativa");
        }
    }

    public void arrancar() {
        System.out.println("La unidad arrancó");
    }

    public void frenar() {
        System.out.println("La unidad frenó");
    }
}
