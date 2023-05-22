package U3.P01Colecciones.Mapas;

import java.util.*;

public class PruebasMapas {
    public static void main(String[] args) {
        HashMap<String, Integer> calificaciones = new HashMap<>();
        calificaciones.put("Carlos", 100);
        calificaciones.put("Roberto", 90);
        calificaciones.put("Carolina", 80);
        imprimirMapa(calificaciones);

        //actualizar calificación de Carlos
        calificaciones.put("Carlos", 60);
        imprimirMapa(calificaciones);

        //borrar registro de Carlos
        calificaciones.remove("Carlos");
        imprimirMapa(calificaciones);

        //calificación de Carolina
        System.out.println("Calificación de Carolina: " + calificaciones.get("Carolina"));

        //¿existe una persona en el mapa?
        if (calificaciones.containsKey("Carolina")) {
            System.out.println("Carolina existe");
        } else {
            System.out.println("Carolina no existe");
        }
        boolean encontrado1 = encontrar(calificaciones, "Carolina");
        System.out.println(encontrado1);
        boolean encontrado2 = encontrar(calificaciones, "Maria");
        System.out.println(encontrado2);
        calificaciones.remove("Maria");
    }

    private static boolean encontrar(HashMap<String, Integer> calificaciones, String nombre) {
        return calificaciones.containsKey(nombre);
    }

    public static void imprimirMapa(HashMap<String, Integer> tabla) {
        //mostrar los datos
        tabla.forEach((nombre, calificacion) -> {
            System.out.println(nombre + " " + calificacion);
        });
        System.out.println("----------------------------------------------");
    }
}