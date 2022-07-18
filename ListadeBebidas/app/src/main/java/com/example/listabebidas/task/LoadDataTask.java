package com.example.listabebidas.task;

import android.app.DownloadManager;
import android.os.AsyncTask;
import android.view.textclassifier.TextLinks;

import com.example.listabebidas.Interfaces.NetworkResponseListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoadDataTask extends AsyncTask<String, String, String> {
private NetworkResponseListener networkResponseListener;
public LoadDataTask(NetworkResponseListener networkResponseListener){
    this.networkResponseListener=networkResponseListener;
}

    @Override
    protected String doInBackground(String... strings) {
        OkHttpClient client=new OkHttpClient();
        client.retryOnConnectionFailure();
        client.newBuilder().connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder().url("https://api.punkapi.com/v2/beers").build();
        Response response = null;
        try{
            response=client.newCall(request).execute();
            
        }catch (IOException e){
            e.printStackTrace();
        }
        if (response!=null && response.isSuccessful()){
            try{
                if(response.body()!=null){
                    return response.body().string();
                }else{
                    return null;
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s!=null){
            networkResponseListener.SucessData(s);
        }
        else{
           networkResponseListener.FailedData();
        }
    }
}
