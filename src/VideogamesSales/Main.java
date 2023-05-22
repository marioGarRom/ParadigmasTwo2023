package VideogamesSales;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<VideoJuego> videoJuegos;

        // Recuperar los datos de un archivo de texto
        Archivo archivox = new Archivo("ventas_videojuegos.txt");
        videoJuegos = archivox.leerDeArchivo();

        videoJuegos.stream().forEach(videoJuego -> System.out.println(videoJuego));
        imprimirLinea();

        List<String> titulos = videoJuegos.stream()
                .map(videoJuego -> videoJuego.getTitulo())
                .collect(Collectors.toList());

        StringBuilder salida = new StringBuilder();
        for (String titulo : titulos) {
            salida.append(titulo).append("\n");
        }
        System.out.println(salida);
        imprimirLinea();

        List<String> titulosYPlataformas = videoJuegos.stream()
                .map(videoJuego -> {
                    return String.format("%30s%10s%n", videoJuego.getTitulo(), videoJuego.getPlataforma());
                })
                .collect(Collectors.toList());

        salida = new StringBuilder();
        for (String titulo: titulosYPlataformas){
            salida.append(titulo);
        }
        System.out.println(salida);
        imprimirLinea();

        System.out.println("Promedio de las ventas globales: ");
        double promedioVentasGlobales = videoJuegos.stream().
                mapToDouble(value -> value.getVentas_Globales())
                .average().getAsDouble();
        System.out.println(promedioVentasGlobales);
        imprimirLinea();

        System.out.println("Suma de los valores de la columna Ventas_NA: ");
        double totalVentasNA = videoJuegos.stream()
                .mapToDouble(value -> value.getVentas_NA()).sum();
        System.out.println(totalVentasNA);
        imprimirLinea();

        List<String> columnaAnio = videoJuegos.stream()
                .map(videoJuego -> {
                    return String.format("%10d%n", videoJuego.getAño());
                })
                .collect(Collectors.toList());

        salida = new StringBuilder();
        for (String anio : columnaAnio){
            salida.append(anio);
        }
        System.out.println(salida);
        imprimirLinea();

        double maxVentasJP = videoJuegos.stream()
                .mapToDouble(value -> value.getVentas_JP())
                .max().getAsDouble();

        double minVentasJP = videoJuegos.stream()
                .mapToDouble(value -> value.getVentas_JP())
                .min().getAsDouble();

        System.out.println("Venta máxima JP: " + maxVentasJP);
        System.out.println("Venta mínima JP: " + minVentasJP);
    }

    public static void imprimirLinea(){
        System.out.println("-----------------------------------------------------");
    }
}