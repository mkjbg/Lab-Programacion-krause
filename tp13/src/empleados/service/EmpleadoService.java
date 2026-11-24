package empleados.service;

import empleados.dao.EmpleadoDaoImpl;
import empleados.model.Empleado;
import empleados.excepciones.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class EmpleadoService {
    private final EmpleadoDaoImpl dao;
    private static final List<String> CARGOS_PERMITIDOS =
            Arrays.asList("Analista", "Desarrollador", "Gerente", "Soporte");

    public EmpleadoService() {
        this.dao = new EmpleadoDaoImpl();
    }

    public EmpleadoService(EmpleadoDaoImpl dao) {
        this.dao = dao;
    }

    public void Registrar(String nombre, String apellido, int dni,
                          String cargo, double salario)
            throws DniInvalidoException, DniDuplicadoException,
                   SalarioInvalidoException, CargoInvalidoException, SQLException {
        validarDatos(nombre, apellido, dni, cargo, salario);

        if (dao.BuscarPorDni(dni) != null) {
            throw new DniDuplicadoException("El DNI " + dni + " ya está registrado.");
        }

        Empleado nuevo = new Empleado(nombre.trim(), apellido.trim(), dni,
                normalizarCargo(cargo), salario, true);
        dao.Crear(nuevo);
    }

    public void Actualizar(int id, String nombre, String apellido, int dni,
                           String cargo, double salario)
            throws DniInvalidoException, DniDuplicadoException,
                   SalarioInvalidoException, CargoInvalidoException,
                   EmpleadoNoEncontradoException, SQLException {
        Empleado existente = dao.ListarPorId(id);
        if (existente == null) {
            throw new EmpleadoNoEncontradoException("No existe un empleado con ID " + id + ".");
        }

        validarDatos(nombre, apellido, dni, cargo, salario);

        Empleado encontradoPorDni = dao.BuscarPorDni(dni);
        if (encontradoPorDni != null && encontradoPorDni.getId() != id) {
            throw new DniDuplicadoException("El DNI " + dni + " pertenece a otro empleado.");
        }

        existente.setNombre(nombre.trim());
        existente.setApellido(apellido.trim());
        existente.setDni(dni);
        existente.setCargo(normalizarCargo(cargo));
        existente.setSalario(salario);
        dao.Actualizar(existente);
    }

    public void Eliminar(int id)
            throws EmpleadoNoEncontradoException, EmpleadoYaInactivoException, SQLException {
        Empleado empleado = dao.ListarPorId(id);
        if (empleado == null) {
            throw new EmpleadoNoEncontradoException("No existe un empleado con ID " + id + ".");
        }
        if (!empleado.isActivo()) {
            throw new EmpleadoYaInactivoException("El empleado con ID " + id + " ya fue dado de baja.");
        }
        dao.Eliminar(id);
    }

    public Empleado ListarPorId(int id) throws EmpleadoNoEncontradoException, SQLException {
        Empleado empleado = dao.ListarPorId(id);
        if (empleado == null) {
            throw new EmpleadoNoEncontradoException("No existe un empleado con ID " + id + ".");
        }
        return empleado;
    }

    public List<Empleado> ListarTodo() throws SQLException {
        return dao.ListarTodo();
    }

    private void validarDatos(String nombre, String apellido, int dni,
                              String cargo, double salario)
            throws DniInvalidoException, SalarioInvalidoException, CargoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }

        String dniTexto = String.valueOf(dni);
        if (dni < 0 || (dniTexto.length() != 7 && dniTexto.length() != 8)) {
            throw new DniInvalidoException("El DNI debe contener exactamente 7 u 8 dígitos.");
        }
        if (salario <= 0 || Double.isNaN(salario) || Double.isInfinite(salario)) {
            throw new SalarioInvalidoException("El salario debe ser un número válido mayor que cero.");
        }
        if (normalizarCargoSeguro(cargo) == null) {
            throw new CargoInvalidoException("Cargo no permitido. Opciones: Analista, Desarrollador, Gerente o Soporte.");
        }
    }

    private String normalizarCargoSeguro(String cargo) {
        if (cargo == null) return null;
        for (String permitido : CARGOS_PERMITIDOS) {
            if (permitido.equalsIgnoreCase(cargo.trim())) return permitido;
        }
        return null;
    }

    private String normalizarCargo(String cargo) {
        return normalizarCargoSeguro(cargo);
    }
}
