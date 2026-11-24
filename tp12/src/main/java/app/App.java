package app;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Service service = new Service();

        service.Registrar("Mateo", "Gonzalez", 40111222, "5to 1ra");
        service.Registrar("Lucia", "Fernandez", 41222333, "5to 2da");
        service.Registrar("Tomas", "Ramirez", 42333444, "6to 1ra");
        service.Registrar("Valentina", "Lopez", 43444555, "6to 2da");
        service.Registrar("Benjamín", "Martinez", 44555666, "5to 1ra");
        service.Registrar("Camila", "Sanchez", 45666777, "5to 2da");
        service.Registrar("Nicolas", "Perez", 46777888, "6to 1ra");
        service.Registrar("Sofia", "Romero", 47888999, "6to 2da");
        service.Registrar("Joaquin", "Diaz", 48999000, "5to 1ra");
        service.Registrar("Mia", "Torres", 49000111, "5to 2da");

        System.out.println("\n--- LISTA INICIAL DE ESTUDIANTES ---");
        mostrarLista(service.ListarTodo());

        System.out.println("\n--- ELIMINAR ESTUDIANTE ID = 4 ---");
        service.Eliminar(4);

        System.out.println("\n--- ACTUALIZAR ESTUDIANTE ID = 6 ---");
        service.Actualizar(6, "Camila", "Suarez", 45666777, "6to 1ra");

        System.out.println("\n--- ACTUALIZAR ESTUDIANTE ID = 8 ---");
        service.Actualizar(8, "Sofia", "Acosta", 47888999, "6to 2da");

        System.out.println("\n--- LISTA FINAL DE ESTUDIANTES ---");
        mostrarLista(service.ListarTodo());
    }

    private static void mostrarLista(List<Estudiante> estudiantes) {
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
