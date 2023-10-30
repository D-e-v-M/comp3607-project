package com.comp3607project;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public abstract class User {
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    private static int idCounter = 0;

    public User(String name, String email, String password) {
        this.id = idCounter;
        this.name = name;
        this.email = email;
        this.password = encryptPassword(password);

        idCounter++;
    }

    protected boolean login(String email, String password) {
        if (this.email.equals(email) && checkPassword(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }

    private String encryptPassword(String password) {

        String encryptedpassword = "";

        try {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /*
             * The bytes array has bytes in decimal form. Converting it into hexadecimal
             * format.
             */
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();

            return encryptedpassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encryptedpassword;
    }

    private boolean checkPassword(String password) {
        String encryptedPassword;

        try {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /*
             * The bytes array has bytes in decimal form. Converting it into hexadecimal
             * format.
             */
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedPassword = s.toString();

            if (encryptedPassword.equals(this.password))
                return true;
            else
                return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }

}
