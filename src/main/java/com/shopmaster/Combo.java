
package com.shopmaster;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ComponenteProducto {

    private final String nombre;
    private final List<ComponenteProducto> componentes;

    public Combo(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregar(ComponenteProducto componente) {
        if (componente == null || componente == this) {
            throw new IllegalArgumentException(
                    "El componente no puede ser nulo ni el propio combo."
            );
        }

        componentes.add(componente);
    }

    public void eliminar(ComponenteProducto componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        double total = 0;

        for (ComponenteProducto componente : componentes) {
            total += componente.getPrecio();
        }

        return total;
    }

    @Override
    public void mostrar(String prefijo) {
        System.out.println(prefijo + "+ Combo: " + nombre);

        for (ComponenteProducto componente : componentes) {
            componente.mostrar(prefijo + "   ");
        }

        System.out.printf(
                "%s  Subtotal de %s: $%,.0f COP%n",
                prefijo, nombre, getPrecio()
        );
    }
}
