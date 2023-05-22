package Prueba;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainMuertesEverest {
    public static void main(String[] args) {
        ArrayList<MuertesEverest> listaDeMuertesEverest;

        //recuperar los datos de un archivo de texto
        ArchivoMuertesEverest archivoMuertesEverestMario = new ArchivoMuertesEverest("muertes_everest.txt");
        listaDeMuertesEverest = archivoMuertesEverestMario.leerDeArchivoMuertesEverest();

        //mostrar todos los datos
        System.out.println("--------------------------------------------------------------");
        System.out.println("LISTA COMPLETA DE LAS MUERTES REGISTRADAS EN EL MONTE EVEREST - MARIO GARDUÑO ROMERO");
        imprimirRenglon();
        listaDeMuertesEverest.parallelStream().forEach(System.out::println);
        imprimirRenglon();

        //agrupar a las personas por nacionalidad
        Map<String, List<MuertesEverest>> porNacionalidad = listaDeMuertesEverest.stream()
                .collect(Collectors.groupingBy(MuertesEverest::getNacionalidad));

        porNacionalidad.forEach((nacionalidad, personasPorNacionalidad) -> {
                    System.out.println(nacionalidad);
                    personasPorNacionalidad.forEach(
                            muertesEverest -> System.out.printf(" %s%n", muertesEverest.toString())
                    );
                }
        );
        imprimirRenglon();

        //agrupar a las personas por causa de muerte
        Map<String, List<MuertesEverest>> porCausaMuerte = listaDeMuertesEverest.stream()
                .collect(Collectors.groupingBy(MuertesEverest::getCausaMuerte));

        porCausaMuerte.forEach((causa_muerte, personasPorCausaMuerte) -> {
                    System.out.println(causa_muerte);
                    personasPorCausaMuerte.forEach(
                            muertesEverest -> System.out.printf(" %s%n", muertesEverest.toString())
                    );
                }
        );
        imprimirRenglon();

        //agrupar a las personas por ubicación
        Map<String, List<MuertesEverest>> porUbicacion = listaDeMuertesEverest.stream()
                .collect(Collectors.groupingBy(MuertesEverest::getUbicacion));

        porUbicacion.forEach((ubicacion, personasPorUbicacion) -> {
                    System.out.println(ubicacion);
                    personasPorUbicacion.forEach(
                            muertesEverest -> System.out.printf(" %s%n", muertesEverest.toString())
                    );
                }
        );
        imprimirRenglon();
    }

    //renglon
    public static void imprimirRenglon() {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
    }

    //encabezado
    public static void imprimirEncabezado() {
        System.out.printf("%-12s   %-12s   %-12S ", "Nacionalidad", "Causa_de_muerte", "Ubicación");
        System.out.println();
        System.out.println("--------------------------------------------------------------");
    }
}