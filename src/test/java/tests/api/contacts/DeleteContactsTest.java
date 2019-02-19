package tests.api.contacts;

import commonLibs.utils.Logger.LogListener;
import contactsPOJO.request.ContactBody;
import contactsPOJO.response.ContactResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.api.ContactsBaseTest;

import java.io.IOException;

import static contactsPOJO.request.ContactBody.States.FULL;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(LogListener.class)
public class DeleteContactsTest extends ContactsBaseTest {

    public DeleteContactsTest() throws IOException {
    }

    private Long contactId;

    @BeforeClass
    public void generateContact(){
        ContactBody contactBody = new ContactBody(FULL);
        ContactResponse contactsResponse = contactsAPI.createContact(contactBody);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getEmail()).isEqualTo(contactBody.getEmail());
        contactId = contactsResponse.getId();
    }

    @Test(description = "Test DELETE contacts by ID endpoint.")
    public void deleteContactsByIdTest() {
        ContactResponse contactsResponse = contactsAPI.deleteContactsById(contactId);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getId()).isEqualTo(contactId);
    }

}
