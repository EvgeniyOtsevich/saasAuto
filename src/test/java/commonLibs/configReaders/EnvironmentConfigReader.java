package commonLibs.configReaders;

import java.io.IOException;

public class EnvironmentConfigReader extends ConfigReader{

    public EnvironmentConfigReader(String filePath) throws IOException {
        super(filePath);
    }

    public String getBaseUrl() {
        return getProperties("BaseUrl");
    }

    public int getBasePort() {
        return Integer.parseInt(getProperties("BasePort"));
    }
}
