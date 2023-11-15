package com.comp3607project;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public interface DocumentBuilder {
    public void createDocument() throws FileNotFoundException, DocumentException;

    public void addTestCases(ArrayList<String> testCases);

    public void addPassStatus(ArrayList<String> passStatus);

    public void addFeedback(ArrayList<String> feedback);
}
