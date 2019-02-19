
package contactsPOJO.response;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Datum {

    @SerializedName("id")
    private Long mId;
    @SerializedName("info")
    private Info mInfo;
    @SerializedName("refs")
    private Refs mRefs;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Info getInfo() {
        return mInfo;
    }

    public void setInfo(Info info) {
        mInfo = info;
    }

    public Refs getRefs() {
        return mRefs;
    }

    public void setRefs(Refs refs) {
        mRefs = refs;
    }

}
