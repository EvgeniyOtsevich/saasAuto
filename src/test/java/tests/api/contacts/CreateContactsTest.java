package tests.api.contacts;

import commonLibs.utils.Logger.LogListener;
import contactsPOJO.request.ContactBody;
import contactsPOJO.response.ContactResponse;
import io.qameta.allure.Issue;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.api.*;

import java.io.IOException;

import static contactsPOJO.request.ContactBody.States.FULL;
import static contactsPOJO.request.ContactBody.States.NAMES_ONLY;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners(LogListener.class)
public class CreateContactsTest extends ContactsBaseTest {

    private long contactId;

    public CreateContactsTest() throws IOException {
    }

    @Test(description = "Test POST contacts endpoint.")
    public void createValidContactTest() {
        ContactBody contactBody = new ContactBody(FULL);
        ContactResponse contactsResponse = contactsAPI.createContact(contactBody);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
        assertThat(contactsResponse.getEmail()).isEqualTo(contactBody.getEmail());
        contactId = contactsResponse.getId();
    }

   @Issue("1")
   @Test(description = "Test POST contacts with empty email.")
   public void createContactWithoutEmailTest() {
       ContactBody contactBody = new ContactBody(NAMES_ONLY);
          ContactResponse contactsResponse = contactsAPI.createContact(contactBody);
          assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    @AfterClass
    public void deleteTestContact(){
        ContactResponse contactsResponse = contactsAPI.deleteContactsById(contactId);
        assertThat(contactsResponse.getStatus()).isEqualTo(HttpStatus.SC_OK);
    }
}
