package com.comp3607project;

//Class for storing submission data
//Need to figure out how to upload files from file explorer to resource directory

public class AssignmentResults {
    private int submissionID;
    private int assignmentType;
    private String comment;
    private int mark;

    private static int idCounter = 1;

    public AssignmentResults(int assignmentType) {
        this.submissionID = idCounter;
        this.assignmentType = assignmentType;
        this.comment = "";
    }

    public int getType() {
        return assignmentType;
    }

    public int getSubmissionID() {
        return submissionID;
    }

    public String getComment() {
        return comment;
    }

    public int getMark() {
        return mark;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String toString() {
        return "Submission ID: " + submissionID
                + "\nAssignment Type: " + assignmentType
                + "\nMark: " + mark
                + "\nComment: " + comment;
    }
}
