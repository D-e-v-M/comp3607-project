package com.comp3607project;

import java.time.LocalDateTime;
import java.time.Month;

public class Assignment2 extends Assignment {

    public Assignment2() {
        super();
        this.dueDate = LocalDateTime.of(2024, Month.MARCH, 17, 23, 59);
    }

    protected int gradeAssignment(AssignmentSubmission submission) {
        // Code to grade assignment

        return 0;
    }
}
