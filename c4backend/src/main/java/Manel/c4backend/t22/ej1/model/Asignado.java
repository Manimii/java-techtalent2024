package Manel.c4backend.t22.ej1.model;

public class Asignado {

    private String cientifico;
    private String proyecto;
    
    public Asignado(String cientifico, String proyecto) {
        this.cientifico = cientifico;
        this.proyecto = proyecto;
    }

    public String getCientifico() {
        return cientifico;
    }

    public void setCientifico(String cientifico) {
        this.cientifico = cientifico;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Asignado [cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
    }

    
}
