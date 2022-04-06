package es.javimg.listapeliculas;

public class Pelicula {
    
    private String titulo;
    private String director;
    private String productora;
    private int duracion;
    private double precioEntrada;
    private String fechaEstreno;
    
    public Pelicula() {
        
    }
    
    public Pelicula(String titulo) {
        this.titulo = titulo.toUpperCase();
        
    }
    public Pelicula(String titulo, String director) {
        this.titulo = titulo.toUpperCase();
        this.director = director;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductora() {
        return productora;
    }
    
    public void setProductora(String productora) {
        this.productora = productora;
    }
    
    public int getDuracion() {
    return duracion;
}
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    

    public double getPrecioEntrada() {
        return precioEntrada;
    }
    
    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;

    }
    
    public String getFechaEstreno() {
        return fechaEstreno;
    }
    
    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    
    @Override
    public String toString() {
        String r = "";
        r += "Titulo: " + titulo + "\n";
        r += "director: " + director  + "\n";
        return r; 
    }
    

}
