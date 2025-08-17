import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        double cantidad = 0;
        double cantidadConvertida = 0;
        boolean salir = true;

        do {
            System.out.println("""
                    ==================================
                    Aplicacion para convertir monedas
                    ==================================
                                    
                    1) Soles a Dolares
                    2) Soles a Euros
                    3) Soles a Pesos Argentinos
                    4) Dolares a Euros
                    5) Dolares a Pesos Argentinos
                    6) Euros a Pesos Argentinos
                    7)Pesos Argentinos a Soles
                    8) Salir
                    Elija una opcion válida:""");
            do {
                try {
                    opcion = Integer.parseInt(teclado.nextLine());
                    if (opcion >= 1 && opcion <= 8) {
                        salir = false;
                    }
                    else {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Elija una opcion valida: ");
                }
            } while (salir);
            salir = true;

            if (opcion != 8) {
                String[] codigoMoneda = NombreDeMoneda.devolverNombreDeMoneda(opcion);
                System.out.println("Ingrese la cantidad que desea convertir: ");

                do {
                    try {
                        cantidad = Double.parseDouble(teclado.nextLine());
                        salir = false;
                    } catch (NumberFormatException e) {
                        System.out.println("¡Cantidad no válida!");
                        System.out.println("Ingrese la cantidad que desea convertir: ");
                    }
                } while (salir);
                salir = true;

                cantidadConvertida = cantidad * TasaDeCambio.ObtenerTasaDeCambio(codigoMoneda[0], codigoMoneda[1]);
                System.out.println("La cantidad " + cantidad + " " + codigoMoneda[0]
                        + " convertida en " + codigoMoneda[1]
                        + " es: " + cantidadConvertida);
                System.out.println();
                System.out.println("******************************************************************************");
                System.out.println();

            }

        } while (opcion != 8);
        System.out.println("\n/**** Fin del programa ****/\n");
    }

}
