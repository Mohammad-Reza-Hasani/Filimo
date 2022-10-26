package com.unix.filimo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModel {



    @SerializedName("ALL_IN_ONE_VIDEO")
    @Expose
    private List<Banner> bannerList = null;


    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }
}
