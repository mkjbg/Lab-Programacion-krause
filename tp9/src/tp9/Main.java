package tp9;

public class Main {

    public static void main(String[] args) {

        String[][] datosCantantes = {
                {"Taylor Swift", "Pop", "1500000", "18", "Tree Paine"},
                {"Bad Bunny", "Reggaeton", "RECHAZADO", "12", "Noah Assad"}, // Error numérico
                {"Coldplay", "Rock", "1200000", "3", "Phil Harvey"},          // Menos de 5 canciones
                {"Duki", "Trap", "500000", "14", null}                        // Manager nulo
        };

        Festival festival = new Festival();

        for (String[] fila : datosCantantes) {

            try {

                String nombre = fila[0];
                String genero = fila[1];
                int cachet = Integer.parseInt(fila[2]);
                int canciones = Integer.parseInt(fila[3]);
                String manager = fila[4];

                Cantante cantante = new Cantante(
                        nombre,
                        genero,
                        cachet,
                        canciones,
                        manager
                );

                festival.agregarCantante(cantante);

                cantante.asignarEscenario("Escenario Principal");

                cantante.liquidarHonorarios(15);

                festival.realizarSoundcheck(cantante);

                try {
                    System.out.println("Manager: " + cantante.getManager().toUpperCase());
                } catch (NullPointerException e) {
                    System.out.println("El cantante no posee manager.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Error al convertir un dato numérico.");

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());

            } catch (EspectaculoCortoException e) {

                System.out.println(e.getMessage());

            } finally {

                System.out.println("-----------------------------------------");

            }

        }

        System.out.println("\n===== CANTANTES CARGADOS =====");
        festival.mostrarCantantes();

    }

}