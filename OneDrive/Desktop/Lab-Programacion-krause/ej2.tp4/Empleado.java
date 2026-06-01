package ej2.tp4;

public class Empleado {

    protected int legajo;
    protected double sueldoBase;

    public Empleado(int legajo,
                    double sueldoBase) {

        this.legajo = legajo;
        this.sueldoBase = sueldoBase;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {

        if (sueldoBase >= 0) {
            this.sueldoBase = sueldoBase;
        }
    }
}
