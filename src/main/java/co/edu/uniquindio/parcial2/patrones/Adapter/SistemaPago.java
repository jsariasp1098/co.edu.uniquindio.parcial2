package co.edu.uniquindio.parcial2.patrones.Adapter;

// Sistema de pago heredado
class SistemaPagoAntiguo {
    public void procesarPago(double cantidad) {
        System.out.println("Procesando pago de $" + cantidad + " en el sistema antiguo.");
    }
}

interface PasarelaPago {
    public void realizarPago(double cantidad);
}

// Implementación de la nueva pasarela de pagos
class NuevaPasarelaPago implements PasarelaPago {
    @Override
    public void realizarPago(double cantidad) {
        System.out.println("Realizando pago de $" + cantidad + " a través de la nueva pasarela de pagos.");
    }
}

// Adaptador que conecta el sistema antiguo con la nueva pasarela de pagos
class AdaptadorPago implements PasarelaPago {
    private SistemaPagoAntiguo sistemaPagoAntiguo;

    public AdaptadorPago(SistemaPagoAntiguo sistemaPagoAntiguo) {
        this.sistemaPagoAntiguo = sistemaPagoAntiguo;
    }

    @Override
    public void realizarPago(double cantidad) {
        sistemaPagoAntiguo.procesarPago(cantidad);
    }
}

// Uso del adaptador
public class SistemaPago {
    public static void main(String[] args) {
        SistemaPagoAntiguo sistemaPagoAntiguo = new SistemaPagoAntiguo();
        PasarelaPago nuevaPasarelaPago = new NuevaPasarelaPago();

        PasarelaPago adaptadorPago = new AdaptadorPago(sistemaPagoAntiguo);

        // Usar el sistema antiguo a través del adaptador
        adaptadorPago.realizarPago(100.0);

        // Usar la nueva pasarela de pagos directamente
        nuevaPasarelaPago.realizarPago(200.0);
    }
}
