package tpArrayList;

public class Main {

    public static void main(String[] args) {

        Curso curso = new Curso("5°2°");

        Estudiante es1 = new Estudiante("Valentino Benito", "44219322", 8.5);
        Estudiante es2 = new Estudiante("Dylan Kim", "95005875", 7.2);
        Estudiante es3 = new Estudiante("Facundo Quintana", "43837458", 9.1);

        curso.inscribir(es1);
        curso.inscribir(es2);
        curso.inscribir(es3);

        System.out.println("Cantidad de alumnos: " + curso.cantidadAlumnos());

        curso.darDeBaja(1);

        System.out.println("\nAlumnos restantes:");
        curso.listarAlumnos();
    }
}
