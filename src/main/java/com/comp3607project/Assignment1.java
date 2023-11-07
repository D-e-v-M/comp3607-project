package com.comp3607project;

import java.time.LocalDateTime;
import java.time.Month;

public class Assignment1 extends Assignment {

    public Assignment1() {
        super();
        this.dueDate = LocalDateTime.of(2024, Month.FEBRUARY, 10, 23, 59);
    }

    protected int gradeAssignment(AssignmentResults submission) {
        // Code to grade assignment

        return 0;
    }
}
