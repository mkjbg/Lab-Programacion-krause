package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDaoImpl {

    public Connection ConexionBd() throws SQLException {
        return ConexionBD.Conectar();
    }

    public void Crear(Estudiante e) {
        String sql = "INSERT INTO estudiantes (nombre, apellido, dni, curso) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setInt(3, e.getDni());
            ps.setString(4, e.getCurso());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    e.setId(rs.getInt(1));
                }
            }
            System.out.println("Estudiante registrado: " + e.getNombre() + " " + e.getApellido());

        } catch (SQLException ex) {
            System.out.println("Error al crear estudiante: " + ex.getMessage());
        }
    }

    public void Actualizar(Estudiante e) {
        String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, dni = ?, curso = ? WHERE id = ?";

        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setInt(3, e.getDni());
            ps.setString(4, e.getCurso());
            ps.setInt(5, e.getId());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Estudiante con ID " + e.getId() + " actualizado.");
            } else {
                System.out.println("No se encontró el estudiante con ID " + e.getId());
            }

        } catch (SQLException ex) {
            System.out.println("Error al actualizar estudiante: " + ex.getMessage());
        }
    }

    public void Eliminar(int id) {
        String sql = "DELETE FROM estudiantes WHERE id = ?";

        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Estudiante con ID " + id + " eliminado.");
            } else {
                System.out.println("No se encontró el estudiante con ID " + id);
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar estudiante: " + ex.getMessage());
        }
    }

    public Estudiante ListarPorId(int id) {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";

        try (Connection con = ConexionBd();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Estudiante(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("dni"),
                            rs.getString("curso")
                    );
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar estudiante: " + ex.getMessage());
        }
        return null;
    }

    public List<Estudiante> ListarTodo() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes ORDER BY id";

        try (Connection con = ConexionBd();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Estudiante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("dni"),
                        rs.getString("curso")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar estudiantes: " + ex.getMessage());
        }
        return lista;
    }
}
