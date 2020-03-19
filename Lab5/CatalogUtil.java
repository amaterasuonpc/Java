package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) { //serializarea
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException {
        Catalog catalog;
        try (var ois = new ObjectInputStream(new FileInputStream(path))) { //deserializarea
            catalog = (Catalog) ois.readObject();
            return catalog;

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e1) {
            System.out.println(e1);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null; // in caz ca a fost aruncat o exceptie, catalogul va fi null
        //A nu se folosi in finally //
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop(); //se incearca mai intai cu tipul File
        File sd = new File(doc.getLocation());
        try {
            desktop.open(sd);

        } catch (IOException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {

            try {
                URI uri = new URI(doc.getLocation()); // daca nu este file si arunca o exceptie incercam cu uri
                desktop.browse(uri);                    // nu este cel mai elegant cod, dar merge
            } catch (URISyntaxException e2) {
                System.out.println(e2);
            } catch (IOException e3) {
                System.out.println(e3);
            }

        }
    }


}
