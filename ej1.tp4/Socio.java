package ej1.tp4;

import java.util.ArrayList;
import java.util.List;

public class Socio {

    private int nroSocio;
    private String nombre;
    private List<Reserva> reservas;

    public Socio(int nroSocio, String nombre) {
        this.nroSocio = nroSocio;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}