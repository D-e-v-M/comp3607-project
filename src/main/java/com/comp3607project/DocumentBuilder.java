package com.comp3607project;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

public interface DocumentBuilder {
    public void createDocument() throws FileNotFoundException, DocumentException;
}
