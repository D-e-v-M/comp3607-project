package com.comp3607project;

import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class JavaFileParser {
    
    private String code;

    public JavaFileParser(String fileCode){
        code = fileCode;
    }

    public void parse(){
        
        CompilationUnit cu = StaticJavaParser.parse(this.code);
        
        // Extract attribute declarations (to screen atm)
        List<FieldDeclaration> fieldDeclarations = cu.findAll(FieldDeclaration.class);
        for (FieldDeclaration fieldDeclaration : fieldDeclarations) {
            System.out.println("Attribute: " + fieldDeclaration.getVariable(0).getTypeAsString() + " " + fieldDeclaration.getVariable(0).getNameAsString());
        }

        // Extract method declarations (to screen atm)
        List<MethodDeclaration> methodDeclarations = cu.findAll(MethodDeclaration.class);
        for (MethodDeclaration methodDeclaration : methodDeclarations) {
            System.out.println("Method: " + methodDeclaration.getDeclarationAsString());
        }
    }
    // Need to add a getAttributes and getMethods functions
    
    
    /*
     * The idea for this class is that receives a string form of the class it has to
     * parse and returns the attributes and methods. it can be called in the Unzip class
     * to parse the java files as they're being read (as strings cause its faster)
     * 
     * 
     * 
     * For testing, the test classes can extend this or something to have their own
     * tests. 
     */
}
