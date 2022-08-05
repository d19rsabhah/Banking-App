package com.example.basicbanking.Adabtor;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.example.basicbanking.Model;
import com.example.basicbanking.R;
import com.example.basicbanking.TransferMonypage;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    List<Model> CList;
    private onClickRecyclerView clickRecyclerView;

    public CustomerAdapter(List<Model> CList,onClickRecyclerView clickRecyclerView) {
        this.clickRecyclerView=clickRecyclerView;
        this.CList = CList;
    }

    @NonNull
    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomerAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cutomer_layout, parent, false),clickRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.ViewHolder holder, int position) {
        holder.Name.setText(CList.get(position).getName());
        holder.Money.setText("" + CList.get(position).getMoney()+" $");
    }

    @Override
    public int getItemCount() {
        return CList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView Name, Money;
        onClickRecyclerView onClickRecyclerView;

        public ViewHolder(@NonNull View itemView,onClickRecyclerView onClickRecyclerView) {
            super(itemView);
            Name = itemView.findViewById(R.id.CName);
            Money = itemView.findViewById(R.id.CMoney);
            this.onClickRecyclerView = onClickRecyclerView;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            onClickRecyclerView.onclick(CList.get(getAdapterPosition()).getId());
        }
    }
}
