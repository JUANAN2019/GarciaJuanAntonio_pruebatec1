package jagg.empleados.logica;

import java.util.List;

//Clase que crea los metodos para comunicarse con la Clase Controladora y crea los menus y submenus de la aplicacion
public class MetodosEmpleado {

    Controladora control = new Controladora();

    public void menuInicial() {
        int op = 0;
        while (op < 1 || op > 6) {
            System.out.println("MENU PRINCIPAL");
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
            case 6:
                salirPrograma();
        }
    }

    public void agregarEmpleado() {

        String nombre = introducirString("Nombre");
        String apellido = introducirString("Apellido");
        String cargo = introducirString("Cargo");
        String fecha = introducirFecha("Fecha de inicio");
        int salario = introducirSalario("Salario");
        boolean activo = true;

        Empleado empleado1 = new Empleado(nombre, apellido, cargo, salario, fecha);
        control.crearEmpleado(empleado1);
        System.out.println("Empleado agregado.");
        boolean campoValido = false;
        while (!campoValido) {
            System.out.println("¿Qué desea hacer a continuación?");
            System.out.println("1. Agregar otro empleado");
            System.out.println("2. Volver al menú principal");
            System.out.println("3. Salir del programa");

            int opcion = Lectura.leerInt();

            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    campoValido = true;
                    break;
                case 2:
                    menuInicial();
                    campoValido = true;
                    break;
                case 3:
                    salirPrograma();
                    campoValido = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduzca una opción del 1 al 3.");
            }
        }
    }

    public String introducirString(String nombreVariable) {
        System.out.println("Introduzca " + nombreVariable + ": ");
        return Lectura.leerLinea();
    }

    public String introducirFecha(String nombreVariable) {
        //verifica el String introuducido con una expresion regular para que cumpla con el formato
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
        String fecha = "";
        boolean fechaOk = false;
        while(!fechaOk) {
            System.out.println("Introduzca " + nombreVariable + " (formato dd/mm/aaaa): ");
            fecha = Lectura.leerLinea();
            if (fecha.matches(regex)) {
                System.out.println("La fecha tiene el formato correcto: dd/mm/aaaa");
                fechaOk = true;
            } else {
                System.out.println("La fecha no tiene el formato correcto: dd/mm/aaaa.");
            }
        }

        return fecha;
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
       menuDosOp();
    }

    public void actualizarEmpleado() {
        while (true) {
            System.out.println("Introduzca el Id del empleado que quiere editar");
            int id = Lectura.leerInt();
            Empleado empleado = control.traerEmpleado(id);
            System.out.println(empleado);

            boolean campoValido = false;
            do {
                System.out.println("Introduzca el dato que quiere cambiar");
                String campo = Lectura.leerLinea();

                System.out.println("Introduzca el valor que quiere asignar al campo " + campo);


                boolean campoModificado = false;
                switch (campo) {
                    case "apellido":
                        String apellido = Lectura.leerLinea();
                        empleado.setApellido(apellido);
                        campoModificado = true;
                        break;
                    case "nombre":
                        String nombre = Lectura.leerLinea();
                        empleado.setNombre(nombre);
                        campoModificado = true;
                        break;
                    case "cargo":
                        String cargo = Lectura.leerLinea();
                        empleado.setCargo(cargo);
                        campoModificado = true;
                        break;
                    case "salario":
                        int salario = Lectura.leerInt();
                        empleado.setSalario(salario);
                        campoModificado = true;
                        break;
                    case "fechainicio":
                        String fechaInicio = Lectura.leerLinea();
                        empleado.setFechaInicio(fechaInicio);
                        campoModificado = true;
                        break;
                    default:
                        System.out.println("El campo introducido no es válido. Opciones válidas: apellido, nombre, cargo, salario, fechainicio");
                }

                if (campoModificado) {
                    control.editarEmpleado(empleado);

                    System.out.println("¿Qué desea hacer a continuación?");
                    System.out.println("1. Actualizar otro empleado");
                    System.out.println("2. Volver al menú principal");
                    System.out.println("3. Salir del programa");

                    int opcion = Lectura.leerInt();

                    switch (opcion) {
                        case 1:
                            actualizarEmpleado();
                            break;
                        case 2:
                            menuInicial();
                            campoValido = true;
                            break;
                        case 3:
                            salirPrograma();
                            campoValido = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, introduzca una opción del 1 al 3.");
                    }
                }
            }while(!campoValido);
        }
    }

    public void eliminarEmpleado() {
        System.out.println("Introduzca el Id del empleado que quiere eliminar");
        int id = Lectura.leerInt();
        Empleado empleado = control.traerEmpleado(id);
        System.out.println(empleado);

        if(!empleado.isActivo()){
            System.out.println("Ese empleado ya esta eliminado");
        }else{
            empleado.setActivo(false);
            control.editarEmpleado(empleado);
            System.out.println("Ha eliminado el empleado con Id " +id );
        }

        boolean campoValido = false;
        while (!campoValido) {
            System.out.println("¿Qué desea hacer a continuación?");
            System.out.println("1. Eliminar otro empleado");
            System.out.println("2. Volver al menú principal");
            System.out.println("3. Salir del programa");

            int opcion = Lectura.leerInt();

            switch (opcion) {
                case 1:
                    eliminarEmpleado();
                    campoValido = true;
                    break;
                case 2:
                    menuInicial();
                    campoValido = true;
                    break;
                case 3:
                    salirPrograma();
                    campoValido = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduzca una opción del 1 al 3.");
            }
        }
    }

    public void empleadoPorCargo() {
        System.out.println("Introduzca el cargo que desempeñan los empleados de los que quiere la lista:");
        String cargo = Lectura.leerLinea();
        System.out.println("Los empleados con el cargo " + cargo + " son: ");
        List<Empleado> empleados = control.traerPorCargo(cargo);

        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
        }

        menuDosOp();
    }
    public void salirPrograma(){
        System.out.println("Ha salido del programa.");
    }
   //Menu con dos opciones que uso cuando listo empleados
    public void menuDosOp(){
       boolean campoValido = false;
       while (!campoValido) {
           System.out.println("¿Qué desea hacer a continuación?");
           System.out.println("1. Volver al menú principal");
           System.out.println("2. Salir del programa");

           int opcion = Lectura.leerInt();

           switch (opcion) {
               case 1:
                   menuInicial();
                   campoValido = true;
                   break;
               case 2:
                   salirPrograma();
                   campoValido = true;
                   break;
               default:
                   System.out.println("Opción no válida. Por favor, introduzca una opción del 1 al 2.");
           }
       }
   }

}
