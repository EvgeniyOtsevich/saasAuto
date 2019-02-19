
package contactsPOJO.response;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ContactResponse {

    @Expose
    private List<Datum> data;
    @Expose
    private String message;
    @Expose
    private Long status;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getEmail(){ return data.get(0).getInfo().getEmail();}

    public String getFirstName(){ return data.get(0).getInfo().getFirstName();}

    public String getLastName(){ return data.get(0).getInfo().getLastName();}

    public Long getId() {return data.get(0).getId();}

}
