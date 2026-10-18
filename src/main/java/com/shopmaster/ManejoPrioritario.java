
package com.shopmaster;

public class ManejoPrioritario extends PedidoDecorator {

    private static final double COSTO_PRIORITARIO = 25_000;

    public ManejoPrioritario(Pedido pedido) {
        super(pedido);
    }

    @Override
    public double getCosto() {
        return pedido.getCosto() + COSTO_PRIORITARIO;
    }

    @Override
    public String getDescripcion() {
        return pedido.getDescripcion()
                + " + Manejo prioritario frágil";
    }
}
