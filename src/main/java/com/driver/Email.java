package com.driver;

public class Email {

    private String emailId;
    private String password;

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
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
       if (this.password.equals(oldPassword) && isValid(newPassword)) {
            this.password = newPassword;
        }
    }
    public boolean isValid(String str){
         if (str.length() < 8)
            return false;
        boolean containsUppercase = false, containsLowercase = false, containsDigit = false, containsSpecialChar = false;
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                containsLowercase = true;
            } else if (Character.isDigit(ch)) {
                containsDigit = true;
            } else {
                containsSpecialChar = true;
            }
        }
        return containsUppercase && containsLowercase && containsDigit && containsSpecialChar;
    }
}
