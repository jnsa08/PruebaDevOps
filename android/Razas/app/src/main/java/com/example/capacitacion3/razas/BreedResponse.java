package com.example.capacitacion3.razas;

import com.google.gson.annotations.SerializedName;

/**
 * Created by capacitacion3 on 16-03-18.
 */

public class BreedResponse {

    @SerializedName("status")private String status;

    @SerializedName("message")private String[] message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
