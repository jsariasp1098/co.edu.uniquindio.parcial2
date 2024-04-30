package co.edu.uniquindio.parcial2.patrones.Command;

// Interfaz de Comandos
interface Command {
    void execute();
}

// Receptor
class Receptor {
    public void realizarEntregaLocal() {
        System.out.println("Entrega local realizada");
    }

    public void realizarEntregaNacional() {
        System.out.println("Entrega nacional realizada");
    }

    public void realizarEntregaInternacional() {
        System.out.println("Entrega internacional realizada");
    }
}

// Clases de Comandos
class EntregaLocalCommand implements Command {
    private Receptor receptor;

    public EntregaLocalCommand(Receptor receptor) {
        this.receptor = receptor;
    }

    @Override
    public void execute() {
        receptor.realizarEntregaLocal();
    }
}

class EntregaNacionalCommand implements Command {
    private Receptor receptor;

    public EntregaNacionalCommand(Receptor receptor) {
        this.receptor = receptor;
    }

    @Override
    public void execute() {
        receptor.realizarEntregaNacional();
    }
}

class EntregaInternacionalCommand implements Command {
    private Receptor receptor;

    public EntregaInternacionalCommand(Receptor receptor) {
        this.receptor = receptor;
    }

    @Override
    public void execute() {
        receptor.realizarEntregaInternacional();
    }
}

// Invocador
class Invocador {
    public void ejecutarComando(Command comando) {
        comando.execute();
    }
}

// Cliente
public class Cliente {
    public static void main(String[] args) {
        Receptor receptor = new Receptor();

        Command entregaLocal = new EntregaLocalCommand(receptor);
        Command entregaNacional = new EntregaNacionalCommand(receptor);
        Command entregaInternacional = new EntregaInternacionalCommand(receptor);

        Invocador invocador = new Invocador();

        invocador.ejecutarComando(entregaLocal);
        invocador.ejecutarComando(entregaNacional);
        invocador.ejecutarComando(entregaInternacional);
    }
}