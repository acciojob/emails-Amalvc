package com.driver;

import java.util.Date;

public class Email {

    private String emailId;
    private String password;
    private String currentPassword;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }


    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }


    public void changePassword(String oldPassword, String newPassword){
        String s=this.getPassword();
        if(s.equals(oldPassword)){
            int n=newPassword.length();
            boolean d=false;
            boolean u=false;
            boolean l=false;
            boolean sp=false;
           for(int i=0;i<n;i++){
               char ch=newPassword.charAt(i);
               if(Character.isDigit(ch)){
                   d=true;
               }
               if(Character.isUpperCase(ch)){
                   u=true;
               }
               if(Character.isLowerCase(ch)){
                   l=true;
               }
               if(!Character.isDigit(ch) && !Character.isLetter(ch)){
                   sp=true;
               }
           }
           if(n>=8 && d==true && u==true && l==true && sp==true){
               this.password=newPassword;
           }
           else{
                System.out.println("password not met the criteria");
           }

        }
        else{
            System.out.println("wrong password");

        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
