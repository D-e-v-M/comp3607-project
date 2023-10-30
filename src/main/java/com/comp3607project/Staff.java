package com.comp3607project;

public class Staff extends User {

    public Staff(String name, String email, String password) {
        super(name, email, password);
    }

    public void reviewSubmission(AssignmentSubmission submission) {
        // Code for reviewing submission
    }

    public void changeMark(AssignmentSubmission submission) {
        // Code for changing submission mark
    }

    public void makeComment(String comment) {
        // Code to add comment to submission
    }
}
