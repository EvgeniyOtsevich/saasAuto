package tests.api;

import commonLibs.api.HealthCheckAPI;
import org.testng.annotations.Test;

import java.io.IOException;

public class HealthCheckTest extends BaseTest{

    public HealthCheckTest(){
    }

    @Test(description = "Test GET healthCheck endpoint.")
    public void getHealthCheckTest() throws IOException {
        HealthCheckAPI healthCheckAPI = new HealthCheckAPI();
        String healthCheckResponse = healthCheckAPI.getHealthCheck();
        assert healthCheckResponse.equalsIgnoreCase("live");
    }

    @Test(description = "Test not allowed POST healthCheck endpoint.")
    public void postTestHealthCheckTest() throws IOException {
        HealthCheckAPI healthCheckAPI = new HealthCheckAPI();
        String healthCheckResponse = healthCheckAPI.postHealthCheck();
        assert healthCheckResponse.isEmpty();
    }
}
