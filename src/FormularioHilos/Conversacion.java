package FormularioHilos;

import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Conversacion {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mostrar Imagen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String rutaImagen = "C:\\Users\\chido\\OneDrive\\Documentos\\2023A\\ima1.png";
        ImageIcon icono = new ImageIcon(rutaImagen);

        JLabel etiquetaImagen = new JLabel(icono);
        frame.getContentPane().add(etiquetaImagen);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Pregunta exerciseThread = new Pregunta();
        exerciseThread.startExercise("-----------------------------------------\nRead the conversation. Who is doing these things? Complete the sentences.\n");
        exerciseThread.waitForAnswer("1. Anne is Paul's ________? ", "wife");
        exerciseThread.evaluateAnswer("Anne is Paul's wife.");

        exerciseThread.startExercise("2. Jason and Emily are ________? ");
        exerciseThread.waitForAnswer("2. Who are they? ", "their children");
        exerciseThread.evaluateAnswer("Jason and Emily are their children.");

        exerciseThread.startExercise("3. Paul is ________? ");
        exerciseThread.waitForAnswer("3. Who is Paul's? ", "Anne's husband");
        exerciseThread.evaluateAnswer("Paul is Anne's husband.");

        exerciseThread.startExercise("4. Jason is ________? ");
        exerciseThread.waitForAnswer("4. Who is Jason's? ", "Anne's son");
        exerciseThread.evaluateAnswer("Jason is Anne's son.");

        exerciseThread.startExercise("5. Emily is ________? ");
        exerciseThread.waitForAnswer("5. Who is Emily's? ", "Paul's daughter");
        exerciseThread.evaluateAnswer("Emily is Paul's daughter.");

        exerciseThread.startExercise("6. Jason is ________? ");
        exerciseThread.waitForAnswer("6. Who is Jason's? ", "Emily's brother");
        exerciseThread.evaluateAnswer("Jason is Emily's brother.");

        exerciseThread.startExercise("7. Emily is ________? ");
        exerciseThread.waitForAnswer("7. Who is Emily's? ", "Jason's sister");
        exerciseThread.evaluateAnswer("Emily is Jason's sister.");

        exerciseThread.startExercise("8. Paul and Anne are ________? ");
        exerciseThread.waitForAnswer("8. Who are Paul and Anne? ", "Jason's parents");
        exerciseThread.evaluateAnswer("Paul and Anne are Jason's parents.");
    }

    private static void displayMessage(String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private static class Pregunta {
        private void startExercise(String exercise) {
            System.out.println(exercise);
            sleep();
        }

        private void waitForAnswer(String question, String expectedAnswer) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(question);

            String answer = scanner.nextLine();
            while (!answer.equalsIgnoreCase(expectedAnswer)) {
                System.out.println("Incorrect answer. Try again.");
                System.out.print(question);
                answer = scanner.nextLine();
            }
        }

        private void evaluateAnswer(String sentence) {
            System.out.println("Correct! " + sentence);
            System.out.println("Great job!");
            System.out.println();
            sleep();
        }

        private void sleep() {
            try {
                Thread.sleep(4000); // Retardo de 4 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}