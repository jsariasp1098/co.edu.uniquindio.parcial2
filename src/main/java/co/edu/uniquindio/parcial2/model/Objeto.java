package co.edu.uniquindio.parcial2.model;

public class Objeto {
    private String nombre;
    private String idObjeto;
    private boolean esDisponible;
    PrestamoObjeto ownedByPrestamoUq;

    public Objeto() {
    }
    public Objeto(String nombre, String idObjeto) {
        this.nombre = nombre;
        this.idObjeto = idObjeto;
    }
    public Objeto(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdObjeto() {
        return idObjeto;
    }
    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }
    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }
    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }
    public boolean getEsDisponible() { return esDisponible; };
    public void setEsDisponible(boolean esDisponible) { this.esDisponible = esDisponible; };
    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                '}';
    }
}
