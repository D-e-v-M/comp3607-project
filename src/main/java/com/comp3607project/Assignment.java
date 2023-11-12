package com.comp3607project;

import java.time.LocalDateTime;

//Superclass for storing general assignment data
//Heavy work needs to be done on this class. I just submitted what I had for now

public abstract class Assignment {
    protected int id;
    protected LocalDateTime dueDate;

    private static int idCounter = 0;

    public Assignment() {
        this.id = idCounter;

        idCounter++;
    }

    protected abstract int gradeAssignment(AssignmentResults submission);

    public void beginGrading(AssignmentResults submission) {
        Assignment a = chooseAssignmentType(submission);
        a.gradeAssignment(submission);
    }

    public Assignment chooseAssignmentType(AssignmentResults submission) {
        Assignment a;

        switch (submission.getType()) {
            case 1:
                a = new Assignment1();
                break;

            case 2:
                a = new Assignment2();
                break;

            case 3:
                a = new Assignment3();
                break;

            default:
                a = new Assignment1();
        }

        return a;
    }

}
