package HiloDormido;

public class Frases {
    public static void main(String[] args) {
        String frase1 = "Preguntarse cuando los ordenadores podran pensar es como " + "\n" + "preguntarse cuando los submarinos podran nadar.";
        String autorFrase1 = "__Edsger W. Dijkstra";
        String frase2 = "No importa lo estupendamente que haya ido la demo en " + "\n" + "los ensayos, cuando lo haces frente a tu audencia la " + "\n" + "probabilidadde que sea una presentacion exitosa es " + "\n" + "inversamente proporcional al numero de personas mirando, " + "\n" + "elevando a la cantidad de dinero que hay juegos " + "\n" + "-- Mark Gibbs";
        EscrituraLenta.escritura(frase1, 20);
        EscrituraLenta.escritura(autorFrase1, 400);
        System.out.println();
        EscrituraLenta.escritura("-------------------------------------------------------------------",200);
        EscrituraLenta.escritura(" ", 2000);
        System.out.println();
        EscrituraLenta.escritura(frase2, 10);
    }
}