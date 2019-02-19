
package contactsPOJO.response;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Refs {

    @SerializedName("delete")
    private String mDelete;
    @SerializedName("get")
    private String mGet;
    @SerializedName("patch")
    private String mPatch;
    @SerializedName("put")
    private String mPut;

    public String getDelete() {
        return mDelete;
    }

    public void setDelete(String delete) {
        mDelete = delete;
    }

    public String getGet() {
        return mGet;
    }

    public void setGet(String get) {
        mGet = get;
    }

    public String getPatch() {
        return mPatch;
    }

    public void setPatch(String patch) {
        mPatch = patch;
    }

    public String getPut() {
        return mPut;
    }

    public void setPut(String put) {
        mPut = put;
    }

}
