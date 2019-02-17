package commonLibs.api;

import commonLibs.configReaders.CommonConfigReader;
import commonLibs.configReaders.EnvironmentConfigReader;

import java.io.IOException;

class BaseApi {

    private String envName = System.getProperty("environment");
    CommonConfigReader commonConfig = new CommonConfigReader("src/config/Common.properties");
    EnvironmentConfigReader environmentConfig = new EnvironmentConfigReader("src/config/"+envName+"_env.properties");

    BaseApi() throws IOException {
    }
}
