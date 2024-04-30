package co.edu.uniquindio.parcial2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrestamoObjeto {

    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Objeto> listaObjetos = new ArrayList<>();
    List<Prestamo> listaPrestamos = new ArrayList<>();

    public PrestamoObjeto() {}

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public String obtenerObjetosMasPrestadosSegunRango(String rango) {
        String reporte = "";
        int rangoEntero = Integer.parseInt(rango);
        List<Objeto> objetoList = getListaObjetos();
        for (Objeto objeto: objetoList){
            int contador = 0;
            for (Prestamo prestamo: getListaPrestamos()) {
                for (Objeto objetoPrestado: prestamo.getListaObjetosAsociados()) {
                    if(objeto.getIdObjeto().equals(objetoPrestado.getIdObjeto())){
                        contador++;
                    }
                }
            }
            if(contador >= rangoEntero){
                reporte = reporte+objeto.toString()+"\n";
            }
        }
        return reporte;
    }

    public String obtenerObjeto(String id) {
        String reporte = "";
        List<Objeto> objetoList = getListaObjetos();
        for (Objeto objeto : objetoList) {
            if (objeto.getIdObjeto().equals(id)) {
                reporte = objeto.toString();
            }
        }
        return reporte;
    }

    public String obtenerClientesPrestamosSegunRango(String rango) {
        StringBuilder reporte = new StringBuilder();
        int rangoEntero = Integer.parseInt(rango);
        List<Prestamo> prestamoList = getListaPrestamos();
        Map<Cliente, Integer> clientesConPrestamos = new HashMap<>();

        for (Prestamo prestamo : prestamoList) {
            Cliente clienteAsociado = prestamo.getClienteAsociado();
            clientesConPrestamos.put(clienteAsociado, clientesConPrestamos.getOrDefault(clienteAsociado, 0) + 1);
        }

        for (Map.Entry<Cliente, Integer> entry : clientesConPrestamos.entrySet()) {
            if (entry.getValue() >= rangoEntero) {
                Cliente cliente = entry.getKey();
                int cantidadPrestamos = entry.getValue();
                reporte.append("Cliente: ").append(cliente.getNombre()).append(", Cantidad de préstamos: ").append(cantidadPrestamos).append("\n");
            }
        }

        return reporte.toString();
    }

    public String obtenerCantidadObjetosDisponiblesNoDisponibles() {
        StringBuilder reporte = new StringBuilder();
        int disponibles = 0;
        int noDisponibles = 0;

        List<Objeto> listaObjetosAsociados = getListaObjetos();
        
        for (Objeto objeto : listaObjetosAsociados) {
            if (objeto.getEsDisponible()) {
                disponibles++;
            } else {
                noDisponibles++;
            }
        }

        reporte.append("Objetos disponibles: ").append(disponibles).append("\n");
        reporte.append("Objetos no disponibles: ").append(noDisponibles);

        return reporte.toString();
    }
}