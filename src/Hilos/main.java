package Hilos;

public class main {
    public static void main(String[] args) {

        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("Lista de Articulo Minorista");
        System.out.println("------------------------------------------------------------------------------------------");
        Thread empleados = new Thread(new
                HiloParaArticuloMinorista());
        empleados.start();
    }
}