package co.edu.uniquindio.parcial2.factory;

import co.edu.uniquindio.parcial2.model.*;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoUq;

    private ModelFactory(){
        prestamoUq = new PrestamoObjeto();
        inicializarDatos();
    }

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {
        initClientes();
        initEmpleados();
        initObjetos();
        initPrestamos();
    }

    private void initClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setCedula("1094");
        cliente1.setNombre("Juan");
        cliente1.setApellido("Arias");
        cliente1.setEdad(17);

        Cliente cliente2 = new Cliente();
        cliente2.setCedula("1095");
        cliente2.setNombre("Ana");
        cliente2.setApellido("cardenas");
        cliente2.setEdad(25);

        Cliente cliente3 = new Cliente();
        cliente3.setCedula("1096");
        cliente3.setNombre("Pedro");
        cliente3.setApellido("perez");
        cliente3.setEdad(40);

        prestamoUq.getListaClientes().add(cliente1);
        prestamoUq.getListaClientes().add(cliente2);
        prestamoUq.getListaClientes().add(cliente3);
    }

    private void initPrestamos() {
        Prestamo prestamo1 = new Prestamo();
        prestamo1.setNumeroPrestamo("PR-1");
        prestamo1.setClienteAsociado(prestamoUq.getListaClientes().get(0));
        prestamo1.setEmpleadoAsociado(prestamoUq.getListaEmpleados().get(0));
        prestamo1.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(0));
        prestamo1.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(2));

        Prestamo prestamo2 = new Prestamo();
        prestamo2.setNumeroPrestamo("PR-2");
        prestamo2.setClienteAsociado(prestamoUq.getListaClientes().get(1));
        prestamo2.setEmpleadoAsociado(prestamoUq.getListaEmpleados().get(1));
        prestamo2.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(1));
        prestamo2.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(2));

        prestamoUq.getListaPrestamos().add(prestamo1);
        prestamoUq.getListaPrestamos().add(prestamo2);
    }


    private void initEmpleados() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setCedula("1098");
        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Pedro");
        empleado2.setCedula("1099");
        prestamoUq.getListaEmpleados().add(empleado);
        prestamoUq.getListaEmpleados().add(empleado2);
    }

    private void initObjetos() {
        Objeto objeto1 = new Objeto();
        objeto1.setNombre("Pala");
        objeto1.setIdObjeto("001");
        objeto1.setEsDisponible(false);
        Objeto objeto2 = new Objeto();
        objeto2.setNombre("Machete");
        objeto2.setIdObjeto("002");
        objeto2.setEsDisponible(true);
        Objeto objeto3 = new Objeto();
        objeto3.setNombre("Taladro");
        objeto3.setIdObjeto("003");
        objeto3.setEsDisponible(true);
        prestamoUq.getListaObjetos().add(objeto1);
        prestamoUq.getListaObjetos().add(objeto2);
        prestamoUq.getListaObjetos().add(objeto3);
    }

    public String obtenerObjetosMasPrestadosSegunRango(String rango) {
        return prestamoUq.obtenerObjetosMasPrestadosSegunRango(rango);
    }

    public String obtenerObjeto(String id) {
        return prestamoUq.obtenerObjeto(id);
    }

    public String obtenerClientesPrestamosSegunRango(String rango) {
        return prestamoUq.obtenerClientesPrestamosSegunRango(rango);
    }

    public String obtenerCantidadObjetosDisponiblesNoDisponibles() {
        return prestamoUq.obtenerCantidadObjetosDisponiblesNoDisponibles();
    }
}
