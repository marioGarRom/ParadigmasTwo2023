package U3.P01Colecciones.Mapas;

import java.util.HashMap;
import java.util.Map;

public class MapasJugadores {
    public static void main(String[] args) {
        Map<String, String> jugadores = new HashMap<>();

        //inserción de elementos en el mapa
        jugadores.put("Leo Messi", "Barcelona");
        jugadores.put("Luis Suarez", "Barcelona");
        jugadores.put("Arturo Vidal", "Barcelona");
        jugadores.put("Rakitik", "Barcelona");
        jugadores.put("Sergio Ramos", "Real Madrid");
        jugadores.put("Toni Kroos", "Real Madrid");
        jugadores.put("Luka Modric", "Real Madrid");
        jugadores.put("Ansu Fati", null);
        imprimirLinea();

        //añadir si hay un valor ausente
        jugadores.putIfAbsent("Ansu Fati", "Barcelona");
        System.out.println("El equipo de Ansu Fati: " + jugadores.get("Ansu Fati"));
        imprimirLinea();

        //no permite cambios en un nuevo intento
        jugadores.putIfAbsent("Ansu Fati", "Sevilla");
        System.out.println("¿En qué equipo está ahora Ansu Fati?: " + jugadores.get("Ansu Fati"));
        imprimirLinea();

        //obtener los valores de un mapa
        String equipoleo = jugadores.get("Leo Messi");
        System.out.println("El equipo de Leo es: " + equipoleo);
        imprimirLinea();
        String equipoCristiano = jugadores.getOrDefault("Cristiano Ronaldo", "No está registrado");
        System.out.println("El equipo de Cristiano Ronaldo es: " + equipoCristiano);
        imprimirLinea();

        //preguntar si una clave está incluida en el mapa
        if (jugadores.containsKey("Luka Modric")) {
            System.out.println("El equipo de Luka Modric es: " + jugadores.get("Luka Modric"));
        } else {
            System.out.println("No se encuentra Luka Modric");
        }
        imprimirLinea();

        //es posible preguntar si existe un valor en el mapa
        System.out.println("¿Se encuentra un jugador de Sevilla? " + jugadores.containsValue("Sevilla"));
        imprimirLinea();

        //obtener todas la claves del mapa
        System.out.println("¿Qué jugadores están registrados?");
        System.out.println(jugadores.keySet());
        imprimirLinea();

        //obtener todos los valores del mapa
        System.out.println("¿Qué equipos están registrados en relación a los jugadores?");
        System.out.println(jugadores.values());
        imprimirLinea();

        //reeemplazo de un valor en el mapa
        jugadores.replace("Rakitik", "Sevilla");
        System.out.println("Ahora Rakitik juega en: " + jugadores.get("Rakitik"));
        imprimirLinea();

        //eliminar una entrada del mapa
        System.out.println("¿Se encuentra Rakitik en el registro? " + jugadores.containsKey("Rakitik"));
        jugadores.remove("Rakitik");
        System.out.println("¿Se encuentra Rakitik en el registro? " + jugadores.containsKey("Rakitik"));
        imprimirLinea();

        //tamaño del mapa (número de entradas del mapa)
        System.out.println("El tamaño del mapa es: " + jugadores.size());
        imprimirLinea();

        //preguntar si el mapa está vacío
        if (jugadores.isEmpty()) {
            System.out.println("El registro de jugadores está vacío.");
        } else {
            System.out.println("El registro de jugadores no está vacío.");
        }
        imprimirLinea();

        for (String player : jugadores.keySet()) {
            System.out.println("Jugador: " + player);
        }
        imprimirLinea();
        for (String equipo : jugadores.values()) {
            System.out.println("Equipos: " + equipo);
        }
        imprimirLinea();

        //imprimir el par de valores del mapa con un forEach
        System.out.println("Impresión de jugadores y equipos utilizando forEach");
        jugadores.forEach((player, team) -> System.out.println("Jugador: " + player + " Equipo: " + team));
        imprimirLinea();

        //limpiar el mapa por completo
        jugadores.clear();
        System.out.println("La cantidad de jugadores en el mapa después de limpiarlo es de: " + jugadores.size());
    }

    //imprimirLinea
    public static void imprimirLinea() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
    }
}