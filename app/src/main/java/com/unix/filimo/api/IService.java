package com.unix.filimo.api;

import com.unix.filimo.models.BaseModel;
import com.unix.filimo.models.BaseVideoModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IService {

    @GET("api.php?All_videos")
    Call<ResponseBody> getLatestVideo();

    @GET("api.php?cat_list")
    Call<ResponseBody> getCategories();

    @GET("api.php?home_banner")
    Call<BaseModel> getHomeBanners();

    @GET("api.php")
    Call<BaseVideoModel> getVideoByCatId(@Query("cat_id") String id);

}
