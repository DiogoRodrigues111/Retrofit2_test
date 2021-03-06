package br.io.opensource.retrofit_test;

import com.google.gson.annotations.SerializedName;

public class API_GitHub {
    @SerializedName("id")
    private String id;
    @SerializedName("type")
    private String type;

    public API_GitHub(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}