package com.comp3607project;

//Class for storing submission data
//Need to figure out how to upload files from file explorer to resource directory

public class AssignmentSubmission {
    private int submissionID;
    private boolean isPlagiarized;
    private int assignmentType;
    private String comment;
    private int mark;

    private static int idCounter = 0;

    public AssignmentSubmission(int assignmentType) {
        this.submissionID = idCounter;
        this.assignmentType = assignmentType;
        this.comment = "";
    }

    public int getType() {
        return assignmentType;
    }
}
