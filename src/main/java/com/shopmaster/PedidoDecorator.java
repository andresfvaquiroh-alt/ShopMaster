
package com.shopmaster;

public abstract class PedidoDecorator implements Pedido {

    protected final Pedido pedido;

    public PedidoDecorator(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException(
                    "El pedido no puede ser nulo."
            );
        }

        this.pedido = pedido;
    }

    @Override
    public double getCosto() {
        return pedido.getCosto();
    }

    @Override
    public String getDescripcion() {
        return pedido.getDescripcion();
    }
}
