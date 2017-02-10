package exercici.pkg1.pkg3.m6.uf1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import static java.io.FileDescriptor.in;
import static java.io.FileDescriptor.out;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.zip.GZIPOutputStream;
import static javax.management.Query.in;
import static sun.misc.MessageUtils.out;

public class GestioDocumentCaracters {

    String ruta1 = "C:\\proves\\Execici3-1";
    String ruta2 = "C:\\proves\\Execici3-2";

    //Es creen els fitxers.
    File fitxerLlegir = new File(ruta1);
    File fitxerEscriure = new File(ruta2);

    //Es creen els buffers per llegir i escriure.
    BufferedReader lectorFichero;
    BufferedWriter escritorFichero;

    /**
     * Metode que copia el contingut d'un fitxer en un altre. Se li passen el
     * fitxer d'on llegeix i el fitxer on escriu.
     *
     * @param fitxerLlegir
     * @param fitxerEscriure
     */
    public void copiarFitxersBuffers(File fitxerLlegir, File fitxerEscriure) {
        try {
            try {
                //inicialitzem els buffers.
                lectorFichero = new BufferedReader(new FileReader(fitxerLlegir));
                escritorFichero = new BufferedWriter(new FileWriter(fitxerEscriure));
                String linea;

                //Bucle que recorrera el fitxer que es llegeix i va escribint en el fitxer
                //d'escriptura.
                while ((linea = lectorFichero.readLine()) != null) {
                    escritorFichero.write(linea + "\n");
                    System.out.println(linea);
                }

                //Es tanca el buffer lector i l'escriptor.
                lectorFichero.close();
                escritorFichero.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();//traza de excepcion 

            } catch (IOException e) {
                e.printStackTrace();//traza de excepcion 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metode que copia el contingut d'un fitxer en un altre i el comprimeix. Se
     * li passen el fitxer d'on llegeix i el fitxer on escriu.
     *
     * @param fitxerLlegir
     * @param fitxerEscriure
     */
    public void copiarFitxersBuffersComprimit(File fitxerLlegir, File fitxerEscriure) {
        try {
            try {
                //inicialitzem els buffers.
                lectorFichero = new BufferedReader(new FileReader(fitxerLlegir));
                escritorFichero = new BufferedWriter(new FileWriter(fitxerEscriure));
                //Es crea un FileOutputStream i un FileInputStream
                FileInputStream inputStream = new FileInputStream(fitxerLlegir);
                FileOutputStream outputStream = new FileOutputStream("archivoZIP.zip");

                GZIPOutputStream gos = new GZIPOutputStream(outputStream);

                byte data[] = new byte[1024];

                //Bucle que recorrera el fitxer que es llegeix i va escribint en el fitxer
                //d'escriptura.
                int c;
                int contador = 0;
                while ((c = inputStream.read()) != -1) {
                    data[contador] = (byte) c;
                    gos.write(contador);
                    contador++;
                }

                //Es tanca el buffer lector i l'escriptor.
                lectorFichero.close();
                escritorFichero.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();//traza de excepcion 

            } catch (IOException e) {
                e.printStackTrace();//traza de excepcion 
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void CercarCadenaText(String cadena, File fitxer) {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(fitxer));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.indexOf(cadena) != -1) {
                    System.out.println("" + line);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void descarregarURL(){
        
    }
    
    
    
}
