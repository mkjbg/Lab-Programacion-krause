package empleados;

import empleados.model.Empleado;
import empleados.service.EmpleadoService;
import empleados.excepciones.*;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpleadoService service = new EmpleadoService();
        int idPrueba = -1;
        int dniPrueba = 45123456;

        try {
            System.out.println("=== REGISTRO VÁLIDO ===");
            service.Registrar("Aaron", "Serrano", dniPrueba, "Desarrollador", 850000.50);
            Empleado registrado = buscarPorDni(service, dniPrueba);
            if (registrado != null) {
                idPrueba = registrado.getId();
                System.out.println("Empleado registrado: " + registrado);
            }
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException
                 | CargoInvalidoException e) {
            System.out.println("No se pudo registrar: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos al registrar: " + e.getMessage());
        }

        System.out.println("\n=== PRUEBA: DNI INVÁLIDO ===");
        try {
            service.Registrar("Carlos", "Pérez", 1234, "Analista", 700000);
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException
                 | CargoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }

        System.out.println("\n=== PRUEBA: DNI DUPLICADO ===");
        try {
            service.Registrar("Otro", "Empleado", dniPrueba, "Soporte", 600000);
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException
                 | CargoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }

        System.out.println("\n=== PRUEBA: SALARIO INVÁLIDO ===");
        try {
            service.Registrar("Lucía", "Gómez", 41222333, "Gerente", -500);
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException
                 | CargoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }

        System.out.println("\n=== PRUEBA: CARGO INVÁLIDO ===");
        try {
            service.Registrar("Martín", "Díaz", 42333444, "Tester", 700000);
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException
                 | CargoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }

        System.out.println("\n=== PRUEBA: ACTUALIZAR ID INEXISTENTE ===");
        try {
            service.Actualizar(999999, "Roberto", "García", 45666777, "Analista", 900000);
        } catch (DniInvalidoException | DniDuplicadoException | SalarioInvalidoException
                 | CargoInvalidoException | EmpleadoNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }

        if (idPrueba != -1) {
            System.out.println("\n=== PRUEBA: ELIMINAR DOS VECES ===");
            try {
                service.Eliminar(idPrueba);
                System.out.println("Primera baja lógica realizada correctamente.");
                service.Eliminar(idPrueba);
            } catch (EmpleadoNoEncontradoException | EmpleadoYaInactivoException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error de base de datos: " + e.getMessage());
            }
        }

        System.out.println("\n=== PRUEBA: LISTAR ID INEXISTENTE ===");
        try {
            System.out.println(service.ListarPorId(999999));
        } catch (EmpleadoNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }

        System.out.println("\n=== EMPLEADOS ACTIVOS ===");
        try {
            List<Empleado> empleados = service.ListarTodo();
            if (empleados.isEmpty()) System.out.println("No hay empleados activos.");
            for (Empleado empleado : empleados) System.out.println(empleado);
        } catch (SQLException e) {
            System.out.println("No se pudo listar: " + e.getMessage());
        }
    }

    private static Empleado buscarPorDni(EmpleadoService service, int dni) throws SQLException {
        empleados.dao.EmpleadoDaoImpl dao = new empleados.dao.EmpleadoDaoImpl();
        return dao.BuscarPorDni(dni);
    }
}
