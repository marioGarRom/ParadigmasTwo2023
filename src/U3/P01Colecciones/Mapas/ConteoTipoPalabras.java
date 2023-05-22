package U3.P01Colecciones.Mapas;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

//Programa que cuenta el núm. de ocurrencias de c/palabra de un objeto String
public class ConteoTipoPalabras {
    public static void main(String[] args) {
        //crea un HashMap para almacenar valores String y valores Integer
        Map<String, Integer> miMapa = new HashMap<>();
        crearMapa(miMapa);
        mostrarMapa(miMapa);
    }

    //crea mapa de frecuencias a partir de la entrada del usuario
    private static void crearMapa(Map<String, Integer> frecuencias) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escribe un enunciado: ");
        String enunciado = entrada.nextLine();

        //divide el enunciado en tokens
        String[] tokens = enunciado.split(" ");

        //procesamiento del texto de entrada
        for (String token : tokens) {
            String palabra = token.toLowerCase();
            //si el mapa de frecuencias contiene la entrada
            if (frecuencias.containsKey(palabra)) {
                int cuenta = frecuencias.get(palabra); //obtiene la cuenta actual
                frecuencias.put(palabra, cuenta + 1); //incrementa la cuenta
            } else {
                //agrega una nueva palabra al mapa con una cuenta de uno
                frecuencias.put(palabra, 1);
            }
        }
    }

    //muestra el contenido del mapa de frecuencias
    private static void mostrarMapa(Map<String, Integer> frecuencias) {
        Set<String> claves = frecuencias.keySet(); //obtiene las claves
        //ordena las claves
        TreeSet<String> clavesOrdenadas = new TreeSet<>(claves);
        System.out.printf("%nEl mapa contiene: %nClave\t\tValor%n");
        //genera la salida para cada clave del mapa
        for (String clave : clavesOrdenadas) {
            System.out.printf("%-8s%8s%n", clave, frecuencias.get(clave));
        }

        //escribe el tamaño del mapa y si se encuentra vacío
        System.out.printf("%nTamaño: %d%n¿Está vacío el mapa?: %b%n", frecuencias.size(), frecuencias.isEmpty());
    }
}