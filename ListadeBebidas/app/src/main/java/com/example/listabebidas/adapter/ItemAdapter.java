package com.example.listabebidas.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listabebidas.R;
import com.example.listabebidas.model.ItemModel;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {
    List<ItemModel> itemModels;
    private Context context;
    public ItemAdapter(Context context, List<ItemModel> itemModels){

    }
   private class ItemHolder extends RecyclerView.ViewHolder{
       private TextView title, description;
       private ItemHolder(View view){
           super(view);
           title=(TextView)view.findViewById(R.id.title);
           description=(TextView)view.findViewById(R.id.description);


       }
   }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itens = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ItemHolder(itens);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel itemModel=itemModels.get(position);
        final ItemHolder itemHolder=(ItemHolder) holder;
        itemHolder.title.setText(itemModel.getTitle());
        itemHolder.description.setText(itemModel.getBody());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
