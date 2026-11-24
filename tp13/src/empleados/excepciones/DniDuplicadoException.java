package empleados.excepciones;

public class DniDuplicadoException extends Exception {
    public DniDuplicadoException() {
        super("Ya existe un empleado registrado con ese DNI.");
    }

    public DniDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
