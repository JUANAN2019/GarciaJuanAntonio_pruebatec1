package jagg.empleados.logica;

import java.util.List;

public class MetodosEmpleado {

    Controladora control = new Controladora();

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
        String fecha = introducirFecha("Fecha de inicio");
        int salario = introducirSalario("Salario");

        Empleado empleado1 = new Empleado(nombre, apellido, cargo, salario, fecha);
        control.crearEmpleado(empleado1);
    }

    public String introducirString(String nombreVariable) {
        System.out.println("Introduzca " + nombreVariable + ": ");
        return Lectura.leerLinea();
    }

    public String introducirFecha(String nombreVariable) {
        System.out.println("Introduzca " + nombreVariable + " (formato dd/mm/aaaa): ");

        return Lectura.leerLinea();
    }

    public int introducirSalario(String nombreVariable) {
        System.out.println("Introduzca " + nombreVariable + ": debe ser un numero entero");
        return Lectura.leerInt();
    }

    public void listarEmpleados() {
        List<Empleado> empleados = control.traerEmpleados();
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }
    }

    public void actualizarEmpleado() {
        //tengo que pulir la logica y los mensajes que da la consola para ir ofreciendo meter en consola que se quiere cambiar
        //traer primero al empleado que vamos a editar
        System.out.println("Introduzca el Id del empleado que quiere editar");
        int id = Lectura.leerInt();
        Empleado empleado = control.traerEmpleado(id);
        System.out.println(empleado);

        //cambiar el dato que queremos en la variable empleado que es donde metemos el objeto traido de la bd
        //tengo que hacer la logica para que se elija el dato que queremos cambiar
        System.out.println("Introduzca el dato que quiere cambiar");
        String campo = Lectura.leerLinea();

        System.out.println("Introduzca el valor que quiere asignar al campo " + campo);

        switch (campo) {
            case "apellido":
                String apellido = Lectura.leerLinea();
                empleado.setApellido(apellido);
                break;
            case "nombre":
                String nombre = Lectura.leerLinea();
                empleado.setNombre(nombre);
                break;
            case "cargo":
                String cargo = Lectura.leerLinea();
                empleado.setCargo(cargo);
                break;
            case "salario":
                int salario = Lectura.leerInt();
                empleado.setSalario(salario);
                break;
            case "fechainicio":
                String fechaInicio = Lectura.leerLinea();
                empleado.setFechaInicio(fechaInicio);
                break;
            default:
                throw new AssertionError();
        }


        //ahora editamos el empleado con el objeto en la variable empleado 
        control.editarEmpleado(empleado);
    }

    public void eliminarEmpleado() {
        System.out.println("Introduzca el id del empleado que desea eliminar");
        int id = Lectura.leerInt();
        control.eliminarEmpleado(id);
    }

    public void empleadoPorCargo() {
        System.out.println("Introduzca el cargo que desempeñan los empleados de los que quiere la lista:");
        String cargo = Lectura.leerLinea();
        System.out.println("Los empleados con el cargo " + cargo + " son: ");
        List<Empleado> empleados = control.traerPorCargo(cargo);

        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }
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
