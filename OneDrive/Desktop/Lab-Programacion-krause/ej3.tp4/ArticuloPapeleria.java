package ej3.tp4;

public class ArticuloPapeleria
extends Producto {

private String tipoMaterial;

public ArticuloPapeleria(int codigo,
                     double precio,
                     String tipoMaterial) {

super(codigo, precio);

this.tipoMaterial = tipoMaterial;
}

public String getTipoMaterial() {
return tipoMaterial;
}

public void setTipoMaterial(
    String tipoMaterial) {

this.tipoMaterial = tipoMaterial;
}

@Override
public double calcularPrecioFinal() {
return getPrecio();
}
}