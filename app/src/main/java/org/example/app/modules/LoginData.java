package org.example.app.modules;

/*Login Data object for the login information*/
public class LoginData {
    String email;
    String password;


    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}