package ej5.tp4;

public class MenuVegano extends Menu {

    private double proteinaVegetal;

    public MenuVegano(String diaSemana,
                      int caloriasTotales,
                      double proteinaVegetal) {

        super(diaSemana, caloriasTotales);
        this.proteinaVegetal = proteinaVegetal;
    }

    public double getProteinaVegetal() {
        return proteinaVegetal;
    }

    public void setProteinaVegetal(double proteinaVegetal) {
        this.proteinaVegetal = proteinaVegetal;
    }
}
