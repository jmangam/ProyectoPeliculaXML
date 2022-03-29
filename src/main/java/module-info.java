module es.javimg.listapeliculas {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.javimg.listapeliculas;
    opens es.javimg.listapeliculas to java.xml.bind;
}
