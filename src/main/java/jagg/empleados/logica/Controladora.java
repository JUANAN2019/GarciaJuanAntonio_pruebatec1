package jagg.empleados.logica;

import jagg.empleados.persistencia.ControladoraPersistencia;


public class Controladora {

   ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    public void crearEmpleado(Empleado empleado) {
        controlPersis.crearEmpleado(empleado);
    }
    

    
}
