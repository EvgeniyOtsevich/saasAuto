package tests.api.contacts;

import contactsPOJO.request.ContactBody;
import contactsPOJO.response.ContactResponse;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import tests.api.ContactsBaseTest;

import java.io.IOException;

import static contactsPOJO.request.ContactBody.States.FULL;
import static org.assertj.core.api.Assertions.assertThat;

public class ServiceBaseTests extends ContactsBaseTest {
    protected ServiceBaseTests() throws IOException {
    }

    @Test(description = "Verify contacts list endpoint is returning updated information.")
    public void updateContactList(){
        ContactResponse contactsResponse = contactsAPI.getAllContacts();
        int contactsSize = contactsResponse.getData().size();
        long contactId = contactsResponse.getId();

        ContactBody contactBody = new ContactBody(FULL);
        contactsResponse = contactsAPI.createContact(contactBody);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getEmail()).isEqualTo(contactBody.getEmail());

        contactsResponse = contactsAPI.getAllContacts();
        assertThat(contactsResponse.getData().size()).isEqualTo(++contactsSize);

        contactsResponse = contactsAPI.deleteContactsById(contactId);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getId()).isEqualTo(contactId);

        contactsResponse = contactsAPI.getAllContacts();
        assertThat(contactsResponse.getData().size()).isEqualTo(--contactsSize);

    }

    @Test(description = "Verify contact creating, obtaining and delete flow.")
    public void contactFLowTest(){
        ContactBody contactBody = new ContactBody(FULL);
        ContactResponse createdContact = contactsAPI.createContact(contactBody);
        assertThat(createdContact.getStatus()).isEqualTo(HttpStatus.SC_OK);

        ContactResponse getContact = contactsAPI.getContactsById(createdContact.getId());
        assertThat(getContact.getId()).isEqualTo(createdContact.getId());
        assertThat(getContact.getFirstName()).isEqualTo(createdContact.getFirstName());
        assertThat(getContact.getLastName()).isEqualTo(createdContact.getLastName());

        ContactResponse contactsResponse = contactsAPI.deleteContactsById(createdContact.getId());
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);

        ResponseBody getDeletedContact = contactsAPI.getNonexistentContactsById(createdContact.getId());
        assertThat(getDeletedContact.asString()).isEmpty();



    }
}
