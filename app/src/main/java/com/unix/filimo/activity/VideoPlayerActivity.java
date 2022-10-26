package com.unix.filimo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.squareup.picasso.Picasso;
import com.unix.filimo.databinding.ActivityVideoPlayerBinding;


import com.unix.filimo.models.Banner;
import com.unix.filimo.models.Video;

public class VideoPlayerActivity extends AppCompatActivity {


    ActivityVideoPlayerBinding binding;
    ExoPlayer player;
   Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        video = getIntent().getExtras().getParcelable("video");

        Picasso.with(getApplicationContext()).load(video.getVideo_thumbnail_b()).into(binding.imgShowImage);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtDescVideoPlayer.setText(Html.fromHtml(video.getVideo_description(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            binding.txtDescVideoPlayer.setText(Html.fromHtml(video.getVideo_description()));
        }


        player = new ExoPlayer.Builder(getApplicationContext()).build();
        binding.videoViewVideoPlayer.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(video.getVideo_url()));
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();




    }


    @Override
    protected void onStop() {
        super.onStop();

        if (player.isPlaying())
            player.stop();
    }
}