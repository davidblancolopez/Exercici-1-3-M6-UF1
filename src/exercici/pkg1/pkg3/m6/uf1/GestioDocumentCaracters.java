package exercici.pkg1.pkg3.m6.uf1;

import static java.io.FileDescriptor.in;
import static java.io.FileDescriptor.out;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import static javax.management.Query.in;
import static sun.misc.MessageUtils.out;

public class GestioDocumentCaracters {

    String ruta1 = "C:\\proves\\Execici3-1";
    String ruta2 = "C:\\proves\\Execici3-2";

    /**
     * Metode per a la part 1.
     * Crea els 2 fitxers que s'utilitzaran per llegir i escriure.
     * Crida al metode copiaDades i li pasa els 2 fitxers.
     */
    public void copiarFitxersBuffers() {
        try {
            FileReader in = new FileReader(ruta1);
            FileWriter out = new FileWriter(ruta2);

            copiaDades(in, out);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void copiaDades(FileReader in, FileWriter out) {
        try {
            char[] dades = new char[100];

            int llegits = 0;
            while (-1 != (llegits = in.read(dades))) {
                out.write(dades, 0, llegits);
            }
            out.close();
            in.close();
        } catch (IOException ex) {

        }
    }
}
