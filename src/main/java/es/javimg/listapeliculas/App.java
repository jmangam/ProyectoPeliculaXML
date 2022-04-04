package es.javimg.listapeliculas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Pelicula pelicula1 = new Pelicula("Ficheros en Java");
        //System.out.println(pelicula1.getTitulo());
        pelicula1.setTitulo("Listas en Java");
        //System.out.println(pelicula1.getTitulo());
        
        Pelicula pelicula2 = new Pelicula();
        Pelicula pelicula3 = new Pelicula("XML en java");
        pelicula3.setTitulo("XML en Java 2");
  
//        int[] listaNum = new int[10];
//        Libro[] listaLibros = new Libro[10];
    
        Peliculas peliculas = new Peliculas();
        peliculas.getListaPelicula().add(pelicula1);
        peliculas.getListaPelicula().add(pelicula2);
        peliculas.getListaPelicula().add(pelicula3);
        
        
        
        
        Button buttonSelectFile = new Button("Guardar XML");
        buttonSelectFile.setOnAction((t) -> {
            UtilXML.guardarDatosXML(stage, peliculas);
        });
        
        
        
        Button buttonImportFile = new Button("Importar xml");
        buttonImportFile.setOnAction((t) -> {
            Peliculas peliculasImport = UtilXML.convertirDatosXML(stage);
            peliculas.añadirPeliculas(peliculasImport);
            System.out.println(peliculas.getListaPelicula().size());
            
            
        });
        
        root.getChildren().addAll(buttonImportFile,buttonSelectFile);
        
        peliculas.añadirPeliculas(peliculas);
        
        Label label = new Label("a label");
        root.getChildren().addAll(label);
        
        Button buttonAvanzar = new Button("Avanzar");
//        buttonImportFile.setOnAction((t) -> {
//            
//        }

        Button buttonRetroceder = new Button("Retroceder");
//        buttonImportFile.setOnAction((t) -> {
//            
//        }

        root.getChildren().addAll(buttonAvanzar,buttonRetroceder);
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