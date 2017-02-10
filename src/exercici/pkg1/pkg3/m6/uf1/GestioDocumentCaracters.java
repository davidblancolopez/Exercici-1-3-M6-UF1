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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.URL;
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
    public void copiarFitxersBuffersComprimit(File fitxerLlegir, File fitxerEscriure) throws FileNotFoundException, IOException {

        BufferedReader lector = new BufferedReader(new FileReader(fitxerLlegir));

        GZIPOutputStream gzip = new GZIPOutputStream(new FileOutputStream(fitxerEscriure));

        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(gzip));

        String linea;

        while ((linea = lector.readLine()) != null) {

            escritor.write(linea);

            escritor.flush();
        }
    }

    /**
     * Metode que rep una cadena de ext y un fitxer i busca a dintre si hi ha
     * escrit el que hi ha a la cadena.
     *
     * @param cadena
     * @param fitxer
     */
    public boolean CercarCadenaText(String cadena, File fitxer) throws IOException {

        BufferedReader lector = new BufferedReader(new FileReader(fitxerLlegir));

        String linea;

        while ((linea = lector.readLine()) != null) {

            if (linea.equals(cadena)) {
                return true;

            }
        }
        return false;

    }

    /**
     * Metode que rep una URL i un File i escriu en el File el contingut de la
     * URL.
     *
     * @param url
     * @param fitxer
     * @throws Exception
     */
    public void descarregarURL(String url, File fitxer) throws Exception {

        URL direccio = new URL(url);
        InputStream inputStream = direccio.openStream();
        OutputStream outputStream = new FileOutputStream(fitxer);

        byte[] dades = new byte[2048];
        int longitud;

        while ((longitud = inputStream.read(dades)) != -1) {
            outputStream.write(dades, 0, longitud);
        }

        inputStream.close();
        outputStream.close();

    }

}
