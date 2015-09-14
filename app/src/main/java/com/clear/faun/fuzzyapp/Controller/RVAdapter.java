package com.clear.faun.fuzzyapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clear.faun.fuzzyapp.Model.FuzzPOJO;
import com.clear.faun.fuzzyapp.R;

import java.util.List;

/**
 * Created by spencer on 9/8/2015.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.FuzzViewHolder>{

    private Context mContext;
    private int width = 0;
    private int height = 0;
    private List<FuzzPOJO> fuzzPOJO;
    private int itemLayout;



    RVAdapter(List<FuzzPOJO> fuzzPOJO, Context mContext) {
        Log.i("MyRVAdapter", "RVAdapter ");
        this.fuzzPOJO = fuzzPOJO;
        this.mContext = mContext;
        if (width == 0) {
            width = getScreenWidth();
            height = width;
        }


    }


    @Override
    public FuzzViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("MyRVAdapter", "onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_view, parent, false);
        FuzzViewHolder imVW = new FuzzViewHolder(v);
        return imVW;

    }

    @Override
    public void onBindViewHolder(FuzzViewHolder holder, final int position) {

        Log.i("MyRVAdapter", "onBindViewHolder");
        holder.fuzzId.setText("ID: " + fuzzPOJO.get(position).getId());
        holder.data.setText(fuzzPOJO.get(position).getData());
        holder.date.setText(fuzzPOJO.get(position).getDate());



        holder.data.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webViewIntent();

            }
        });

        holder.date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webViewIntent();

            }
        });

        holder.fuzzId.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webViewIntent();

            }
        });

        Log.i("MyRVAdapter", "position " + position);
        holder.image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fullScreenIntent(position);

            }
        });


        Glide.with(mContext)
                .load(fuzzPOJO.get(position).getData())
                .override(300, 300)
                .centerCrop()
                .crossFade()
                .placeholder(R.drawable.fuzz_logo)
                .into(holder.image);

    }

    public void webViewIntent(){
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);

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

    public static class FuzzViewHolder extends RecyclerView.ViewHolder
            {

        private TextView fuzzId;
        private TextView date;
        private TextView data;
        private ImageView image;

        FuzzViewHolder(View itemView) {
            super(itemView);
            Log.i("MyRVAdapter", "ImgurViewHolder" );
            //cv = (CardView)itemView.findViewById(R.id.cv);
            date = (TextView)itemView.findViewById(R.id.date);
            data = (TextView)itemView.findViewById(R.id.data);
            fuzzId = (TextView)itemView.findViewById(R.id.fuzz_id);
            image = (ImageView)itemView.findViewById(R.id.image_view);


/*
            image.setOnClickListener(this);
            fuzzId.setOnClickListener(this);
            data.setOnClickListener(this);
            date.setOnClickListener(this);*/
        }

    /*    @Override
        public void onClick(View view) {
            Log.i("MyRVAdapter", "onClick");

            switch (view.getId()) {
                case R.id.image_view:
                    Log.i("MyRVAdapter", "view image_view" );

                    break;

                case R.id.data:
                    Log.i("MyRVAdapter", "data" );
                    webViewIntent();
                    break;

                case R.id.date:
                    Log.i("MyRVAdapter", "date" );
                    webViewIntent();
                    break;


                case R.id.fuzz_id:
                    Log.i("MyRVAdapter", "date" );
                    webViewIntent();
                    break;
            }
        }*/

       /* public void webViewIntent(){
            Intent intent = new Intent(mContext, WebViewActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);

        }*/

    }



    private int getScreenWidth(){
        Log.i("MyRVAdapter", "getScreenWidth " );
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

}