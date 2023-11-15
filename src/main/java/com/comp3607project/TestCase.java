package com.comp3607project;

public class TestCase {
    private String name;
    private boolean status;
    private String feedback;

    public TestCase(String name, boolean status, String feedback){

        this.name=name;
        this.status=status;
        this.feedback=feedback;

    }

    public String getName(){
        return name;
    }

    public boolean isPassed(){
        return status;
    }

    public String getFeedback(){
        return feedback;
    }
    
}
