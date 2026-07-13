package tp9;

import java.util.ArrayList;

public class Festival {

    private ArrayList<Cantante> cantantes;

    public Festival() {
        cantantes = new ArrayList<>();
    }

    public void agregarCantante(Cantante c) {
        cantantes.add(c);
    }

    public void mostrarCantantes() {

        for (Cantante c : cantantes) {
            System.out.println(c);
        }

    }

    public void realizarSoundcheck(Cantante c)
            throws EspectaculoCortoException {

        if (c.getCantidadCanciones() < 5) {
            throw new EspectaculoCortoException(
                    "El cantante " + c.getNombre()
                    + " tiene menos de 5 canciones programadas."
            );
        }

        System.out.println("Soundcheck aprobado para " + c.getNombre());

    }

}