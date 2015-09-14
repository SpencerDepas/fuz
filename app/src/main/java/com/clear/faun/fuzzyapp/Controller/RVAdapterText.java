package com.clear.faun.fuzzyapp.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clear.faun.fuzzyapp.Model.FuzzPOJO;
import com.clear.faun.fuzzyapp.R;

import java.util.List;

/**
 * Created by spencer on 9/8/2015.
 */
public class RVAdapterText  extends RecyclerView.Adapter<RVAdapterText.FuzzTextViewHolder>{

    private Context mContext;

    private List<FuzzPOJO> fuzzPOJO;
    private int itemLayout;

    RVAdapterText(List<FuzzPOJO> fuzzPOJO, Context mContext) {
        Log.i("MyRVAdapterText", "RVAdapter ");
        this.fuzzPOJO = fuzzPOJO;
        this.mContext = mContext;



    }

    public void webViewIntent(){
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);

    }
    @Override
    public FuzzTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("MyRVAdapterText", "onCreateViewHolder" );
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_text_view, parent, false);
        FuzzTextViewHolder imVW = new FuzzTextViewHolder(v);
        return imVW;

    }

    @Override
    public void onBindViewHolder(FuzzTextViewHolder holder, int position) {

        Log.i("MyRVAdapterText", "onBindViewHolder");
        holder.fuzzId.setText("ID: " + fuzzPOJO.get(position).getId());
        holder.date.setText(fuzzPOJO.get(position).getDate());
        holder.data.setText(fuzzPOJO.get(position).getData());

        Log.i("MyRVAdapterText", "position " + position);


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



    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return fuzzPOJO.size();
    }

    public static class FuzzTextViewHolder extends RecyclerView.ViewHolder {

        private TextView fuzzId;
        private TextView date;
        private TextView data;

        FuzzTextViewHolder(View itemView) {
            super(itemView);
            Log.i("MyRVAdapterText", "ImgurViewHolder");

            data = (TextView)itemView.findViewById(R.id.data);
            date = (TextView)itemView.findViewById(R.id.date);
            fuzzId = (TextView)itemView.findViewById(R.id.fuzz_id);


        }
    }

}