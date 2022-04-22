package es.antonio.juan.proyectoxml;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    static public void guardarFicheroXML(Stage stage, ListaEquipo listaEquipo){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar");
        fileChooser.setInitialFileName("fichero.xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichero XML ",".xml"));
        
            JAXBContext contexto;
                try {
                    File file = fileChooser.showSaveDialog(stage);
                    contexto = JAXBContext.newInstance(ListaEquipo.class);
                    Marshaller marshaller = contexto.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                    marshaller.marshal(listaEquipo, System.out);
                    marshaller.marshal(listaEquipo, file);
                } catch (JAXBException ex) {
                    System.out.println("Se ha producido un error");
                    ex.printStackTrace();
                }
        
    }
    
    public static ListaEquipo ImportDatosXML(Stage stage) {
           try {
           
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import XML en");
            File fileListaEquipos = fileChooser.showOpenDialog(stage);
           
            JAXBContext context = JAXBContext.newInstance(ListaEquipo.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            ListaEquipo listaEquipoNuevo = new ListaEquipo();
            listaEquipoNuevo = (ListaEquipo)unmarshaller.unmarshal(fileListaEquipos);
             
        return listaEquipoNuevo;
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;          
    }
}
