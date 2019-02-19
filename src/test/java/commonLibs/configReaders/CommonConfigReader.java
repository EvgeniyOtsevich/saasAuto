package commonLibs.configReaders;

import java.io.IOException;

public class CommonConfigReader extends ConfigReader{

    public CommonConfigReader(String pathFile) throws IOException {
        super(pathFile);
    }

    public String getHealthCarePath() {
        return getProperties("healthCarePath");
    }

    public String getContactsPath() {
        return getProperties("contacts");
    }
}
