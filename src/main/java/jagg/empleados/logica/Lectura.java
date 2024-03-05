package jagg.empleados.logica;

import java.util.Scanner;

public class Lectura {

//    public static int leerInt() {
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            try {
//                int n = sc.nextInt();
//                return n;
//            } catch (Exception e) {
//                System.out.println("Debe escribir un número entero");
//                sc.nextLine();
//            }
//        }
//    }
public static int leerInt() {
    Scanner sc = new Scanner(System.in);
    String linea;
    int n ;

    do {
       //System.out.print("Introduzca el número: ");
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

        while (true) {
            try {
                double n = sc.nextDouble();
                return n;
            } catch (Exception e) {
                System.out.println("Debe escribir un número double");
                sc.nextLine();
            }
        }
    }

//    public static String leerLinea() {
//        Scanner sc = new Scanner(System.in);
//
//        return sc.nextLine();
//    }
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
