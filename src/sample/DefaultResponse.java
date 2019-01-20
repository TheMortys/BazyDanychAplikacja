package sample;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    @SerializedName("success")
    private int success;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
