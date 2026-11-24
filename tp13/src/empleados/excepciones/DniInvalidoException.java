package empleados.excepciones;

public class DniInvalidoException extends Exception {
    public DniInvalidoException() {
        super("El DNI debe tener 7 u 8 dígitos.");
    }

    public DniInvalidoException(String mensaje) {
        super(mensaje);
    }
}
