package co.edu.uniquindio.parcial2.controller;

import co.edu.uniquindio.parcial2.factory.ModelFactory;

public class ConsultaController {
    ModelFactory modelFactory;
    public ConsultaController() {
        modelFactory = ModelFactory.getInstancia();
    }

    public String obtenerObjetosMasPrestadosSegunRango(String rango) {
        return modelFactory.obtenerObjetosMasPrestadosSegunRango(rango);
    }

    public String obtenerObjeto(String id) {
        return modelFactory.obtenerObjeto(id);
    }

    public String  obtenerClientesPrestamosSegunRango(String rango) {
        return modelFactory.obtenerClientesPrestamosSegunRango(rango);
    }

    public String obtenerCantidadObjetosDisponiblesNoDisponibles() {
        return modelFactory.obtenerCantidadObjetosDisponiblesNoDisponibles();
    }
}
