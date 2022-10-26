package com.unix.filimo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.unix.filimo.adapter.VideoAdapter;
import com.unix.filimo.api.ApiClient;
import com.unix.filimo.api.IService;
import com.unix.filimo.databinding.ActivityVideoListByCategoryBinding;
import com.unix.filimo.models.BaseVideoModel;
import com.unix.filimo.models.Category;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoListByCategoryActivity extends AppCompatActivity {

    ActivityVideoListByCategoryBinding binding;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoListByCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        category = getIntent().getExtras().getParcelable("data");
        binding.txtTitle.setText(category.getCategory_name());
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.progressBar.setVisibility(View.VISIBLE);

        IService iService = ApiClient.getRetrofit().create(IService.class);
        iService.getVideoByCatId(category.getCid()).enqueue(new Callback<BaseVideoModel>() {
            @Override
            public void onResponse(Call<BaseVideoModel> call, Response<BaseVideoModel> response) {

                VideoAdapter videoAdapter = new VideoAdapter(getApplicationContext(), response.body().getVideoListList());
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                binding.reyVideoByCid.setAdapter(videoAdapter);
                binding.reyVideoByCid.setLayoutManager(gridLayoutManager);
                binding.reyVideoByCid.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

                binding.progressBar.setVisibility(View.GONE);

                Log.e("TAG", "onResponse: ");
            }

            @Override
            public void onFailure(Call<BaseVideoModel> call, Throwable t) {

                binding.progressBar.setVisibility(View.GONE);

                Log.e("TAG", "onFailure: ");
            }
        });


    }
}