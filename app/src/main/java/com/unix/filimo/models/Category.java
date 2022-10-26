package com.unix.filimo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

        String cid;
        String category_name;
        String category_image;
        String category_image_thumb;

        public Category(){}


    protected Category(Parcel in) {
        cid = in.readString();
        category_name = in.readString();
        category_image = in.readString();
        category_image_thumb = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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
        parcel.writeString(cid);
        parcel.writeString(category_name);
        parcel.writeString(category_image);
        parcel.writeString(category_image_thumb);
    }
}
