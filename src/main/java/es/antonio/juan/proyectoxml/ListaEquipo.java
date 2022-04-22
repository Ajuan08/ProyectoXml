package es.antonio.juan.proyectoxml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaEquipo {
    private ArrayList<Equipo> listaEquipos = new ArrayList();
    
    public ArrayList<Equipo> getListaEquipos(){
        return listaEquipos;
    }
    
    @XmlElement(name = "equipos")
    public void setListaEquipos(ArrayList<Equipo> listaEquipos){
        this.listaEquipos = listaEquipos;
    }
    
    
    public void fusionarEquipos(ListaEquipo listaEquipoNuevo){
        this.getListaEquipos().addAll(listaEquipoNuevo.getListaEquipos());
    }
    
}
