package com.example.mchp.api;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    @SerializedName("site")
    private String site;
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("link")
    private String link;
    @SerializedName("elementPureHTML")
    private String elementPureHTLM;

    public String getSite() {
        return site;
    }

    public String getElementPureHTLM() {
        return elementPureHTLM;
    }
}
