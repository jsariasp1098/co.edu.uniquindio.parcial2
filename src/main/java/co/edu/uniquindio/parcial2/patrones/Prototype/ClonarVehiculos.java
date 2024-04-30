package co.edu.uniquindio.parcial2.patrones.Prototype;

import java.util.HashMap;
import java.util.Map;

// Clase Prototype
abstract class Vehiculo implements Cloneable {
    protected String marca;
    protected String modelo;
    protected int año;

    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public abstract Vehiculo clonar();

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año;
    }
}

// Prototipos Concretos
class Automovil extends Vehiculo {
    private int numeroPuertas;

    public Automovil(String marca, String modelo, int año, int numeroPuertas) {
        super(marca, modelo, año);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public Vehiculo clonar() {
        return new Automovil(marca, modelo, año, numeroPuertas);
    }

    @Override
    public String toString() {
        return "Automóvil [" + super.toString() + ", Número de puertas: " + numeroPuertas + "]";
    }
}

class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String marca, String modelo, int año, double capacidadCarga) {
        super(marca, modelo, año);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public Vehiculo clonar() {
        return new Camion(marca, modelo, año, capacidadCarga);
    }

    @Override
    public String toString() {
        return "Camión [" + super.toString() + ", Capacidad de carga: " + capacidadCarga + " toneladas]";
    }
}

// Registrar prototipos
class RegistroVehiculos {
    private static Map<String, Vehiculo> prototipos = new HashMap<>();

    public static Vehiculo obtenerPrototipo(String tipo) {
        return prototipos.get(tipo).clonar();
    }

    public static void registrarPrototipo(String tipo, Vehiculo vehiculo) {
        prototipos.put(tipo, vehiculo);
    }
}

public class ClonarVehiculos {
    public static void main(String[] args) {
        Automovil prototipo1 = new Automovil("Toyota", "Corolla", 2022, 4);
        RegistroVehiculos.registrarPrototipo("Automovil", prototipo1);

        Camion prototipo2 = new Camion("Volvo", "FH16", 2021, 40.0);
        RegistroVehiculos.registrarPrototipo("Camion", prototipo2);

        Vehiculo clon1 = RegistroVehiculos.obtenerPrototipo("Automovil");
        System.out.println("Clon 1: " + clon1);

        Vehiculo clon2 = RegistroVehiculos.obtenerPrototipo("Camion");
        System.out.println("Clon 2: " + clon2);
    }
}
