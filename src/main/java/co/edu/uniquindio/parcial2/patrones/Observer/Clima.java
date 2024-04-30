package co.edu.uniquindio.parcial2.patrones.Observer;

import java.util.ArrayList;
import java.util.List;

// Sujeto Observable: EstacionMeteorologica
class EstacionMeteorologica {
    private List<Observador> observadores;
    private double temperatura;
    private double humedad;
    private double presion;

    public EstacionMeteorologica() {
        observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(temperatura, humedad, presion);
        }
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
        notificarObservadores();
    }

    public void setPresion(double presion) {
        this.presion = presion;
        notificarObservadores();
    }
}

// Interfaz Observador
interface Observador {
    void actualizar(double temperatura, double humedad, double presion);
}

// Observadores Concretos
class Pantalla implements Observador {
    @Override
    public void actualizar(double temperatura, double humedad, double presion) {
        mostrarCondiciones(temperatura, humedad, presion);
    }

    private void mostrarCondiciones(double temperatura, double humedad, double presion) {
        System.out.println("Condiciones actuales en la pantalla:");
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Humedad: " + humedad + "%");
        System.out.println("Presión: " + presion + " hPa");
    }
}

class DispositivoMovil implements Observador {
    @Override
    public void actualizar(double temperatura, double humedad, double presion) {
        mostrarCondiciones(temperatura, humedad, presion);
    }

    private void mostrarCondiciones(double temperatura, double humedad, double presion) {
        System.out.println("Condiciones actuales en el dispositivo móvil:");
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Humedad: " + humedad + "%");
        System.out.println("Presión: " + presion + " hPa");
    }
}

class EstacionCentral implements Observador {
    @Override
    public void actualizar(double temperatura, double humedad, double presion) {
        mostrarCondiciones(temperatura, humedad, presion);
    }

    private void mostrarCondiciones(double temperatura, double humedad, double presion) {
        System.out.println("Condiciones actuales en la estación central:");
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Humedad: " + humedad + "%");
        System.out.println("Presión: " + presion + " hPa");
    }
}

// Uso del sistema
public class Clima {
    public static void main(String[] args) {
        EstacionMeteorologica estacion = new EstacionMeteorologica();

        Observador pantalla = new Pantalla();
        Observador dispositivoMovil = new DispositivoMovil();
        Observador estacionCentral = new EstacionCentral();

        estacion.agregarObservador(pantalla);
        estacion.agregarObservador(dispositivoMovil);
        estacion.agregarObservador(estacionCentral);

        estacion.setTemperatura(25.5);
        estacion.setHumedad(70.0);
        estacion.setPresion(1020.5);

        estacion.eliminarObservador(dispositivoMovil);

        estacion.setTemperatura(28.0);
        estacion.setHumedad(65.0);
        estacion.setPresion(1018.0);
    }
}