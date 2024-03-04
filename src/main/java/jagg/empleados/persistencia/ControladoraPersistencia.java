package jagg.empleados.persistencia;

import jagg.empleados.logica.Empleado;
import jagg.empleados.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado) {

        empleadoJpa.create(empleado);

    }

    public void eliminarEmpleado(int id) {
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Empleado>traerEmpleados(){
        return empleadoJpa.findEmpleadoEntities();
    }

    public Empleado traerEmpleado(int id) {
       return empleadoJpa.findEmpleado(id);
    }

    public void editarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
