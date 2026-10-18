
package com.shopmaster;

public class ProcesadorPagoProxy implements ProcesadorPago {

    private static final double LIMITE_COP = 5_000_000;

    private final ProcesadorPago procesadorReal;

    public ProcesadorPagoProxy(
            ProcesadorPago procesadorReal
    ) {
        if (procesadorReal == null) {
            throw new IllegalArgumentException(
                    "El procesador no puede ser nulo."
            );
        }

        this.procesadorReal = procesadorReal;
    }

    @Override
    public boolean cobrarEnPesos(
            String usuario,
            double montoCOP
    ) {
        System.out.println("\n--- CONTROL DE SEGURIDAD ---");
        System.out.println("Usuario: " + usuario);
        System.out.printf(
                "Monto solicitado: $%,.0f COP%n",
                montoCOP
        );

        if (usuario == null
                || usuario.trim().equalsIgnoreCase("BLOQUEADO")) {
            System.out.println(
                    "[SEGURIDAD] TRANSACCIÓN RECHAZADA: "
                            + "usuario reportado."
            );
            return false;
        }

        if (montoCOP < 0 || montoCOP > LIMITE_COP) {
            System.out.println(
                    "[SEGURIDAD] TRANSACCIÓN RECHAZADA: "
                            + "el monto supera el límite permitido "
                            + "de $5.000.000 COP o no es válido."
            );
            return false;
        }

        System.out.println(
                "[AUDITORÍA: Transacción aprobada para "
                        + usuario + "]"
        );

        return procesadorReal.cobrarEnPesos(
                usuario, montoCOP
        );
    }
}

