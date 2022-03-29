package es.javimg.listapeliculas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Pelicula pelicula1 = new Pelicula("Ficheros en Java");
        System.out.println(pelicula1.getTitulo());
        pelicula1.setTitulo("Listas en Java");
        System.out.println(pelicula1.getTitulo());
        
        Pelicula pelicula2 = new Pelicula();
        Pelicula pelicula3 = new Pelicula("XML en java");
        pelicula3.setTitulo("XML en Java 2");
  
//        int[] listaNum = new int[10];
//        Libro[] listaLibros = new Libro[10];
    
        ListaPeliculas listapeliculas = new ListaPeliculas();
        listapeliculas.getListaPelicula().add(pelicula1);
        listapeliculas.getListaPelicula().add(pelicula2);
        listapeliculas.getListaPelicula().add(pelicula3);
        
        
        HBox hbox = new HBox(32); // spacing = 8
        
        
        Button buttonSelectFile = new Button("Guardar XML");
        buttonSelectFile.setOnAction((t) -> {
            UtilXML.guardarDatosXML(stage, listapeliculas);
        });
        
        Button buttonImportFile = new Button("Importar xml");
        buttonImportFile.setOnAction((t) -> {
            UtilXML.convertirDatosXML(stage, listapeliculas);
        });
        
        hbox.getChildren().addAll(buttonImportFile,buttonSelectFile);
        root.getChildren().add(hbox);
        //mostrar titulo de segundo libro
//       
//        System.out.println(listaLibros.get(2).getTitulo());
//        
//        //eliminar el segundo libro
//        listaLibros.remove(1);
//        
//        // Mostrar todos los libros de la lista
//        for(int i=0; i<listaLibros.size();i++) {
//            System.out.println(listaLibros.get(i).getTitulo());
//        }
//        
//        for(int i=0; i<listaLibros.size();i++) {
//            System.out.println(listaLibros.get(i));
//        }
//      

        
    

    }

    public static void main(String[] args) {
        launch();
    }

}