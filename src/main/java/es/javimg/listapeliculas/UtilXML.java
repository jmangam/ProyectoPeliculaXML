
package es.javimg.listapeliculas;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    
        public static void guardarDatosXML(Stage stage, ListaPeliculas listapeliculas) {
            JAXBContext contexto;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Guardar XML en");
                File fileListaPeliculas = fileChooser.showSaveDialog(stage);

                contexto = JAXBContext.newInstance(ListaPeliculas.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                marshaller.marshal(listapeliculas, System.out);
                marshaller.marshal(listapeliculas, fileListaPeliculas);
            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
            }

        }
        public static void convertirDatosXML (Stage stage, ListaPeliculas listapeliculas){
            
            try {
                
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Importar xml");
                File fileListaPeliculas = fileChooser.showOpenDialog(stage);
                
                
                
                JAXBContext context = JAXBContext.newInstance( Pelicula.class );
                Unmarshaller unmarshaller = context.createUnmarshaller();
                listapeliculas = (ListaPeliculas)unmarshaller.unmarshal(fileListaPeliculas);

                //System.out.println(pelicula.getTitulo());
                //System.out.println(pelicula.getDuracion());

            } catch (JAXBException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
}