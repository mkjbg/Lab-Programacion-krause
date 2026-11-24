package empleados.excepciones;

public class SalarioInvalidoException extends Exception {
    public SalarioInvalidoException() {
        super("El salario debe ser mayor que cero.");
    }

    public SalarioInvalidoException(String mensaje) {
        super(mensaje);
    }
}
