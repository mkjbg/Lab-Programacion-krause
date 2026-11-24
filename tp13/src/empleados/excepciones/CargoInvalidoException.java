package empleados.excepciones;

public class CargoInvalidoException extends Exception {
    public CargoInvalidoException() {
        super("El cargo ingresado no está permitido.");
    }

    public CargoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
