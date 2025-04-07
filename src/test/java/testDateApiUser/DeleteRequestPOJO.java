package testDateApiUser;

public class DeleteRequestPOJO {

    private String token;

    public DeleteRequestPOJO() {
    }
    public DeleteRequestPOJO(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
