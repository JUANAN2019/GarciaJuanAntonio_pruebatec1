package jagg.empleados;

import jagg.empleados.logica.Controladora;
import jagg.empleados.logica.Empleado;
import jagg.empleados.logica.MetodosEmpleado;



public class Empleados {

    public static void main(String[] args) {

       
        /*Empleado empleado1 = new Empleado("Juan", "Garcia", "Developer", 18000, "2024/02/19");
        Controladora control = new Controladora();
        control.crearEmpleado(empleado1);*/
        MetodosEmpleado metodos = new MetodosEmpleado();
        metodos.menuInicial();
      
    }

}
