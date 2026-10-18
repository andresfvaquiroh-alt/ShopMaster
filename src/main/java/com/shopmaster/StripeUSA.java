
package com.shopmaster;

public class StripeUSA {

    public StripeUSA() {
        System.out.println(
                "[STRIPE USA] Conexión con la pasarela inicializada."
        );
    }

    public boolean chargeInDollars(
            double amountUSD,
            String customerEmail,
            String merchantKey
    ) {
        System.out.println("\n--- PASARELA STRIPE USA ---");
        System.out.println("Correo del cliente: " + customerEmail);
        System.out.printf(
                "Monto recibido: USD $%,.2f%n",
                amountUSD
        );
        System.out.println(
                "Clave comercial recibida: "
                        + (merchantKey != null
                        && !merchantKey.isBlank()
                        ? "[CONFIGURADA]" : "[FALTANTE]")
        );

        if (merchantKey == null || merchantKey.isBlank()) {
            System.out.println(
                    "[STRIPE USA] Error: falta la clave comercial."
            );
            return false;
        }

        System.out.println(
                "[STRIPE USA] Pago procesado correctamente."
        );

        return true;
    }
}
