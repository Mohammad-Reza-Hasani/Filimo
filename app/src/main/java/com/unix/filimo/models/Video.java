package com.unix.filimo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {

    String id;
    String cat_id;
    String video_type;
    String video_title;
    String video_url;
    String video_id;
    String video_thumbnail_b;
    String video_thumbnail_s;
    String video_duration;
    String video_description;
    String rate_avg;
    String totel_viewer;
    String cid;
    String category_name;
    String category_image;
    String category_image_thumb;

    public Video(){}

    protected Video(Parcel in) {
        id = in.readString();
        cat_id = in.readString();
        video_type = in.readString();
        video_title = in.readString();
        video_url = in.readString();
        video_id = in.readString();
        video_thumbnail_b = in.readString();
        video_thumbnail_s = in.readString();
        video_duration = in.readString();
        video_description = in.readString();
        rate_avg = in.readString();
        totel_viewer = in.readString();
        cid = in.readString();
        category_name = in.readString();
        category_image = in.readString();
        category_image_thumb = in.readString();
    }


    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideo_thumbnail_b() {
        return video_thumbnail_b;
    }

    public void setVideo_thumbnail_b(String video_thumbnail_b) {
        this.video_thumbnail_b = video_thumbnail_b;
    }

    public String getVideo_thumbnail_s() {
        return video_thumbnail_s;
    }

    public void setVideo_thumbnail_s(String video_thumbnail_s) {
        this.video_thumbnail_s = video_thumbnail_s;
    }

    public String getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(String video_duration) {
        this.video_duration = video_duration;
    }

    public String getVideo_description() {
        return video_description;
    }

    public void setVideo_description(String video_description) {
        this.video_description = video_description;
    }

    public String getRate_avg() {
        return rate_avg;
    }

    public void setRate_avg(String rate_avg) {
        this.rate_avg = rate_avg;
    }

    public String getTotel_viewer() {
        return totel_viewer;
    }

    public void setTotel_viewer(String totel_viewer) {
        this.totel_viewer = totel_viewer;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_image() {
        return category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }

    public String getCategory_image_thumb() {
        return category_image_thumb;
    }

    public void setCategory_image_thumb(String category_image_thumb) {
        this.category_image_thumb = category_image_thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(cat_id);
        parcel.writeString(video_type);
        parcel.writeString(video_title);
        parcel.writeString(video_url);
        parcel.writeString(video_id);
        parcel.writeString(video_thumbnail_b);
        parcel.writeString(video_thumbnail_s);
        parcel.writeString(video_duration);
        parcel.writeString(video_description);
        parcel.writeString(rate_avg);
        parcel.writeString(totel_viewer);
        parcel.writeString(cid);
        parcel.writeString(category_name);
        parcel.writeString(category_image);
        parcel.writeString(category_image_thumb);
    }
}
