package com.unix.filimo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("banner_name")
    @Expose
    String banner_name;
    @SerializedName("banner_image")
    @Expose
    String banner_image;
    @SerializedName("banner_image_thumb")
    @Expose
    String banner_image_thumb;
    @SerializedName("banner_url")
    @Expose
    String banner_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String banner_name) {
        this.banner_name = banner_name;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getBanner_image_thumb() {
        return banner_image_thumb;
    }

    public void setBanner_image_thumb(String banner_image_thumb) {
        this.banner_image_thumb = banner_image_thumb;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }


}
