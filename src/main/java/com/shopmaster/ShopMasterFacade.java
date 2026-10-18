
package com.shopmaster;

public class ShopMasterFacade {

    public boolean ejecutarCompraRapida(
            String usuario,
            ComponenteProducto producto,
            boolean garantia,
            boolean empaqueRegalo,
            boolean manejoPrioritario
    ) {
        System.out.println("\n========================================");
        System.out.println("       SHOPMASTER - COMPRA RÁPIDA");
        System.out.println("========================================");
        System.out.println("Cliente: " + usuario);

        if (producto == null) {
            System.out.println(
                    "[ERROR] No se puede comprar un producto nulo."
            );
            return false;
        }

        System.out.println("\n1. CATÁLOGO Y DESGLOSE DEL PRODUCTO");
        producto.mostrar("");

        // Pedido base: puede ser un producto o un combo.
        Pedido pedido = new Pedido() {

            @Override
            public double getCosto() {
                return producto.getPrecio();
            }

            @Override
            public String getDescripcion() {
                return producto.getNombre();
            }
        };

        System.out.printf(
                "%nPrecio base: $%,.0f COP%n",
                pedido.getCosto()
        );

        // Decoración dinámica del pedido.
        System.out.println("\n2. SERVICIOS ADICIONALES");

        if (garantia) {
            pedido = new GarantiaExtendida(pedido);
            System.out.println("- Garantía extendida activada (+10%).");
        }

        if (empaqueRegalo) {
            pedido = new EmpaqueRegalo(pedido);
            System.out.println("- Empaque premium activado (+$15.000).");
        }

        if (manejoPrioritario) {
            pedido = new ManejoPrioritario(pedido);
            System.out.println(
                    "- Manejo prioritario activado (+$25.000)."
            );
        }

        if (!garantia && !empaqueRegalo && !manejoPrioritario) {
            System.out.println("- Sin servicios adicionales.");
        }

        System.out.println("\nDetalle: " + pedido.getDescripcion());
        System.out.printf(
                "Total final: $%,.0f COP%n",
                pedido.getCosto()
        );

        // El proxy recibe el pago antes de que llegue a StripeUSA.
        System.out.println("\n3. PROCESAMIENTO DEL PAGO");

        ProcesadorPago pasarela = new StripeUSAAdapter();
        ProcesadorPago proxy =
                new ProcesadorPagoProxy(pasarela);

        boolean aprobado = proxy.cobrarEnPesos(
                usuario, pedido.getCosto()
        );

        System.out.println("\n4. RESULTADO DE LA COMPRA");

        if (aprobado) {
            System.out.println(
                    "COMPRA COMPLETADA EXITOSAMENTE."
            );
        } else {
            System.out.println(
                    "COMPRA NO PROCESADA."
            );
        }

        System.out.println("========================================\n");

        return aprobado;
    }
}
