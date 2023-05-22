package Prueba;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoMuertesEverest {
    String nombreArchivoM;

    public ArchivoMuertesEverest(String nombreArchivooo) {
        this.nombreArchivoM = nombreArchivooo;
    }

    public void CrearArchivoMuertesEverest() {
        File archivoMuertesEverest = new File(nombreArchivoM);
        if (!archivoMuertesEverest.exists()) {
            try {
                PrintWriter salidaArchivoMuertesEverest = new PrintWriter(nombreArchivoM);
                System.out.println("El archivo " + nombreArchivoM + " se ha creado.");
                salidaArchivoMuertesEverest.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MuertesEverest> leerDeArchivoMuertesEverest() {
        ArrayList<MuertesEverest> listaDeMuertesEverest = new ArrayList<>();
        try {
            //abrir el archivo
            File archivoMuertesEverestLectura = new File(nombreArchivoM);
            Scanner leerArchivoMuertesEverest = new Scanner(archivoMuertesEverestLectura);

            //leer el archivo
            while (leerArchivoMuertesEverest.hasNext()) {
                String linea = leerArchivoMuertesEverest.nextLine();
                String[] valores = linea.split("\\|");
                String Nombre = valores[0];
                String Fecha = valores[1];
                double Edad = Double.parseDouble(valores[2]);
                String Expedicion = valores[3];
                String Nacionalidad = valores[4];
                String CausaMuerte = valores[5];
                String Ubicacion = valores[6];

                MuertesEverest muertesEverestAux = new MuertesEverest(Nombre, Fecha, Edad, Expedicion,
                        Nacionalidad, CausaMuerte, Ubicacion);
                listaDeMuertesEverest.add(muertesEverestAux);
            }
            //cerrar el archivo
            leerArchivoMuertesEverest.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDeMuertesEverest;
    }
}