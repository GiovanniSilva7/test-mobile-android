/*package com.example.listabebidas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.listabebidas.Interfaces.NetworkResponseListener;
import com.example.listabebidas.R;




import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.listabebidas.adapter.ImageItemAdapter;
import com.example.listabebidas.model.ImageModel;
import com.example.listabebidas.task.LoadDataWithImageTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment implements NetworkResponseListener {


    private RecyclerView list_item;
    private ProgressBar progressBar;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list_item=view.findViewById(R.id.list_item);
        //Now Lets Show a Progressbar
        progressBar=view.findViewById(R.id.progress);
        LoadDataWithImageTask loadDataTask=new LoadDataWithImageTask(Fragment2.this);
        loadDataTask.execute();
    }

    @Override
    public void SuccessData(String data) {
        progressBar.setVisibility(View.GONE);

        try {
            List<ImageModel> imageModels=new ArrayList<>();
            JSONArray jsonArray = new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                imageModels.add(new ImageModel(jsonArray.getJSONObject(i).getString("description"),jsonArray.getJSONObject(i).getString("image_url")));
            }

            ImageItemAdapter imageItemAdapter=new ImageItemAdapter(getContext(),imageModels);
            list_item.setLayoutManager(new GridLayoutManager(getContext(),2));
            list_item.setAdapter(imageItemAdapter);
        }
        catch (JSONException e){
            e.printStackTrace();
        }



    }

    @Override
    public void SucessData(String data) {

    }

    @Override
    public void FailedData() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getContext(), "Failed to Load Data on Fragment 2", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}*/