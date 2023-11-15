package com.comp3607project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.stream.Stream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator implements DocumentBuilder {

    private String[] testCases;
    private String[] passStatus;
    private String[] feedback;

    private ArrayList<String> testCasesList;
    private ArrayList<String> passStatusList;
    private ArrayList<String> feedbackList;

    // main needs this
    PDFGenerator() {
        testCasesList = new ArrayList<>();
        passStatusList = new ArrayList<>();
        feedbackList = new ArrayList<>();
    }

    public void addTestCases(ArrayList<String> testCases) {
        testCasesList.addAll(testCases);
    }

    public void addPassStatus(ArrayList<String> passStatus) {
        passStatusList.addAll(passStatus);
    }

    public void addFeedback(ArrayList<String> feedback) {
        feedbackList.addAll(feedback);
    }

    public void createDocument() throws FileNotFoundException, DocumentException {
        makePrimitiveArrays(testCasesList, passStatusList, feedbackList);
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf")); // Still have to pass the
                                                                                      // student's ID

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph("Test Cases", font);
        paragraph.setSpacingAfter(50);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        PdfPTable table = new PdfPTable(new float[] { 4, 3, 10 });
        addTableHeader(table);
        addRows(table, testCases, passStatus, feedback);

        document.add(paragraph);
        document.add(table);
        document.close();
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Test Case", "Status", "Feedback")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    header.setPadding(5);
                    header.setRowspan(5); // Idk if this actually does anything
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, String[] testCases, String[] passStatus, String[] feedback) {

        // Filler content to be replaced later
        for (int i = 0; i < testCases.length; i++) {
            table.addCell(testCases[i]);
            table.addCell(passStatus[i]);
            table.addCell(feedback[i]);
        }

        // Leaving this code for now just in case
        // table.addCell("row 1, col 1");
        // table.addCell("row 1, col 2");
        // table.addCell("row 1, col 3");

        // PdfPCell horilAlignCell = new PdfPCell(new Phrase("row 2, col 1"));
        // horilAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        // table.addCell(horilAlignCell);

        // PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
        // horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        // table.addCell(horizontalAlignCell);

        // PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
        // verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        // table.addCell(verticalAlignCell);
    }

    private void makePrimitiveArrays(ArrayList<String> testCasesList, ArrayList<String> passStatusList,
            ArrayList<String> feedbackList) {
        testCases = testCasesList.toArray(new String[0]);
        passStatus = passStatusList.toArray(new String[0]);
        feedback = feedbackList.toArray(new String[0]);
    }

}
