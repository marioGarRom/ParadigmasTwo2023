package FormularioHilos;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FormularioHilo extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String FILE_PATH = "Texto Guardado.txt";
    //dirección del archivo de texto
    private static final String DICTIONARY_PATH = "C:\\Users\\chido\\OneDrive\\Documentos\\2023A\\dict.txt";

    private static final int AUTO_SAVE_INTERVAL = 5000; // 5 segundos
    private static final int SPELL_CHECK_INTERVAL = 6000; // 6 segundos

    private final JTextArea textArea; //área del texto
    private ArrayList<String> dictionary;
    private boolean spellingErrors; //identificación de errores

    public FormularioHilo() {
        setTitle("Formulario con hilos");
        setSize(new Dimension(300, 100));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar el diccionario
        try {
            String content = new String(Files.readAllBytes(Paths.get(DICTIONARY_PATH)));
            dictionary = new ArrayList<>(Arrays.asList(content.split("\\s+")));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el diccionario");
            dictionary = new ArrayList<>();
        }

        //caja de texto y barra de desplazamiento
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//de manera vertical
        getContentPane().add(scrollPane);

        //hilo para el auto-guardado
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(AUTO_SAVE_INTERVAL);//método sleep
                    guardarTexto();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //hilo para la revisión ortográfica
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(SPELL_CHECK_INTERVAL);
                    revisarOrtografia();
                } catch (InterruptedException | BadLocationException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                guardarTexto();
                dispose();
            }
        });
    }

    private void guardarTexto() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(textArea.getText());
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Se ha presentado un error" +
                    " al guardar el archivo");
        }
    }

    private void revisarOrtografia() throws BadLocationException {
        String text = textArea.getText();
        int offset = 0;
        spellingErrors = false;
        DefaultHighlighter.DefaultHighlightPainter painter = new
                DefaultHighlighter.DefaultHighlightPainter(Color.red);
        textArea.getHighlighter().removeAllHighlights(); //elimina el resaltado anterior
        for (String word : text.split("\\s+")) {
            if (!dictionary.contains(word)) {
                int start = text.indexOf(word, offset);
                int end = start + word.length();
                textArea.getHighlighter().addHighlight(start, end, painter);
                spellingErrors = true;
            }
            offset += word.length() + 1;
        }
        if (!spellingErrors) {
            //no errores = color normal
            textArea.setBackground(UIManager.getColor("TextArea.background"));
        } else {
            //errores = ventana de color blanco
            textArea.setBackground(Color.white);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FormularioHilo form = new FormularioHilo();
            form.setVisible(true);//hacer visible el formulario
        });
    }
}