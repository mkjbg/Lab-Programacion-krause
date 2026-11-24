package empleados.dao;

import empleados.conexion.ConexionBD;
import empleados.model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoImpl {

    public Connection ConexionBd() throws SQLException {
        return ConexionBD.Conectar();
    }

    public void Crear(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO empleados (nombre, apellido, dni, cargo, salario, activo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getDni());
            ps.setString(4, empleado.getCargo());
            ps.setDouble(5, empleado.getSalario());
            ps.setBoolean(6, empleado.isActivo());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) empleado.setId(rs.getInt(1));
            }
        }
    }

    public void Actualizar(Empleado empleado) throws SQLException {
        String sql = "UPDATE empleados SET nombre=?, apellido=?, dni=?, cargo=?, salario=?, activo=? WHERE id=?";
        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getDni());
            ps.setString(4, empleado.getCargo());
            ps.setDouble(5, empleado.getSalario());
            ps.setBoolean(6, empleado.isActivo());
            ps.setInt(7, empleado.getId());
            ps.executeUpdate();
        }
    }

    public void Eliminar(int id) throws SQLException {
        String sql = "UPDATE empleados SET activo = FALSE WHERE id = ?";
        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Empleado ListarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM empleados WHERE id = ?";
        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapearEmpleado(rs);
            }
        }
        return null;
    }

    public List<Empleado> ListarTodo() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados WHERE activo = TRUE";
        try (Connection con = ConexionBd();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapearEmpleado(rs));
        }
        return lista;
    }

    public Empleado BuscarPorDni(int dni) throws SQLException {
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapearEmpleado(rs);
            }
        }
        return null;
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getInt("dni"),
                rs.getString("cargo"),
                rs.getDouble("salario"),
                rs.getBoolean("activo")
        );
    }
}
