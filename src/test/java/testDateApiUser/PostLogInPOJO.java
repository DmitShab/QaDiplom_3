package testDateApiUser;

public class PostLogInPOJO {
    private String password;
    private String email;

    public PostLogInPOJO() {
    }

    public PostLogInPOJO(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
