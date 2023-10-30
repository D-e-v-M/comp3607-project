package com.comp3607project;

import java.time.LocalDate;

//Superclass for storing general assignment data
//Heavy work needs to be done on this class. I just submitted what I had for now

public abstract class Assignment {
    protected int id;
    protected int mark;
    protected LocalDate dueDate;

    private static int idCounter = 0;

    public Assignment(int mark) {
        this.id = idCounter;
        this.mark = mark;

        idCounter++;
    }
}
