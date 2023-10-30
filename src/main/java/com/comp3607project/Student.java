package com.comp3607project;

import java.util.ArrayList;

public class Student extends User {

    private ArrayList<AssignmentSubmission> submissions;

    public Student(String name, String email, String password) {
        super(name, email, password);
        this.submissions = new ArrayList<>();
    }

    public void submitAssignment(String filename) {
        // Code to submit assignment
    }

}
