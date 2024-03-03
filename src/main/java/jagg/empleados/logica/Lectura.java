package jagg.empleados.logica;

import java.util.Scanner;

public class Lectura {

    public static int leerInt() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                int n = sc.nextInt();
                return n;
            } catch (Exception e) {
                System.out.println("Debe escribir un número entero");
                sc.nextLine();
            }
        }
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

    public static String leerLinea() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

}
