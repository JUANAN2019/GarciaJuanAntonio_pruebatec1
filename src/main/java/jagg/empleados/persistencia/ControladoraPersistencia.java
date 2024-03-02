package jagg.empleados.persistencia;


import jagg.empleados.logica.Empleado;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoPersis = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado empleado) {
      
      empleadoPersis.create(empleado);
      
    }
    
   
   
}
