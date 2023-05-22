package VideogamesSales;

public class VideoJuego {
    //se declaran las variables a utilizar
    private int Indice;
    private String Titulo;
    private String Plataforma;
    private int Año;
    private String Genero;
    private String Publisher;
    private double ventas_NA;
    private double ventas_EU;
    private double ventas_JP;
    private double ventas_Globales;

    //declaración del constructor
    public VideoJuego(int indice, String titulo, String plataforma, int año, String genero, String publisher, double ventas_NA, double ventas_EU, double ventas_JP, double ventas_Globales) {
        Indice = indice;
        Titulo = titulo;
        Plataforma = plataforma;
        Año = año;
        Genero = genero;
        Publisher = publisher;
        this.ventas_NA = ventas_NA;
        this.ventas_EU = ventas_EU;
        this.ventas_JP = ventas_JP;
        this.ventas_Globales = ventas_Globales;
    }

    //método getter

    public int getIndice() {
        return Indice;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public int getAño() {
        return Año;
    }

    public String getGenero() {
        return Genero;
    }

    public String getPublisher() {
        return Publisher;
    }

    public double getVentas_NA() {
        return ventas_NA;
    }

    public double getVentas_EU() {
        return ventas_EU;
    }

    public double getVentas_JP() {
        return ventas_JP;
    }

    public double getVentas_Globales() {
        return ventas_Globales;
    }

    //método toString

    @Override
    public String toString() {
        return "Videojuego[" +
                "Indice:" + Indice +
                ", Titulo:'" + Titulo + '\'' +
                ", Plataforma:'" + Plataforma + '\'' +
                ", Año:" + Año +
                ", Genero:'" + Genero + '\'' +
                ", Publisher:'" + Publisher + '\'' +
                ", ventas_NA:" + ventas_NA +
                ", ventas_EU:" + ventas_EU +
                ", ventas_JP:" + ventas_JP +
                ", ventas_Globales:" + ventas_Globales +
                ']';
    }
}