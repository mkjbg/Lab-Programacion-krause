package ej5.tp4;

import java.util.ArrayList;
import java.util.List;

public class Cocinero {

    private String nombre;
    private List<Menu> menus;

    public Cocinero(String nombre) {
        this.nombre = nombre;
        this.menus = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void agregarMenu(Menu menu) {
        menus.add(menu);
    }
}
