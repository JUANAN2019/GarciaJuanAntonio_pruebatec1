package jagg.empleados.logica;

public class MetodosEmpleado {

    public boolean menuInicial() {
        boolean salir = false;
        int op = 0;
        while (op < 1 || op > 6) {
            System.out.println("MENU AGENTE");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Actualizar informacion de empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Buscar empleados por cargo");
            System.out.println("6. Salir");
            op = Lectura.leerInt();
        }
        switch (op) {
            case 1:
                agregarEmpleado();
                break;
            case 2:
                listarEmpleados();
                break;
            case 3:
                actualizarEmpleado();
                break;
            case 4:
                eliminarEmpleado();
                break;
            case 5:
                empleadoPorCargo();
                break;
            case 8:
                salir = true;
        }

        return salir;
    }

    public void agregarEmpleado() {

        String nombre = introducirString("Nombre");
        String apellido = introducirString("Apellido");
        String cargo = introducirString("Cargo");
        String fecha = introducirFecha("Fecha de nacimiento");
        double salario = introducirDouble("Salario");

        // ... Validaciones adicionales ...
        // Guardar el empleado en la base de datos o realizar otra acción
    }

    public String introducirString(String nombreVariable) {
        String valor;
        do {
            System.out.println("Introduzca " + nombreVariable + ": ");
            valor = Lectura.leerLinea();
            if (valor.isEmpty()) {
                System.out.println("El campo " + nombreVariable + " no puede estar vacío.");
            }
        } while (valor.isEmpty());
        return valor;
    }

    public String introducirFecha(String nombreVariable) {
        String valor;
        do {
            System.out.println("Introduzca " + nombreVariable + " (formato dd/mm/aaaa): ");
            valor = Lectura.leerLinea();
            if (!validarFecha(valor)) {
                System.out.println("El campo " + nombreVariable + " no tiene un formato válido.");
            }
        } while (!validarFecha(valor));
        return valor;
    }

    public double introducirDouble(String nombreVariable) {
        double valor;
        do {
            System.out.println("Introduzca " + nombreVariable + ": ");
            try {
                valor = Double.parseDouble(Lectura.leerLinea());
                if (valor <= 0) {
                    System.out.println("El campo " + nombreVariable + " debe ser un valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El campo " + nombreVariable + " debe ser un número decimal.");
                valor = Double.NaN;
            }
        } while (valor <= 0);
        return valor;
    }

    private boolean validarFecha(String fecha) {
        // ... Implementación de la validación de la fecha ...
    }

    public void listarEmpleados() {

    }

    public void actualizarEmpleado() {

    }

    public void eliminarEmpleado() {

    }

    public void empleadoPorCargo() {

    }

    /*public static boolean esVariableValida(String variable) {
        // Validar que solo contenga letras o guiones bajos
        for (char caracter : variable.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != '_') {
                return false;
            }
        }

        // Validar que la primera letra sea mayúscula
        if (!Character.isUpperCase(variable.charAt(0))) {
            return false;
        }
         if (Character.isDigit(variable.charAt(0))) {
        System.out.println("El nombre no puede ser un número.");
        return false;
    }

        return true;
    }

    public static boolean esValidoString(String valor, String tipoDato) {
        // Validar que no esté vacío
        if (valor.isEmpty()) {
            System.out.println("El campo " + tipoDato + " no puede estar vacío.");
            return false;
        }

        // Validar el tipo de dato
        switch (tipoDato) {
            case "nombre":
                if (!esVariableValida(valor)   ) {
                    System.out.println("El nombre solo puede contener letras o guiones bajos y empezar por letra mayúscula.");
                    return false;
                }
                break;
            case "apellido":
                if (!esVariableValida(valor)) {
                    System.out.println("El apellido solo puede contener letras o guiones bajos y empezar por letra mayúscula.");
                    return false;
                }
                break;
            case "cargo":
                // Validar que el cargo sea válido
                break;
            case "fechaInicio":
                // Validar que la fecha de inicio sea válida
                break;
            default:
                // No se ha definido la validación para el tipo de dato
                System.out.println("No se ha definido la validación para el tipo de dato " + tipoDato);
                return false;
        }

        return true;
    }


    public static void verificarCampo( String tipoDato, String nombreVariable) {
        boolean valido = false;
        String valorIntroducido;

        while (!valido) {
            System.out.printf("Introduzca el valor para %s (%s): ", nombreVariable, tipoDato);
            valorIntroducido = Lectura.leerLinea();

            if (valorIntroducido.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            } else {
                switch (tipoDato) {
                    case "int":
                    try {
                        Integer.parseInt(valorIntroducido);
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("El valor introducido no es un número entero válido.");
                    }
                    break;
                    case "double":
                    try {
                        Double.parseDouble(valorIntroducido);
                        valido = true;
                    } catch (NumberFormatException e) {
                        System.out.println("El valor introducido no es un número decimal válido.");
                    }
                    break;
                    case "String":
                        valido = true;
                        break;
                    default:
                        System.out.println("Tipo de dato no válido: " + tipoDato);
                }
            }
        }

        // Aquí se puede usar el valor introducido
        System.out.println("El valor introducido para " + nombreVariable + " es: " + valorIntroducido);
    }*/
}
