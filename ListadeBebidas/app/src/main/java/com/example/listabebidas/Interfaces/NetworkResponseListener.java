package com.example.listabebidas.Interfaces;

import android.view.MenuItem;

import androidx.annotation.NonNull;

public interface NetworkResponseListener {
    void SuccessData(String data);

    //Quando a resposta esta correta
    void SucessData(String data);
    //Quando a resposta esta errada
    void FailedData();


    boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
}
