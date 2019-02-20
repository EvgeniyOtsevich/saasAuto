package commonLibs.api;

import contactsPOJO.request.ContactBody;
import contactsPOJO.response.ContactResponse;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ContactsAPI extends BaseApi {

    public ContactsAPI() throws IOException {
    }

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(environmentConfig.getBaseUrl())
            .setPort(environmentConfig.getBasePort())
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Step("Get all contact")
    public ContactResponse getAllContacts() {
        return given().spec(requestSpec)
                .when().get(commonConfig.getContactsPath())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(ContactResponse.class);
    }

    @Step("Get Contact with ID = {0}")
    public ContactResponse getContactsById(long contactId) {
        return given().spec(requestSpec)
                .when().get(commonConfig.getContactsPath()+"/"+contactId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(ContactResponse.class);
    }

    @Step("Get nonexistent Contact with ID = {0}")
    public ResponseBody getNonexistentContactsById(long contactId) {
        return given().spec(requestSpec)
                .when().get(commonConfig.getContactsPath()+"/"+contactId)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract().response().getBody();
    }

    @Step("Get Contact with First name - {1} and email: {0}")
    public ContactResponse getContactsByEmailAndFirstName(String email, String firstName) {
        return given().spec(requestSpec)
                .queryParam("firstName",firstName)
                .queryParam("email",email)
                .when().get(commonConfig.getContactsPath())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(ContactResponse.class);
    }

    @Step("Create contact")
    public ContactResponse createContact(ContactBody contactBody) {
        return given().spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(contactBody)
                .when().post(commonConfig.getContactsPath())
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response()
                .as(ContactResponse.class);
    }

    @Step("Update contact with id: {0}")
    public ContactResponse updateContact(long id, ContactBody contactBody) {
        return given().spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(contactBody)
                .when().put(commonConfig.getContactsPath()+"/"+id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(ContactResponse.class);
    }

    @Step("Partial update contact with id: {0}")
    public ContactResponse partialUpdateContact(long id, ContactBody contactBody) {
        return given().spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(contactBody)
                .when().patch(commonConfig.getContactsPath()+"/"+id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(ContactResponse.class);
    }

    @Step("Delete Contact with ID = {0}")
    public ContactResponse deleteContactsById(Long contactId) {
        return given().spec(requestSpec)
                .when().delete(commonConfig.getContactsPath()+"/"+contactId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(ContactResponse.class);
    }
}
