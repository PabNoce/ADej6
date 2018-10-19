/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.ej6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class AccesoDatosEj6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos metodo = new Metodos();
        File fich = new File("C:/Users/pablo/documents/a.txt");
        try {
            metodo.separarPorLineas(fich, 2, "C:/Users/pablo/documents/aSeparado");
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosEj6.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            metodo.separarPorCaracteres(fich, 20, "C:/Users/pablo/documents/aSeparado");
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosEj6.class.getName()).log(Level.SEVERE, null, ex);
        }
        File[] listaFich = new File[4];
        listaFich[0] = new File("C:/Users/pablo/documents/aSeparado1.txt");
        listaFich[1] = new File("C:/Users/pablo/documents/aSeparado2.txt");
        listaFich[2] = new File("C:/Users/pablo/documents/aSeparado3.txt");
        listaFich[3] = new File("C:/Users/pablo/documents/aSeparado4.txt");
        try {
            metodo.unirFicheros(listaFich, "C:/Users/pablo/documents/FicheroUnido");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatosEj6.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatosEj6.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
