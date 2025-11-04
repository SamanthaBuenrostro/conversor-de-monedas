import java.io.IOException;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        boolean menu = true;
        Scanner lectura = new Scanner(System.in);
        ConversorDeMonedas conversor = new ConversorDeMonedas();

        while (menu) {
            System.out.println("\n===============================");
            System.out.println("   CONVERSOR DE MONEDAS 💱");
            System.out.println("===============================");
            System.out.println("1. Dólares (USD) → Pesos Mexicanos (MXN)");
            System.out.println("2. Euros (EUR) → Pesos Mexicanos (MXN)");
            System.out.println("3. Pesos Mexicanos (MXN) → Dólares (USD)");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            String base = "";
            String target = "";

            try {
                int opcion = Integer.parseInt(lectura.nextLine());

                switch (opcion) {
                    case 1 -> {
                        base = "USD";
                        target = "MXN";
                    }
                    case 2 -> {
                        base = "EUR";
                        target = "MXN";
                    }
                    case 3 -> {
                        base = "MXN";
                        target = "USD";
                    }
                    case 4 -> {
                        menu = false;
                        System.out.println("👋 Gracias por usar el conversor.");
                        continue; // evita seguir ejecutando
                    }
                    default -> {
                        System.out.println("⚠️ Opción no válida, intenta de nuevo.");
                        continue;
                    }
                }

                System.out.print("Escriba la cantidad a convertir: ");
                double importe = Double.parseDouble(lectura.nextLine());

                // Llamada al metodo que realiza la conversión
                Moneda moneda = conversor.convierteMonedas(base, target, importe);

                // Mostrar el resultado
                System.out.printf("💰 %.2f %s equivalen a %.2f %s%n",
                        importe, base, moneda.conversion_result(), target);

            } catch (NumberFormatException e) {
                System.out.println("⚠️ Valor numérico no válido: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }
}
