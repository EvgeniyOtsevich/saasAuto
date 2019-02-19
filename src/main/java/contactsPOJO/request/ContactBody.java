
package contactsPOJO.request;

import javax.annotation.Generated;

import com.github.javafaker.Faker;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ContactBody {

    @Expose
    private String email;
    @Expose
    private String firstName;
    @Expose
    private String lastName;

    public enum States {
        FULL, EMAIL_ONLY, EMAIL_AND_NAME, NAMES_ONLY
    }

    Faker faker = new Faker();

    public ContactBody(String email, String firstName, String lastName){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ContactBody(States state){
        switch (state) {
            case FULL:
                this.firstName = makeRandomFirstName();
                this.email = makeRandomEmail();
                this.lastName = makeRandomLastName();
                break;
            case EMAIL_ONLY:
                this.email = makeRandomEmail();
                break;
            case EMAIL_AND_NAME:
                this.email = makeRandomEmail();
                this.firstName = makeRandomFirstName();
                break;
            case NAMES_ONLY:
                this.lastName = makeRandomLastName();
                this.firstName = makeRandomFirstName();
                break;
            default:
                this.firstName = makeRandomFirstName();
                this.email = makeRandomEmail();
                this.lastName = makeRandomLastName();
                break;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String makeRandomEmail() {
        return faker.name().username() + "@random.email";
    }

    public String makeRandomFirstName() {
        return faker.name().firstName();
    }

    public String makeRandomLastName() {
        return faker.name().lastName();
    }

}
