package com.unix.filimo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unix.filimo.adapter.BannerAdapter;
import com.unix.filimo.adapter.CategoryAdapter;
import com.unix.filimo.adapter.VideoAdapter;
import com.unix.filimo.api.ApiClient;
import com.unix.filimo.api.IService;
import com.unix.filimo.databinding.ActivityMainBinding;
import com.unix.filimo.databinding.ActivityMainBinding;
import com.unix.filimo.models.BaseModel;
import com.unix.filimo.models.Category;
import com.unix.filimo.models.Banner;
import com.unix.filimo.models.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    List<Video> videoList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

     /*   Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/IRANSans_Bold.ttf");
        binding.txtLastVideosMain.setTypeface(typeface);*/


        IService iService = ApiClient.getRetrofit().create(IService.class);

        getLatestVideo(iService);

        getCategories(iService);

        iService.getHomeBanners().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {

                BannerAdapter bannerAdapter = new BannerAdapter(getApplicationContext(), response.body().getBannerList());
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
                binding.recyclerAds.setAdapter(bannerAdapter);
                binding.recyclerAds.setLayoutManager(layoutManager);

                Log.i("TAG", "onResponse: ");
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                Log.i("TAG", "onFailure: ");
            }
        });

    }

    public void getLatestVideo(IService iService) {
        iService.getLatestVideo().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    String root = jsonObject.getString("ALL_IN_ONE_VIDEO");
                    JSONArray jsonArray = new JSONArray(root);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                      Video video = new Video();
                        video.setId(object.getString("id"));
                        video.setCat_id(object.getString("cat_id"));
                        video.setVideo_type(object.getString("video_type"));
                        video.setVideo_title(object.getString("video_title"));
                        video.setVideo_url(object.getString("video_url"));
                        video.setVideo_thumbnail_b(object.getString("video_thumbnail_b"));
                        video.setVideo_thumbnail_s(object.getString("video_thumbnail_s"));
                        video.setVideo_duration(object.getString("video_duration"));
                        video.setVideo_description(object.getString("video_description"));
                        video.setRate_avg(object.getString("rate_avg"));
                        video.setTotel_viewer(object.getString("totel_viewer"));
                        video.setCid(object.getString("cid"));
                        video.setCategory_name(object.getString("category_name"));
                        video.setCategory_image(object.getString("category_image"));
                        video.setCategory_image_thumb(object.getString("category_image_thumb"));
                        videoList.add(video);


                        Log.e("Tag", "onResponse: ");
                    }


                    VideoAdapter videoAdapter = new VideoAdapter(getApplicationContext(), videoList);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, true);
                    binding.recyclerLastVideos.setAdapter(videoAdapter);
                    binding.recyclerLastVideos.setLayoutManager(layoutManager);


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("", "onFailure: ");

            }
        });
    }

    public void getCategories(IService iService) {

        iService.getCategories().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    String root = jsonObject.getString("ALL_IN_ONE_VIDEO");
                    JSONArray jsonArray = new JSONArray(root);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);

                        Category category = new Category();
                        category.setCid(object.getString("cid"));
                        category.setCategory_name(object.getString("category_name"));
                        category.setCategory_image(object.getString("category_image"));
                        category.setCategory_image_thumb(object.getString("category_image_thumb"));

                        categoryList.add(category);
                    }

                    CategoryAdapter categoryAdapter = new CategoryAdapter(getApplicationContext(), categoryList);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
                    binding.recyclerCategories.setAdapter(categoryAdapter);
                    binding.recyclerCategories.setLayoutManager(layoutManager);

                    Log.e("TAG", "onResponse: ");


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "onFailure: ");
            }
        });
    }

}