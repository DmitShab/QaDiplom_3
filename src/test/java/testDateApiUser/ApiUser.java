package testDateApiUser;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

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
}