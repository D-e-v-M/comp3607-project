package com.comp3607project;

import java.time.LocalDateTime;
import java.time.Month;

public class Assignment3 extends Assignment {

    public Assignment3() {
        super();
        this.dueDate = LocalDateTime.of(2024, Month.APRIL, 14, 23, 59);
    }

    protected int gradeAssignment(AssignmentSubmission submission) {
        // Code to grade assignment

        return 0;
    }
}
