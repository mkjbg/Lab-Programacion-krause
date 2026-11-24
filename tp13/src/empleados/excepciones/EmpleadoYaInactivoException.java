package empleados.excepciones;

public class EmpleadoYaInactivoException extends Exception {
    public EmpleadoYaInactivoException() {
        super("El empleado ya se encuentra inactivo.");
    }

    public EmpleadoYaInactivoException(String mensaje) {
        super(mensaje);
    }
}
