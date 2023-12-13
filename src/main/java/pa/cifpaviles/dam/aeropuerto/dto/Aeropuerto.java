package pa.cifpaviles.dam.aeropuerto.dto;

public class Aeropuerto {
    private String codigoIATA;
    private String nombre;
    private String codigoMunicipio;

    public Aeropuerto() {
    }

    public Aeropuerto(String codigoIAta, String nombre, String codigoMunicipio) {
        this.codigoIATA = codigoIAta;
        this.nombre = nombre;
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }
    
    private boolean isInternacional(){
        return this.getCodigoMunicipio().equals("00000"); 
    }
    
}
