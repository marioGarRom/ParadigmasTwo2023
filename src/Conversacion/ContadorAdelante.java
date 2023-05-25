package Conversacion;

public class ContadorAdelante implements Runnable {
    private String nombre;

    public ContadorAdelante(String nombrex) {
        this.nombre = nombrex;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("\t" + nombre + " " + i + "\n");
        }
        System.out.println();
    }
}

class ContadorAtras implements Runnable {
    private String nombre;

    public ContadorAtras(String nombrex) {
        this.nombre = nombrex;
    }

    @Override
    public void run() {
        for (int i = 1000; i >= 1; i--) {
            System.out.println("\t\t\t" + nombre + " " + i + "\n");
        }
        System.out.println();
    }
}

class HiloContadoresPrueba {
    public static void main(String[] args) {
        Thread cuentaAtras = new Thread(new ContadorAtras("Contador--"));
        cuentaAtras.start();

        Thread cuentaAdelante = new Thread(new ContadorAdelante("Contador++"));
        cuentaAdelante.start();
    }
}