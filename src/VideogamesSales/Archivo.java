package VideogamesSales;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    String nombreArchivo;

    public Archivo(String nombreA) {
        this.nombreArchivo = nombreA;
    }

    //crear el archivo
    public void CrearArchivo() {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try {
                PrintWriter salidaArchivo = new PrintWriter(nombreArchivo);
                System.out.println("El archivo " + nombreArchivo + " se ha creado.");
                salidaArchivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<VideoJuego> leerDeArchivo() {
        ArrayList<VideoJuego> listaVideoJuegos = new ArrayList<>();
        try {
            //abrir el archivo
            File archivoLectura = new File(nombreArchivo);
            Scanner leerArchivo = new Scanner(archivoLectura);
            //leer el archivo

            while (leerArchivo.hasNext()) {
                String linea = leerArchivo.nextLine();
                String[] valores = linea.split("\\|");
                int Indice = Integer.parseInt(valores[0]);
                String Titulo = valores[1];
                String Plataforma = valores[2];
                int Año = Integer.parseInt(valores[3]);
                String Genero = valores[4];
                String Publisher = valores[5];
                double Ventas_NA = Double.parseDouble(valores[6]);
                double Ventas_EU = Double.parseDouble(valores[7]);
                double Ventas_JP = Double.parseDouble(valores[8]);
                double Ventas_Globales = Double.parseDouble(valores[9]);
                VideoJuego juegoAux = new VideoJuego(Indice, Titulo, Plataforma, Año, Genero, Publisher,
                        Ventas_NA, Ventas_EU, Ventas_JP, Ventas_Globales);
                listaVideoJuegos.add(juegoAux);
            }
            //cerrar el archivo
            leerArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaVideoJuegos;
    }//fin del archivo
}