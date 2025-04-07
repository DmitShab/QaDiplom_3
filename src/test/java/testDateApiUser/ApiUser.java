package testDateApiUser;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import seleniumTests.SingUpTest;
import testDateApiUser.postLoginResponse.FullBody;

import static io.restassured.RestAssured.given;

public class ApiUser {
    Response response;

    @Step("Создание пользователя")
    public void signUp(PostRequestSignUPPOJO postRequestSignUPPOJO) {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        response = given()
                .header("Content-type", "application/json")
                .relaxedHTTPSValidation()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .filter(new ErrorLoggingFilter())
                .body(postRequestSignUPPOJO)
                .when()
                .post("/api/auth/register");
    }

    @Step("Удаление пользователя")
    public void deleteUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        String token = response.getHeader("Authorization");
        DeleteRequestPOJO deleteRequestPOJO = new DeleteRequestPOJO(token);
        given()
                .header("Content-type", "application/json")
                .relaxedHTTPSValidation()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .filter(new ErrorLoggingFilter())
                .header("Authorization", token)
                .body(deleteRequestPOJO)
                .when()
                .delete("/api/auth/user");
    }

    @Step("Авторизация созданного через UI пользователя")
    public String logInUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        PostLogInPOJO body = new PostLogInPOJO(SingUpTest.email, SingUpTest.password);
        response = given()
                .header("Content-type", "application/json")
                .relaxedHTTPSValidation()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .filter(new ErrorLoggingFilter())
                .body(body)
                .when()
                .post("/api/auth/login");
        if (response.getStatusCode() == 200) {
            FullBody fullBody = response.as(FullBody.class);
            return fullBody.getAccessToken();
        } else {
            System.err.println("Login failed: " + response.getBody().asString());
            return null;
        }
    }

    @Step("Удаление созданного через UI пользователя")
    public Boolean deleteUiUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        String token = logInUser();
        DeleteRequestPOJO deleteRequestPOJO = new DeleteRequestPOJO(token);
        if (token != null) {
            response = given()
                    .header("Content-type", "application/json")
                    .relaxedHTTPSValidation()
                    .filter(new RequestLoggingFilter())
                    .filter(new ResponseLoggingFilter())
                    .filter(new ErrorLoggingFilter())
                    .header("Authorization", token)
                    .body(deleteRequestPOJO)
                    .when()
                    .delete("/api/auth/user");
            return true;
        } else {
            System.err.println("There is no user to delete");
            return false;
        }

    }
}