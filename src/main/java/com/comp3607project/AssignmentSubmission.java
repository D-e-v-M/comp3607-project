package com.comp3607project;

import java.time.LocalDate;

//Class for storing submission data
//Need to figure out how to upload files from file explorer to resource directory

public class AssignmentSubmission {
    private int submissionID;
    private Student student;
    private LocalDate submissionDate;
    private boolean isPlagiarized;
    private int assignmentType;
    private String comment;

    public AssignmentSubmission(Student student, int assignmentType) {
        this.student = student;
        this.assignmentType = assignmentType;
        this.comment = "";
    }
}
