package ej5.tp4;

public class Menu {

    private String diaSemana;
    private int caloriasTotales;

    public Menu(String diaSemana, int caloriasTotales) {
        this.diaSemana = diaSemana;
        setCaloriasTotales(caloriasTotales);
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getCaloriasTotales() {
        return caloriasTotales;
    }

    // Validación para evitar calorías negativas
    public void setCaloriasTotales(int caloriasTotales) {

        if (caloriasTotales >= 0) {
            this.caloriasTotales = caloriasTotales;
        } else {
            System.out.println("Las calorías no pueden ser negativas");
        }
    }
}
