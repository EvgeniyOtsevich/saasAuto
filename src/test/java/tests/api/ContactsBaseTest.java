package tests.api;

import commonLibs.api.ContactsAPI;
import contactsPOJO.request.ContactBody;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class ContactsBaseTest extends ContactsAPI {

    protected ContactsAPI contactsAPI;

    protected ContactsBaseTest() throws IOException {
    }

    @BeforeClass
    public void setUp() throws IOException {
        contactsAPI = new ContactsAPI();
    }
}
