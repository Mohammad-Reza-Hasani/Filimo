package com.unix.filimo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.unix.filimo.R;
import com.unix.filimo.activity.VideoPlayerActivity;
import com.unix.filimo.models.Banner;
import com.unix.filimo.models.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoVH> {


    Context context;
    List<Video> videoList;

    public VideoAdapter(Context context, List<Video> videoList) {
        this.context = context;
        this.videoList = videoList;
    }


    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.video_row,null);
        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {

       Video video = videoList.get(position);
        holder.txt_title.setText(video.getVideo_title());
        Picasso.with(context).load(video.getVideo_thumbnail_b()).into(holder.img_video);

        holder.linearLayout_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, VideoPlayerActivity.class);
                intent.putExtra("video",video);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoVH extends RecyclerView.ViewHolder {

        AppCompatTextView txt_title;
        AppCompatImageView img_video;
        LinearLayout linearLayout_video;


        public VideoVH(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            img_video = itemView.findViewById(R.id.img_video);
            linearLayout_video = itemView.findViewById(R.id.linear_video);
        }
    }


}
