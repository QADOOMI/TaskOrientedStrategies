package com.example.mostafa.task_orientedstrategies;

/**
 * Created by Mostafa on 4/21/2018.
 */

public class User {
    private String firstName , lastName;
    private static int userID;
    private String email;
    private String password;
    private String message;

    public User(){}

    public User(String firstName , String lastName , String email , String password ){
        setUser_id();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }


    public int getUser_id() {
        return userID;
    }

    public void setUser_id() {
        userID++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() > 13)
            message = "PLEASE YOUR FIRST NAME HAVE TO BE LESS THAN 13";
        else if(firstName.length() < 3)
            message = "PLEASE YOUR FIRST NAME HAVE TO BE GREATER THAN 2";
        else
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() > 13)
            message = "PLEASE YOUR LAST NAME HAVE TO BE LESS THAN 13";
        else if(lastName.length() < 3)
            message = "PLEASE YOUR LAST NAME HAVE TO BE GREATER THAN 2";
        else
            this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.length() > 25)
            message = "CHOOSE ANOTHER EMAIL THIS ONE NOT VALID";
        else
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        //Pattern p = Pattern.compile("\\w{5,10}\\s?\\d{2,5}" , Pattern.CASE_INSENSITIVE);
        //Matcher m = p.matcher(password);
        boolean isMatch = (password.matches("[a-zA-Z]{5,10}\\s?\\d{2,5}"));


        if(isMatch)
            this.password = password;
        else
            message = "YOUR PASSWORD HAVE TO BEGIN WITH FIVE TO TEN LETTERS MAYBE ONE WHITE SPACE AND TWO TO FIVE DIGIT NUMBER";
    }
}
