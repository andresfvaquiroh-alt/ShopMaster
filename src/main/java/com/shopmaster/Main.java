
package com.shopmaster;

public class Main {

    public static void main(String[] args) {

        ShopMasterFacade shopMaster = new ShopMasterFacade();

        // ==========================================
        // CASO 1: COMPRA EXITOSA COMPLETA
        // ==========================================

        System.out.println("\n\n");
        System.out.println("########################################");
        System.out.println("# CASO 1: COMPRA EXITOSA COMPLETA");
        System.out.println("########################################");

        // Productos individuales.
        Producto monitor = new Producto(
                "Monitor Gamer", 800_000
        );

        Producto teclado = new Producto(
                "Teclado Mecánico", 200_000
        );

        Producto liquido = new Producto(
                "Líquido de Limpieza", 25_000
        );

        Producto paño = new Producto(
                "Paño de Microfibra", 15_000
        );

        // Subcombo con dos productos.
        Combo kitLimpieza = new Combo("Kit de Limpieza");
        kitLimpieza.agregar(liquido);
        kitLimpieza.agregar(paño);

        // Combo principal que incluye el subcombo.
        Combo comboGamer = new Combo("Combo Setup Gamer");
        comboGamer.agregar(monitor);
        comboGamer.agregar(teclado);
        comboGamer.agregar(kitLimpieza);

        // Compra con garantía y empaque de regalo.
        shopMaster.ejecutarCompraRapida(
                "cliente_vip",
                comboGamer,
                true,   // Garantía extendida
                true,   // Empaque de regalo
                false   // Manejo prioritario
        );


        // ==========================================
        // CASO 2: RECHAZO POR TOPE DE DINERO
        // ==========================================

        System.out.println("\n\n");
        System.out.println("########################################");
        System.out.println("# CASO 2: RECHAZO POR TOPE DE DINERO");
        System.out.println("########################################");

        Producto servidor = new Producto(
                "Servidor Empresarial", 6_000_000
        );

        // El total será $6.025.000 COP.
        // El Proxy debe rechazarlo antes de llamar a StripeUSA.
        shopMaster.ejecutarCompraRapida(
                "cliente_normal",
                servidor,
                false,  // Sin garantía
                false,  // Sin empaque
                true    // Manejo prioritario
        );


        // ==========================================
        // CASO 3: RECHAZO POR USUARIO REPORTADO
        // ==========================================

        System.out.println("\n\n");
        System.out.println("########################################");
        System.out.println("# CASO 3: USUARIO REPORTADO");
        System.out.println("########################################");

        Producto mouse = new Producto(
                "Mouse Inalámbrico", 150_000
        );

        // Aunque el producto es económico,
        // el Proxy debe bloquear al usuario.
        shopMaster.ejecutarCompraRapida(
                "BLOQUEADO",
                mouse,
                false,  // Sin garantía
                false,  // Sin empaque
                false   // Sin manejo prioritario
        );

        System.out.println("\n========================================");
        System.out.println("FIN DE LAS PRUEBAS DE SHOPMASTER");
        System.out.println("========================================");
    }
}
