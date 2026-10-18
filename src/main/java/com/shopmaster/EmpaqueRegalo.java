
package com.shopmaster;

public class EmpaqueRegalo extends PedidoDecorator {

    private static final double COSTO_EMPAQUE = 15_000;

    public EmpaqueRegalo(Pedido pedido) {
        super(pedido);
    }

    @Override
    public double getCosto() {
        return pedido.getCosto() + COSTO_EMPAQUE;
    }

    @Override
    public String getDescripcion() {
        return pedido.getDescripcion()
                + " + Empaque de regalo premium";
    }
}
