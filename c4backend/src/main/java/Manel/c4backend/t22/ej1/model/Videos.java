package Manel.c4backend.t22.ej1.model;

public class Videos {

    private int id;
    private String title;
    private String director;
    private Integer clie_id;
    
    public Videos() {
        this.title = "";
        this.director = "";
        this.clie_id = null;
    }

    public Videos(int id, String title, String director, int clie_id) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.clie_id = clie_id;
    }

    public Videos(int id) {
        this();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getClie_id() {
        return clie_id;
    }

    public void setClie_id(Integer clie_id) {
        this.clie_id = clie_id;
    }

    @Override
    public String toString() {
        return "Videos [id=" + id + ", title=" + title + ", director=" + director + ", clie_id=" + clie_id + "]";
    }

    
}
