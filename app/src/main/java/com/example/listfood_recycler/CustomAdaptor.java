package com.example.listfood_recycler;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.ListViewHolder> {

    private ArrayList<food> dftrFood;
    private OnItemClickCallBack onItemClickCallBack;


    public void setOnItemClickCallback(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public CustomAdaptor(ArrayList<food> list){
        this.dftrFood= list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_row_layout , viewGroup, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final food food = dftrFood.get(position);
        Glide.with(holder.itemView.getContext()).load(food.getPhoto()).apply(new RequestOptions().override(550,550)).into(holder.imgPhoto);

        holder.tvName.setText(food.getName());
        holder.tvDetail.setText(food.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(dftrFood.get(holder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return dftrFood.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDetail;
        ImageView imgPhoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvName = itemView.findViewById(R.id.tv_nama);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }


    public interface OnItemClickCallBack{
        void onItemClicked(food data);
    }
}
