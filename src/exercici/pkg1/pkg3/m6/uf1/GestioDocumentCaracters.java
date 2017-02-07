package exercici.pkg1.pkg3.m6.uf1;

import static java.io.FileDescriptor.in;
import static java.io.FileDescriptor.out;
import java.io.FileReader;
import java.io.FileWriter;

public class GestioDocumentCaracters {

    String ruta1 = "C:\\proves\\Execici3-1";
    String ruta2 = "C:\\proves\\Execici3-2";

    FileReader in = new Filereader(ruta1);
    FileWriter out = new FileWriter(ruta2);

    copiaDades(in, out);

    public void copiaDades(FileReader in, FileWriter out) {
        try {
            Char[] dades = new char[100];
            int llegits = 0;
            while (-1 != (llegits = in.read(dades))) {
                out.write(dades, 0, llegits);
            }
            out.close();
            in.close();
        } catch (IOException ex) {...
        }
    }
}
