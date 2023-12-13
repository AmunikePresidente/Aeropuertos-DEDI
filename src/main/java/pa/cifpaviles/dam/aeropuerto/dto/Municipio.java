package pa.cifpaviles.dam.aeropuerto.dto;

    public record Municipio(String codigo, String nombre) {
        
        @Override
            public String toString(){
                return nombre + " " + codigo;
            } 
        
    }
    

