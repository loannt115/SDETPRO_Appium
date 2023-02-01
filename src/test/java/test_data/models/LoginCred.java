package test_data.models;

public class LoginCred {
    String email;
    String password;

    public LoginCred(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCred{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
