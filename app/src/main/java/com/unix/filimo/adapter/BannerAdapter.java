package com.unix.filimo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.unix.filimo.R;
import com.unix.filimo.models.Banner;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerVH> {

    Context context;
    List<Banner> bannerList;

    public BannerAdapter(Context context, List<Banner> bannerList) {
        this.context = context;
        this.bannerList = bannerList;
    }


    @NonNull
    @Override
    public BannerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ads_row, null);
        return new BannerVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerVH holder, int position) {
        Banner banner = bannerList.get(position);

        Picasso.with(context).load(banner.getBanner_image()).into(holder.img_ads);
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public class BannerVH extends RecyclerView.ViewHolder {

        AppCompatImageView img_ads;

        public BannerVH(@NonNull View itemView) {
            super(itemView);
            img_ads = itemView.findViewById(R.id.img_ads);
        }
    }


}
