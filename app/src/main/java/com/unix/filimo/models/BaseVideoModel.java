package com.unix.filimo.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseVideoModel {


    @SerializedName("ALL_IN_ONE_VIDEO")
    @Expose
    private List<Video> videoListList = null;


    public List<Video> getVideoListList() {
        return videoListList;
    }

    public void setVideoListList(List<Video> videoListList) {
        this.videoListList = videoListList;
    }


}
