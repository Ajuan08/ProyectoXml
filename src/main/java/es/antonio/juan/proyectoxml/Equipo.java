package es.antonio.juan.proyectoxml;

public class Equipo {
    
    private String nombreEquipo;
    private String presidente;
    private String jugador;
    private int annoFundacion;
    private String localidad;
    private int valorEquipo;
    
    public Equipo(){
        
    }
    
    public Equipo(String nombreEquipo){
        this.nombreEquipo = nombreEquipo.toUpperCase();
    }
    
    public Equipo(String nombreEquipo, String presidente){
        this.nombreEquipo = nombreEquipo.toUpperCase();
        this.presidente = presidente;
    }
    
    public String getNombreEquipo(){
        return nombreEquipo;
    }
    
    public void setNombreEquipo(String nombreEquipo){
        this.nombreEquipo = nombreEquipo.toUpperCase();
    }
    
    public void setPresidente(String presidente){
        this.presidente = presidente;
    }
    
    public String getPresidente(){
        return presidente;
    }
    
    public String getJugador(){
        return jugador;
    }
    
    public void setJugador(String jugador){
        this.jugador = jugador;
    }
    
    public String getLocalidad(){
        return localidad;
    }
    
    public void setLocalidad(String localidad){
        this.localidad = localidad;
    }
    
    public int getValorEquipo(){
        return valorEquipo;
    }
    
    public void setValorEquipo(int valorEquipo){
        this.valorEquipo = valorEquipo;
    }
    
    public int getAnnoFundacion(){
        return annoFundacion;
    }
    
    public void setAnnoFundacion(int annoFundacion){
        this.annoFundacion = annoFundacion;
    }

    @Override
    public String toString(){
        String r = "";
        r += "Nombre del equipo: " + nombreEquipo + "\n";
        r += "Presidente: " + presidente + "\n";
        r += "Jugador principal: " + jugador + "\n";
        r += "Año de fundación: " + annoFundacion + "\n";
        r += "Localidad: " + localidad + "\n";
        r += "Valor del equipo: " + valorEquipo;
        return r;
    }
}

