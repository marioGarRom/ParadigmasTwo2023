package ConsultaPersonas;

public class Persona {
    private int id, anioNacimiento, salario;
    private String nombre, apellido;
    private double coeficiente;

    public Persona(int id, String nombre, String apellido, int anioNacimiento, int salario, double coeficiente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNacimiento;
        this.salario = salario;
        this.coeficiente = coeficiente;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public int getSalario() {
        return salario;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", salario=" + salario +
                ", coeficiente=" + coeficiente +
                '}';
    }
}