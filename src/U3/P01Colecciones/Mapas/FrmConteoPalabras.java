package U3.P01Colecciones.Mapas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FrmConteoPalabras extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Map<String, Integer> frecuencias = new HashMap<>();

    public FrmConteoPalabras() {
        initComponents();
        crearMapa();
        llenarTabla();
    }

    private void crearMapa() {
        try {
            //leer el archivo de texto
            BufferedReader reader = new BufferedReader(new FileReader("C:\\PROGRAMACION_ICO_26\\ParadigmasTwo2\\src\\U3\\P01Colecciones\\Mapas\\03.1 melville-moby_dick.txt"));
            String linea = reader.readLine();

            //ciclo while 0
            while (linea != null) {

                //elimina los signos de puntuación y convierte a minúsculas
                linea = linea.replaceAll("[^a-z A-Z\\s]", "").toLowerCase();

                //divide la línea en palabras
                StringTokenizer tokenizer = new StringTokenizer(linea);

                //ciclo while 1
                while (tokenizer.hasMoreTokens()) {
                    String palabra = tokenizer.nextToken();

                    //actualiza la frecuencia de la palabra
                    //condicional
                    if (frecuencias.containsKey(palabra)) {
                        int cuenta = frecuencias.get(palabra);
                        frecuencias.put(palabra, cuenta + 1);
                    } else {
                        frecuencias.put(palabra, 1);
                    }
                }
                linea = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarTabla() {
        Object[] fila = new Object[2];

        //recorre el mapa y llena la tabla
        for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
            fila[0] = entry.getKey();
            fila[1] = entry.getValue();
            model.addRow(fila);
        }
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        //crea una tabla
        JTable table = new JTable(model);
        model.addColumn("Palabra");
        model.addColumn("No. de ocurrencias");
        JScrollPane scrollPane = new JScrollPane(table); //agregar JScrollPane
        panel.add(scrollPane, BorderLayout.CENTER); //usar JScrollPane en lugar de la tabla directamente

        //agregar contenido a la tabla
        llenarTabla();

        //agregar el encabezado de la tabla al panel
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        setContentPane(panel);

        //características de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Frecuencia de palabras de un archivo de texto - Yessi");
        setLocationRelativeTo(null);
    }

    //main
    public static void main(String[] args) {
        new FrmConteoPalabras().setVisible(true);
    }
}