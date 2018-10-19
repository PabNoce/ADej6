/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.ej6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author pablo
 */
public class Metodos {

    public void separarPorLineas(File fich, int linesPerFile, String ruta) throws FileNotFoundException, IOException {
        PrintWriter pw = null;
        BufferedReader br = null;
        FileReader sc = null;
        int numFich = 1, countLines = 0;
        String linea;
        try {
            File nuevoFich = new File(ruta + numFich + ".txt");
            sc = new FileReader(fich);
            br = new BufferedReader(sc);
            pw = new PrintWriter(nuevoFich);
            while ((linea = br.readLine()) != null) {
                if (countLines < linesPerFile) {
                    pw.println(linea);
                    countLines++;
                } else {
                    countLines = 1;
                    numFich++;
                    pw.close();
                    nuevoFich = new File(ruta + numFich + ".txt");
                    pw = new PrintWriter(nuevoFich);
                    pw.println(linea);
                }
            }
        } finally {
            sc.close();
            br.close();
            pw.close();
        }
    }

    public void separarPorCaracteres(File fich, int charPerFile, String ruta) throws FileNotFoundException, IOException {
        PrintWriter pw = null;
        FileReader sc = null;
        int numFich = 1, ch;
        try {
            File nuevoFich = new File(ruta + numFich + ".txt");
            sc = new FileReader(fich);
            pw = new PrintWriter(nuevoFich);
            char[] buffer = new char[charPerFile];
            while ((ch = sc.read(buffer)) != -1) {
                nuevoFich = new File(ruta + numFich + ".txt");
                pw.write(buffer, 0, ch);
                numFich++;
                pw.close();
            }
        } finally {
            sc.close();
            pw.close();
        }
    }

    public void unirFicheros(File[] listaFich, String ruta) throws FileNotFoundException, IOException {
        String linea;
        PrintWriter pw = null;
        FileReader sc = null;
        try {
            File nuevoFich = new File(ruta + ".txt");
            pw = new PrintWriter(nuevoFich);
            BufferedReader br;
            for (File fich : listaFich) {
                sc = new FileReader(fich);
                br = new BufferedReader(sc);
                while ((linea = br.readLine()) != null) {
                    pw.print(linea);
                }
            }
        } finally {
            sc.close();
            pw.close();
        }
    }
}
