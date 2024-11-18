public class pasajero {

    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    public pasajero(String nombre, String pasaporte, String nacionalidad){
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPasaporte(){
        return pasaporte;
    }

    public void setPasaporte(String pasaporte){
        this.pasaporte = pasaporte;
    }
}
