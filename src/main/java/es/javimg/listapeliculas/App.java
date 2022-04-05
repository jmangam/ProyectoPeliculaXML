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

    int cuenta = 0;
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Michael Jackson, su historia");
        pelicula1.setDirector("Jeremias Manzano Perez");
        pelicula1.setProductora("Netflix");
        pelicula1.setPrecioEntrada(8.5);
        
        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("El dia de Cristiano Ronaldo");
        pelicula2.setDirector("Florentino Duran Manchego");
        pelicula2.setProductora("HBO");
        pelicula2.setPrecioEntrada(10.90);
        
        Pelicula pelicula3 = new Pelicula();
        pelicula3.setTitulo("Como se creo Apple");
        pelicula3.setDirector("Sergio Ortelano Salguero");
        pelicula3.setProductora("Amazon Prime Video");
        pelicula3.setPrecioEntrada(7.90);
        
        
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
            System.out.println(peliculas.getListaPelicula().get(4));
        });
        
        root.getChildren().addAll(buttonImportFile,buttonSelectFile);  
        
        VBox vbox = new VBox();
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        
        vbox.setStyle("-fx-background-color:#D5D8DC");
        vbox.getChildren().addAll(label, label1, label2, label3);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMaxSize(250,450);
        
        root.getChildren().add(vbox);
           label.setText("Nombre:" + peliculas.getListaPelicula().get(0).getTitulo());
           label1.setText("Director: " + peliculas.getListaPelicula().get(0).getDirector());
           label2.setText("Productora: " + peliculas.getListaPelicula().get(0).getProductora());
           label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(0).getPrecioEntrada()); 
//        
        
        Button buttonAvanzar = new Button("Avanzar");
        buttonAvanzar.setOnAction((t) -> {
            cuenta++;
            label.setText("Nombre:" + peliculas.getListaPelicula().get(cuenta).getTitulo());
            label1.setText("Director: " + peliculas.getListaPelicula().get(cuenta).getDirector());
            label2.setText("Productora: " + peliculas.getListaPelicula().get(cuenta).getProductora());
            label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(cuenta).getPrecioEntrada());
        });


        Button buttonRetroceder = new Button("Retroceder");
        buttonRetroceder.setOnAction((t) -> {
            cuenta--;
            label.setText("Nombre:" + peliculas.getListaPelicula().get(cuenta).getTitulo());
            label1.setText("Director: " + peliculas.getListaPelicula().get(cuenta).getDirector());
            label2.setText("Productora: " + peliculas.getListaPelicula().get(cuenta).getProductora());
            label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(cuenta).getPrecioEntrada()); 
            
        });

        root.getChildren().addAll(buttonAvanzar,buttonRetroceder);

    }

    public static void main(String[] args) {
        launch();
    }

}