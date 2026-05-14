package ej2.tp4;

public class Gerente extends Empleado {

    private double bonoResponsabilidad;

    public Gerente(int legajo,
                   double sueldoBase,
                   double bonoResponsabilidad) {

        super(legajo, sueldoBase);

        this.bonoResponsabilidad =
                bonoResponsabilidad;
    }

    public double getBonoResponsabilidad() {
        return bonoResponsabilidad;
    }

    public void setBonoResponsabilidad(
            double bonoResponsabilidad) {

        this.bonoResponsabilidad =
                bonoResponsabilidad;
    }
}
