
package com.shopmaster;

public class StripeUSAAdapter implements ProcesadorPago {

    private static final double TASA_CAMBIO = 4000.0;
    private static final String CLAVE_COMERCIAL =
            "SHOPMASTER_USA_DEMO_KEY";

    private StripeUSA stripeUSA;

    @Override
    public boolean cobrarEnPesos(
            String usuario,
            double montoCOP
    ) {
        if (stripeUSA == null) {
            stripeUSA = new StripeUSA();
        }

        double montoUSD = montoCOP / TASA_CAMBIO;

        String correo = usuario + "@shopmaster.com";

        System.out.printf(
                "%n[ADAPTER] Conversión: $%,.0f COP / %.0f"
                        + " = USD $%,.2f%n",
                montoCOP, TASA_CAMBIO, montoUSD
        );

        return stripeUSA.chargeInDollars(
                montoUSD,
                correo,
                CLAVE_COMERCIAL
        );
    }
}
