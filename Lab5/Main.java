package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        //app.test1(); // un simplu tst
        app.testCreateSave();
        app.testLoadView();

    }

    public void test1() { //o simpla metoda pentru a testa daca merge URI


        try {
            URI uri = new URI("https://www.google.com/");
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException e) {
            System.out.println("potato");

        } catch (IOException e1) {
            //
        } finally {
            System.out.println("worked?");
        }
    }

    private void testCreateSave() {
        Catalog catalog =
                new Catalog("Java Resources", "e:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.addDocument(doc);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException e2) {
            System.out.println(e2);
        }

    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("e:/java/catalog.ser");
            //System.out.println(catalog);
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);
        } catch (InvalidCatalogException e) {
            System.out.println(e);
        }

    }

}
