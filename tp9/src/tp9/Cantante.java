package tp9;

public class Cantante implements Contratable {

    private String nombre;
    private String genero;
    private int cachet;
    private int cantidadCanciones;
    private String manager;
    private String escenario;

    public Cantante(String nombre, String genero, int cachet,
                    int cantidadCanciones, String manager) {

        this.nombre = nombre;
        this.genero = genero;
        this.cachet = cachet;
        this.cantidadCanciones = cantidadCanciones;
        this.manager = manager;
        this.escenario = "";
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getCachet() {
        return cachet;
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    public String getManager() {
        return manager;
    }

    public String getEscenario() {
        return escenario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCachet(int cachet) {
        this.cachet = cachet;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    @Override
    public void liquidarHonorarios(double impuestos)
            throws IllegalArgumentException {

        if (impuestos < 0 || impuestos > 100) {
            throw new IllegalArgumentException(
                    "El porcentaje de impuestos es inválido."
            );
        }

        double honorarios = cachet - (cachet * impuestos / 100);

        System.out.println("Honorarios de " + nombre + ": $" +
                String.format("%.2f", honorarios));
    }

    @Override
    public void asignarEscenario(String nombreEscenario)
            throws NullPointerException {

        if (nombreEscenario == null) {
            throw new NullPointerException(
                    "El escenario no puede ser nulo."
            );
        }

        escenario = nombreEscenario;

        System.out.println(nombre + " fue asignado al " + escenario);
    }

    @Override
    public String toString() {

        return "Cantante: " + nombre +
                "\nGénero: " + genero +
                "\nCachet: $" + cachet +
                "\nCanciones: " + cantidadCanciones +
                "\nManager: " + (manager == null ? "Sin manager" : manager) +
                "\nEscenario: " + escenario +
                "\n";
    }

}