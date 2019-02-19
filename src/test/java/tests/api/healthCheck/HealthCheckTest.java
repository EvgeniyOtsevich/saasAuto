package tests.api.healthCheck;

import commonLibs.api.HealthCheckAPI;
import commonLibs.utils.Logger.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(LogListener.class)
public class HealthCheckTest {

    @Test(description = "Test GET healthCheck endpoint.")
    public void getHealthCheckTest() throws IOException {
        HealthCheckAPI healthCheckAPI = new HealthCheckAPI();
        String healthCheckResponse = healthCheckAPI.getHealthCheck();
        assertThat(healthCheckResponse).isEqualToIgnoringCase("live");
    }

    @Test(description = "Test not allowed POST healthCheck endpoint.")
    public void postTestHealthCheckTest() throws IOException {
        HealthCheckAPI healthCheckAPI = new HealthCheckAPI();
        String healthCheckResponse = healthCheckAPI.postHealthCheck();
        assertThat(healthCheckResponse).isEmpty();
    }
}
