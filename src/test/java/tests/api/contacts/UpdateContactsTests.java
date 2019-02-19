package tests.api.contacts;

import commonLibs.utils.Logger.LogListener;
import contactsPOJO.request.ContactBody;
import contactsPOJO.response.ContactResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.api.ContactsBaseTest;

import java.io.IOException;

import static contactsPOJO.request.ContactBody.States.FULL;
import static contactsPOJO.request.ContactBody.States.NAMES_ONLY;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(LogListener.class)
public class UpdateContactsTests extends ContactsBaseTest {

    public UpdateContactsTests() throws IOException {
    }

    private ContactResponse testContact;

    @BeforeClass
    public void generateTestContact(){
        ContactBody contactBody = new ContactBody(FULL);
        testContact = contactsAPI.createContact(contactBody);
        assertThat(testContact.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(testContact.getEmail()).isEqualTo(contactBody.getEmail());
    }

    @Test(description = "Test PUT contacts endpoint.")
    public void updateContactTest() {
        ContactBody contactBody = new ContactBody(FULL);
        ContactResponse contactsResponse = contactsAPI.updateContact(testContact.getId(), contactBody);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getEmail()).isEqualTo(contactBody.getEmail());
        assertThat(contactsResponse.getFirstName()).isEqualTo(contactBody.getFirstName());
        assertThat(contactsResponse.getLastName()).isEqualTo(contactBody.getLastName());
    }

    @Test(description = "Test PATCH contacts endpoint.")
    public void partialUpdateContactTest() {
        ContactBody contactBody = new ContactBody(NAMES_ONLY);
        ContactResponse contactsResponse = contactsAPI.partialUpdateContact(testContact.getId(), contactBody);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getFirstName()).isEqualTo(contactBody.getFirstName());
        assertThat(contactsResponse.getLastName()).isEqualTo(contactBody.getLastName());
    }

    @AfterClass
    public void deleteTestContact(){
        ContactResponse contactsResponse = contactsAPI.deleteContactsById(testContact.getId());
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
    }

}
