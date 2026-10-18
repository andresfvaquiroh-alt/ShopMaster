
package com.shopmaster;

public class Producto implements ComponenteProducto {

    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo."
            );
        }

        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrar(String prefijo) {
        System.out.printf(
                "%s- %s: $%,.0f COP%n",
                prefijo, nombre, precio
        );
    }
}
