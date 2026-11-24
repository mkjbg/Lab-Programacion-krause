package empleados.excepciones;

public class EmpleadoNoEncontradoException extends Exception {
    public EmpleadoNoEncontradoException() {
        super("No se encontró el empleado solicitado.");
    }

    public EmpleadoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
