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
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(LogListener.class)
public class GetContactsTest extends ContactsBaseTest {

    public GetContactsTest() throws IOException {
    }

    private ContactResponse testContact;

    @BeforeClass
    public void generateTestContact(){
        ContactBody contactBody = new ContactBody(FULL);
        testContact = contactsAPI.createContact(contactBody);
        assertThat(testContact.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(testContact.getEmail()).isEqualTo(contactBody.getEmail());
    }

    @Test(description = "Test GET contacts by ID endpoint.")
    public void getContactsByIdTest() {
        ContactResponse contactsResponse = contactsAPI.getContactsById(testContact.getId());
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getId()).isEqualTo(testContact.getId());
    }

    @Test(description = "Test GET contacts by First name and Email endpoint.", groups = "/contacts")
    public void getContactsByFirstNameAndEmailTest() {
        ContactResponse contactsResponse = contactsAPI.getContactsByEmailAndFirstName(testContact.getEmail(),testContact.getFirstName());
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getEmail()).isEqualTo(testContact.getEmail());
        assertThat(contactsResponse.getFirstName()).isEqualTo(testContact.getFirstName());
    }

    @Test(description = "Test GET contacts by First name and empty Email endpoint.")
    public void getContactsByEmptyEmailTest() {
        ContactResponse contactsResponse = contactsAPI.getContactsByEmailAndFirstName("",testContact.getFirstName());
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getData()).isEmpty();
    }

    @Test(description = "Test GET all contacts endpoint.")
    public void getAllContactsTest() {
        ContactResponse contactsResponse = contactsAPI.getAllContacts();
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getData().size()).isGreaterThan(0);
    }

    @AfterClass
    public void deleteTestContact(){
        ContactResponse contactsResponse = contactsAPI.deleteContactsById(testContact.getId());
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getEmail()).isEqualTo(testContact.getEmail());
    }
}
