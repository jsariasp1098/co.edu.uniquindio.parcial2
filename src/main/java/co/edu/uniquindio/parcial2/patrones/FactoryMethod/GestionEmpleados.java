package co.edu.uniquindio.parcial2.patrones.FactoryMethod;

abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract void mostrarDetalles();
}

class EmpleadoPermanente extends Empleado {
    public EmpleadoPermanente(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Permanente: " + nombre + ", Salario: $" + salario);
    }
}

class EmpleadoTemporal extends Empleado {
    public EmpleadoTemporal(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Temporal: " + nombre + ", Salario: $" + salario);
    }
}

abstract class FabricaEmpleados {
    public abstract Empleado crearEmpleado(String nombre, double salario);
}

class FabricaEmpleadosPermanentes extends FabricaEmpleados {
    @Override
    public Empleado crearEmpleado(String nombre, double salario) {
        return new EmpleadoPermanente(nombre, salario);
    }
}

class FabricaEmpleadosTemporales extends FabricaEmpleados {
    @Override
    public Empleado crearEmpleado(String nombre, double salario) {
        return new EmpleadoTemporal(nombre, salario);
    }
}

public class GestionEmpleados {
    public static void main(String[] args) {
        FabricaEmpleados fabrica1 = new FabricaEmpleadosPermanentes();
        Empleado empleado1 = fabrica1.crearEmpleado("Juan Pérez", 3000.0);
        empleado1.mostrarDetalles();

        FabricaEmpleados fabrica2 = new FabricaEmpleadosTemporales();
        Empleado empleado2 = fabrica2.crearEmpleado("María Gómez", 2500.0);
        empleado2.mostrarDetalles();
    }
}
