package es.javimg.listapeliculas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class App extends Application {

    int cuenta = 0;
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setStyle("-fx-background-color: #ECCEF5;");
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        
//        Pelicula pelicula1 = new Pelicula();
//        pelicula1.setTitulo("Michael Jackson, su historia");
//        pelicula1.setDirector("Jeremias Manzano Perez");
//        pelicula1.setProductora("Netflix");
//        pelicula1.setPrecioEntrada(8.5);
//        pelicula1.setFechaEstreno("20/05/2018");
//        pelicula1.setDuracion(130);
//        
//        Pelicula pelicula2 = new Pelicula();
//        pelicula2.setTitulo("El dia de Cristiano Ronaldo");
//        pelicula2.setDirector("Florentino Duran Manchego");
//        pelicula2.setProductora("HBO");
//        pelicula2.setPrecioEntrada(10.90);
//        pelicula2.setFechaEstreno("10/02/2013");
//        pelicula2.setDuracion(145);
//        
//        Pelicula pelicula3 = new Pelicula();
//        pelicula3.setTitulo("Como se creo Apple");
//        pelicula3.setDirector("Sergio Ortelano Salguero");
//        pelicula3.setProductora("Amazon Prime Video");
//        pelicula3.setPrecioEntrada(7.90);
//        pelicula3.setFechaEstreno("19/03/2020");
//        pelicula3.setDuracion(119);
        
        
       Peliculas peliculas = new Peliculas();
//        peliculas.getListaPelicula().add(pelicula1);
//        peliculas.getListaPelicula().add(pelicula2);
//        peliculas.getListaPelicula().add(pelicula3);
//        
       
        Button buttonSelectFile = new Button("Guardar XML");
        buttonSelectFile.setOnAction((t) -> {
            UtilXML.guardarDatosXML(stage, peliculas);
        });
        
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        
        Button buttonImportFile = new Button("Importar xml");
        buttonImportFile.setOnAction((t) -> {
           Peliculas peliculasImport = UtilXML.convertirDatosXML(stage);
           peliculas.añadirPeliculas(peliculasImport);
           System.out.println("Lista importada correctamente");
           label.setText("Nombre:" + peliculas.getListaPelicula().get(0).getTitulo());
           label1.setText("Director: " + peliculas.getListaPelicula().get(0).getDirector());
           label2.setText("Productora: " + peliculas.getListaPelicula().get(0).getProductora());
           label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(0).getPrecioEntrada() + " euros"); 
           label4.setText("Duracion(minutos): " + peliculas.getListaPelicula().get(cuenta).getDuracion() + " minutos");
           label5.setText("Fecha Estreno : " + peliculas.getListaPelicula().get(cuenta).getFechaEstreno());
        });
        HBox botonesArriba = new HBox();
        botonesArriba.setSpacing(20);
        botonesArriba.setAlignment(Pos.TOP_CENTER);
        botonesArriba.getChildren().addAll(buttonImportFile,buttonSelectFile);  
        root.getChildren().add(botonesArriba);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        
        vbox.setStyle("-fx-background-color:#D5D8DC");
        vbox.getChildren().addAll(label, label1, label2, label3, label4, label5);
        vbox.setAlignment(Pos.CENTER);
        vbox.setBorder(new Border(new BorderStroke(Color.PURPLE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        vbox.setMaxSize(250,450);
        
       root.getChildren().add(vbox);
//       label.setText("Nombre:" + peliculas.getListaPelicula().get(0).getTitulo());
//       label1.setText("Director: " + peliculas.getListaPelicula().get(0).getDirector());
//       label2.setText("Productora: " + peliculas.getListaPelicula().get(0).getProductora());
//       label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(0).getPrecioEntrada() + " euros"); 
//       label4.setText("Duracion(minutos): " + peliculas.getListaPelicula().get(cuenta).getDuracion() + " minutos");
//       label5.setText("Fecha Estreno : " + peliculas.getListaPelicula().get(cuenta).getFechaEstreno());
        
        Button buttonAvanzar = new Button("Avanzar");
        buttonAvanzar.setOnAction((t) -> {
            cuenta++;
            try {
            label.setText("Nombre:" + peliculas.getListaPelicula().get(cuenta).getTitulo());
            label1.setText("Director: " + peliculas.getListaPelicula().get(cuenta).getDirector());
            label2.setText("Productora: " + peliculas.getListaPelicula().get(cuenta).getProductora());
            label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(cuenta).getPrecioEntrada() + " euros" );
            label4.setText("Duracion(minutos): " + peliculas.getListaPelicula().get(cuenta).getDuracion() + " minutos");
            label5.setText("Fecha Estreno : " + peliculas.getListaPelicula().get(cuenta).getFechaEstreno());
            } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("No hay peliculas para mostrar en esta lista");
            alert.setContentText("Error, no existen mas peliculas para mostrar");
            alert.showAndWait();
            }
        });


        Button buttonRetroceder = new Button("Retroceder");
        buttonRetroceder.setOnAction((t) -> {
            cuenta--;
            try {
            label.setText("Nombre:" + peliculas.getListaPelicula().get(cuenta).getTitulo());
            label1.setText("Director: " + peliculas.getListaPelicula().get(cuenta).getDirector());
            label2.setText("Productora: " + peliculas.getListaPelicula().get(cuenta).getProductora());
            label3.setText("Precio Entrada: " + peliculas.getListaPelicula().get(cuenta).getPrecioEntrada() + " euros");
            label4.setText("Duracion(minutos): " + peliculas.getListaPelicula().get(cuenta).getDuracion() + " minutos");
            label5.setText("Fecha Estreno : " + peliculas.getListaPelicula().get(cuenta).getFechaEstreno());
            } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("No hay peliculas para mostrar en esta lista");
            alert.setContentText("Error, no existen mas peliculas para mostrar");
            alert.showAndWait();
            }
            
        });
        HBox botonesAbajo = new HBox();
        botonesAbajo.setSpacing(20);
        botonesAbajo.setAlignment(Pos.TOP_CENTER);
        botonesAbajo.getChildren().addAll(buttonRetroceder,buttonAvanzar);
        root.getChildren().addAll(botonesAbajo);

    }

    public static void main(String[] args) {
        launch();
    }

}