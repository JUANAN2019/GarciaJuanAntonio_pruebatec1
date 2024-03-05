package jagg.empleados.logica;

import jagg.empleados.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearEmpleado(Empleado empleado) {
        controlPersis.crearEmpleado(empleado);
    }

    
    public List<Empleado> traerEmpleados(){
        return controlPersis.traerEmpleados();
    }

    Empleado traerEmpleado(int id) {
        return controlPersis.traerEmpleado(id);
    }

    void editarEmpleado(Empleado empleado) {
       controlPersis.editarEmpleado(empleado);
    }
    List<Empleado> traerPorCargo(String cargo) {
        return controlPersis.traerPorCargo(cargo);
    }

}


