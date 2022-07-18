package com.example.listabebidas.adapter;

import android.content.Context;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.listabebidas.R;
import com.example.listabebidas.model.ImageModel;
import com.google.android.gms.fido.fido2.api.common.AuthenticationExtensions;
import com.google.android.gms.fido.fido2.api.common.RequestOptions;
import com.google.android.gms.fido.fido2.api.common.TokenBinding;

import java.util.ArrayList;
import java.util.List;

public class ImageItemAdapter extends RecyclerView.Adapter {

    List<ImageModel> imageModels=new ArrayList<>();
    Context context;

    public ImageItemAdapter(Context context,List<ImageModel> imageModels){
        this.context=context;
        this.imageModels=imageModels;
    }

    public class ImageItemHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView thumb;

        private ImageItemHolder(View view){
            super(view);
            title=view.findViewById(R.id.title);
            thumb=view.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row,parent,false);
        return new ImageItemHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageModel imageModel=imageModels.get(position);
        ImageItemHolder imageItemHolder=(ImageItemHolder)holder;
        imageItemHolder.title.setText(imageModel.getAuthor());
        //now loading image we need to add external library which is glide i used here

        RequestOptions requestOptions= new RequestOptions() {
            @Override
            public void writeToParcel(Parcel dest, int flags) {

            }

            @Override
            public byte[] getChallenge() {
                return new byte[0];
            }

            @Nullable
            @Override
            public Double getTimeoutSeconds() {
                return null;
            }

            @Nullable
            @Override
            public Integer getRequestId() {
                return null;
            }

            @Nullable
            @Override
            public TokenBinding getTokenBinding() {
                return null;
            }

            @Nullable
            @Override
            public AuthenticationExtensions getAuthenticationExtensions() {
                return null;
            }
        };


        Glide.with(context)
                .load(imageModel.getImage("https://api.punkapi.com/v2/beers"))
                .into(imageItemHolder.thumb);


    }

    @Override
    public int getItemCount() {
        return imageModels.size();
    }
}
