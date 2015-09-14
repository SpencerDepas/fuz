package com.clear.faun.fuzzyapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.clear.faun.fuzzyapp.Model.FuzzPOJO;
import com.clear.faun.fuzzyapp.R;

import java.util.List;

/**
 * Created by spencer on 9/8/2015.
 */
public class RVAdapterImage extends RecyclerView.Adapter<RVAdapterImage.FuzzImageViewHolder>{

    private Context mContext;
    private int width = 0;
    private int height = 0;
    private List<FuzzPOJO> fuzzPOJO;
    private int itemLayout;

    RVAdapterImage(List<FuzzPOJO> fuzzPOJO, Context mContext) {
        Log.i("MyRVAdapterText", "RVAdapter ");
        this.fuzzPOJO = fuzzPOJO;
        this.mContext = mContext;
        if (width == 0) {
            width = getScreenWidth() / 2;
            height = width;
        }


    }


    @Override
    public FuzzImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("MyRVAdapterText", "onCreateViewHolder" );
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_image_view, parent, false);
        FuzzImageViewHolder imVW = new FuzzImageViewHolder(v);
        return imVW;

    }

    @Override
    public void onBindViewHolder(FuzzImageViewHolder holder, final int position) {

        Log.i("MyRVAdapterText", "onBindViewHolder");
       /* holder.fuzzId.setText("Top secret Fuzz password ID: " + fuzzPOJO.get(position).getId());
        holder.date.setText(fuzzPOJO.get(position).getData());*/
        Log.i("MyRVAdapterText", "position " + position);

        Glide.with(mContext)
                .load(fuzzPOJO.get(position).getData())
                .override(width, height)
                .centerCrop()
                .crossFade()
                .placeholder(R.drawable.fuzz_logo)
                .into(holder.image);



        holder.image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fullScreenIntent(position);

            }
        });

    }


    public void fullScreenIntent(int position){
        Intent intent = new Intent(mContext, FullScreenImage.class);
        String strName = fuzzPOJO.get(position).getData();
        intent.putExtra("URL", strName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return fuzzPOJO.size();
    }

    public static class FuzzImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;


        FuzzImageViewHolder(View itemView) {
            super(itemView);
            Log.i("MyRVAdapterText", "ImgurViewHolder");

            image = (ImageView)itemView.findViewById(R.id.image_view);


        }
    }

    private int getScreenWidth(){
        Log.i("MyRVAdapterText", "getScreenWidth " );
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

}