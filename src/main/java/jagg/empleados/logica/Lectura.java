package jagg.empleados.logica;

import java.util.Scanner;

//Clase Lectura, para leer los datos introducidos en la aplicacion y la verificacion que el tipo de dato se correcto  y que no estan vacios
public class Lectura {

public static int leerInt() {
    Scanner sc = new Scanner(System.in);
    String linea;
    int n ;

    do {
        linea = sc.nextLine();

        if (linea.isEmpty()) {
            System.out.println("El campo no puede estar vacío.");
        } else {
            try {
                n = Integer.parseInt(linea);
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Debe escribir un número entero");
            }
        }
    } while (linea.isEmpty() || !Character.isDigit(linea.charAt(0)));

    return n = 0;
}

    public static double leerDouble() {
        Scanner sc = new Scanner(System.in);
        String linea;
        double n ;

        do {
            linea = sc.nextLine();

            if (linea.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            } else {
                try {
                    n = (int) Double.parseDouble(linea);
                    return n;
                } catch (NumberFormatException e) {
                    System.out.println("Debe escribir un número double");
                }
            }
        } while (linea.isEmpty() || !Character.isDigit(linea.charAt(0)));

        return n = 0;
    }

    public static String leerLinea() {
        Scanner sc = new Scanner(System.in);
        String linea;
        do {
            linea = sc.nextLine();
            if (linea.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            }
        } while (linea.isEmpty());

        return linea;
    }
}
