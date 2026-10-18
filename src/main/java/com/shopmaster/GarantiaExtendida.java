
package com.shopmaster;

public class GarantiaExtendida extends PedidoDecorator {

    public GarantiaExtendida(Pedido pedido) {
        super(pedido);
    }

    @Override
    public double getCosto() {
        return pedido.getCosto() * 1.10;
    }

    @Override
    public String getDescripcion() {
        return pedido.getDescripcion()
                + " + Garantía extendida (10%)";
    }
}
