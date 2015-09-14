package com.clear.faun.fuzzyapp.Controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clear.faun.fuzzyapp.Model.CallAndParse;
import com.clear.faun.fuzzyapp.Model.FuzzPOJO;
import com.clear.faun.fuzzyapp.Model.FuzzResponse;
import com.clear.faun.fuzzyapp.R;

import java.util.List;

/**
 * Created by spencer on 9/8/2015.
 */
public class FragmentImage extends Fragment implements FuzzResponse {


    private Context mContext;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        Log.d("MyFragmentCardView", "onCreateView");
        return inflater.inflate(R.layout.image_fragment_rv, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MyFragmentCardView", "onActivityCreated");


        mContext = getActivity().getApplicationContext();

        rv = (RecyclerView)getActivity().findViewById(R.id.recyclerview_image);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));



        View someView = getActivity().findViewById(R.id.recyclerview_image);
        View root = someView.getRootView();
        root.setBackgroundColor(getResources().getColor(android.R.color.white));



        CallAndParse callAndParse = new CallAndParse();
        callAndParse.delegate = this;




    }


    @Override
    public void processFinish(List<FuzzPOJO> fuzzPOJO) {
        Log.d("MyMainActivity", "FuzzPOJO processFinish");


       /* for(int i = 0; i < fuzzPOJO.size(); i ++){

            Log.i("FragmentALL", "dC " + fuzzPOJO.get(i).getId());
        }*/

        RVAdapterImage rvAdapter = new RVAdapterImage(fuzzPOJO, mContext);
        rv.setAdapter(rvAdapter);

    }


}