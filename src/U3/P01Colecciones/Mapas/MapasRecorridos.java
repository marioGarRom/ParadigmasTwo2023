package U3.P01Colecciones.Mapas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapasRecorridos {
    public static void main(String[] args) {
        Map<String, String> jugadores = new HashMap<>();

        jugadores.put("Leo Messi", "Barcelona");
        jugadores.put("Luis Suarez", "Barcelona");
        jugadores.put("Arturo Vidal", "Barcelona");
        jugadores.put("Rakitik", "Barcelona");
        jugadores.put("Sergio Ramos", "Real Madrid");
        jugadores.put("Toni Kroos", "Real Madrid");
        jugadores.put("Luka Modric", "Real Madrid");
        jugadores.put("Ansu Fati", null);
        imprimirLinea();

        //iteración usando entrySet()
        System.out.println("Iteración usando entrySet(). Primera forma");
        Set<Entry<String, String>> entries = jugadores.entrySet();
        for (Entry<String, String> entry : entries) {
            System.out.println("Jugador: " + entry.getKey() + " Equipo: " + entry.getValue());
        }
        imprimirLinea();

        System.out.println("Iteración usando entrySet(). Segunda forma");
        for (Entry<String, String> entry : jugadores.entrySet()) {
            System.out.println("Jugador: " + entry.getKey() + "Equipo: " + entry.getValue());
        }
        imprimirLinea();

        System.out.println("Impresión de jugadores");
        for (String player : jugadores.keySet()) {
            System.out.println("Jugador: " + player);
        }
        imprimirLinea();

        System.out.println("Impresión de equipos");
        for (String team : jugadores.values()) {
            System.out.println("Equipo: " + team);
        }
        imprimirLinea();

        System.out.println("Impresión con iteradores: ");
        for (Iterator<Map.Entry<String, String>> iterador =
             jugadores.entrySet().iterator(); iterador.hasNext(); ) {
            Map.Entry<String, String> entry = iterador.next();
            String player = entry.getKey();
            String team = entry.getValue();

            System.out.println("Jugador: " + player + "Equipo: " + team);
        }
        imprimirLinea();

        System.out.println("Impresión de jugadores y equipos utilizando forEach");
        jugadores.forEach((player, team) -> System.out.println("Jugador: " + player + "Equipo: " + team));
    }

    public static void imprimirLinea() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
    }
}
