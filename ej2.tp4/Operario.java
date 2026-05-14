package ej2.tp4;

public class Operario extends Empleado {

    private double valorHoraExtra;

    public Operario(int legajo,
                    double sueldoBase,
                    double valorHoraExtra) {

        super(legajo, sueldoBase);

        this.valorHoraExtra = valorHoraExtra;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }
}