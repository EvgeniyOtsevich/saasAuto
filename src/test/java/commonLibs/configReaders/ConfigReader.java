package commonLibs.configReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class ConfigReader {

    private Properties properties = new Properties();

    ConfigReader(String filePath) throws IOException {
        properties.load(new FileInputStream(filePath));
    }

    String getProperties(String path) {
        return properties.getProperty(path);
    }

}
