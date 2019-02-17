package commonLibs.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class HealthCheckAPI extends BaseApi {

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(environmentConfig.getBaseUrl())
            .setPort(environmentConfig.getBasePort())
            .log(LogDetail.ALL)
            .build();

    public HealthCheckAPI() throws IOException {
    }


    public String getHealthCheck() {
        return given().spec(requestSpec)
                .when().get(commonConfig.getHealthCarePath())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .getBody().asString();
    }

    public String postHealthCheck() {
        return given().spec(requestSpec)
                .body("")
                .when().post(commonConfig.getHealthCarePath())
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                .extract().response()
                .getBody().asString();
    }


}
