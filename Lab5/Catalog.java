package com.company;

import java.io.*;
import java.util.ArrayList;

import java.util.List;


public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> documentList = new ArrayList<>();

    public void addDocument(Document doc) {
        documentList.add(doc);

    }

    public Document findById(String id) {
        for (Document doc : documentList) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override //folosit pentru *debuging* intrucat nu se salva catalogul la apelul functiei testCreateSave
    public String toString() {
        return path;
    }
}
