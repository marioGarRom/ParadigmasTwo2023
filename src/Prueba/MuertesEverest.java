package Prueba;

public class MuertesEverest {
    private String nombre;
    private String fecha;
    private double edad;
    private String expedicion;
    private String nacionalidad;
    private String causaMuerte;
    private String ubicacion;

    public MuertesEverest(String nombre, String fecha, double edad, String expedicion, String nacionalidad,
                          String causaMuerte, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.edad = edad;
        this.expedicion = expedicion;
        this.nacionalidad = nacionalidad;
        this.causaMuerte = causaMuerte;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public String getExpedicion() {
        return expedicion;
    }

    public void setExpedicion(String expedicion) {
        this.expedicion = expedicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCausaMuerte() {
        return causaMuerte;
    }

    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte = causaMuerte;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //en este apartado solo se hace uso de la nacionalidad, la causa de muerte y la ubicación
    @Override
    public String toString() {
        return String.format("%-12s %-12s %12s", nacionalidad, causaMuerte, ubicacion);
    }
}