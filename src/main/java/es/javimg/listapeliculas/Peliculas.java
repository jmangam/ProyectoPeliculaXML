package es.javimg.listapeliculas;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Peliculas {
    
    private ArrayList<Pelicula> listapeliculas = new ArrayList();
    
    public ArrayList<Pelicula> getListaPelicula(){
        return listapeliculas;
    }
    
    @XmlElement(name = "pelicula")
    public void setListaPelicula(ArrayList<Pelicula> listapeliculas){
        this.listapeliculas = listapeliculas;
    }
    
    public void añadirPeliculas(Peliculas peliculasImport) {
        this.getListaPelicula().addAll(peliculasImport.getListaPelicula());
    }
}
