package ej1.tp4;

public class Reserva {

    private String fecha;
    private String tipoDeporte;
    private Socio socio;

    public Reserva(String fecha,
                   String tipoDeporte,
                   Socio socio) {

        this.fecha = fecha;
        this.tipoDeporte = tipoDeporte;
        this.socio = socio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
