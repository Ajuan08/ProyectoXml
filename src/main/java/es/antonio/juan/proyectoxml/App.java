package es.antonio.juan.proyectoxml;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    ListaEquipo listaEquipo;
    int equipoActual = 0;
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        HBox hBoxBotonesArriba = new HBox(20);
        Label labelEquipos = new Label();
        HBox hBoxBotonesAbajo = new HBox(20);
        hBoxBotonesArriba.setAlignment(Pos.CENTER);
        hBoxBotonesAbajo.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        
        
        root.getChildren().add(hBoxBotonesArriba); //Añadimos al root los botones
        root.getChildren().add(labelEquipos); //Añadimos al root el label
        root.getChildren().add(hBoxBotonesAbajo); //Añadimos al root los botones
        stage.setScene(scene);
        stage.show();
        
        //CREACION DEL PRIMER EQUIPO
        Equipo equipo1 = new Equipo("Real Madrid");
        equipo1.setPresidente("Florentino Pérez");
        equipo1.setAnnoFundacion(1902);
        equipo1.setJugador("Karim Benzema");
        equipo1.setLocalidad("Madrid");
        equipo1.setValorEquipo(756000000);
        
        //SE CREA UN ARRAYLIST Y AÑADIMOS EL EQUIPO QUE HEMOS CREADO
        listaEquipo = new ListaEquipo();
        listaEquipo.getListaEquipos().add(equipo1);
         
        labelEquipos.setText(listaEquipo.getListaEquipos().get(equipoActual).toString());
        System.out.println("Número de equipos: "+listaEquipo.getListaEquipos().size());
        
        //BOTON DE EXPORTAR
        Button buttonExport = new Button("Exportar XML");
        hBoxBotonesArriba.getChildren().add(buttonExport);
        
        buttonExport.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado el botón exportar");
            UtilXML.guardarFicheroXML(stage, listaEquipo);
        });
        
        //BOTON DE IMPORTAR
        Button buttonImport = new Button("Importar XML");
        hBoxBotonesArriba.getChildren().add(buttonImport);
        
        buttonImport.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado el botón importar");
            ListaEquipo equiposImport = UtilXML.ImportDatosXML(stage);
            listaEquipo.fusionarEquipos(equiposImport);
        });
        
        //BOTON ANTERIOR
        Button buttonAntes = new Button("Equipo anterior");
        hBoxBotonesAbajo.getChildren().add(buttonAntes);
        buttonAntes.setOnAction((t) -> {
           if (equipoActual>0){
              equipoActual--;
           }
           
           System.out.println("Has pulsado el botón Equipo anterior");
           System.out.println(equipoActual);
        try {
               labelEquipos.setText(listaEquipo.getListaEquipos().get(equipoActual).toString());
           } catch (Exception ex){

           }
        });
        
        //BOTON SIGUIENTE
        Button buttonSiguiente = new Button("Siguiente equipo");
        hBoxBotonesAbajo.getChildren().add(buttonSiguiente);
        buttonSiguiente.setOnAction((t) -> { 
           if (equipoActual<listaEquipo.getListaEquipos().size()-1){
            equipoActual++;
           }
           System.out.println("Has pulsado el botón Siguiente equipo");
           System.out.println(equipoActual);
        try {
               labelEquipos.setText(listaEquipo.getListaEquipos().get(equipoActual).toString());
           } catch (Exception ex){

           }
        });
    }
    
    public static void main(String[] args) {
        launch();
    }

}