module es.antonio.juan.proyectoxml {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.antonio.juan.proyectoxml;
    opens es.antonio.juan.proyectoxml to java.xml.bind;
}
