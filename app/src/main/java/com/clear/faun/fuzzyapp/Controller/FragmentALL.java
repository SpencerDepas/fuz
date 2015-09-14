package com.clear.faun.fuzzyapp.Controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
public class FragmentALL extends Fragment implements FuzzResponse {

    private CardView cardView;
    private Context mContext;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        Log.d("MyFragmentCardView", "onCreateView");
        return inflater.inflate(R.layout.all_fragment_rv, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("MyFragmentCardView", "onActivityCreated");


        mContext = getActivity().getApplicationContext();


        rv = (RecyclerView)getActivity().findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        rv.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));

        CallAndParse callAndParse = new CallAndParse();
        callAndParse.delegate = this;




    }

    public Context getFragmentContext(){
        return mContext;
    }

    @Override
    public void processFinish(List<FuzzPOJO> fuzzPOJO) {
        Log.d("MyMainActivity", "FuzzPOJO processFinish");


       /* for(int i = 0; i < fuzzPOJO.size(); i ++){

            Log.i("FragmentALL", "dC " + fuzzPOJO.get(i).getId());
        }*/

        RVAdapter rvAdapter = new RVAdapter(fuzzPOJO, mContext);
        rv.setAdapter(rvAdapter);
   
    }


}
