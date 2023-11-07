package com.comp3607project;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Simple testing
        AssignmentResults submission = new AssignmentResults(1);
        submission.setMark(79);
        submission.setComment("Decent");

        // String s = submission.toString();
        // System.out.println(submission.toString());

        User dev = new User("Dev", "dev@gmail.com", "password");

        dev.reviewSubmission(submission);
    }
}