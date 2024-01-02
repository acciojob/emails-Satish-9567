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
        if(this.oldPassword.compareTo(oldPassword)==0){
            if(isValid(newPassword)){
                this.oldPassword=newPassword;
            }
        }
    }
    public boolean isValid(String str){
        if(str.length()<8)
            return false;
        boolean c1=false,c2=false,c3=false,c4=false;
        for(char ch:str.toCharArray()){
            if(ch>='A'&&ch<='Z'){
                c1=true;
            }else if(ch>='a'&&ch<='z'){
                c2=true;
            }
            else if(ch>='0'&&ch<='9'){
                c3=true;
            }else{
                c4=true;
            }
        }
        if(c1&&c2&&c3&&c4)
            return true;
        return false;
    }
}
