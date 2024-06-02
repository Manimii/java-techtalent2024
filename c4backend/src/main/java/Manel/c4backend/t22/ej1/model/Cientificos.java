package Manel.c4backend.t22.ej1.model;

public class Cientificos {

    private String dni;
    private String nomApels;
    
    public Cientificos(String dni, String nomApels) {
        this.dni = dni;
        this.nomApels = nomApels;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomApels() {
        return nomApels;
    }

    public void setNomApels(String nomApels) {
        this.nomApels = nomApels;
    }

    @Override
    public String toString() {
        return "Cientificos [dni=" + dni + ", nomApels=" + nomApels + "]";
    }

    
}
