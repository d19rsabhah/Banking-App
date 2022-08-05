package com.example.basicbanking.Adabtor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.basicbanking.Model;
import com.example.basicbanking.ModelTranformMoney;
import com.example.basicbanking.R;
import com.example.basicbanking.RoomDatabase.CustomerDatabase;
import com.example.basicbanking.RoomDatabase.TransfromMoneyDatabase;

import java.util.List;

public class tranformationAdabtor extends RecyclerView.Adapter<tranformationAdabtor.ViewHolder> {
    List<ModelTranformMoney> CList;
    CustomerDatabase db;

    public tranformationAdabtor(List<ModelTranformMoney> CList, CustomerDatabase d) {
        this.CList = CList;
        this.db = d;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new tranformationAdabtor.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.transfrom_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model m = db.customerDOA().GetCustomer(CList.get(position).getIdfrom());
        holder.namefrom.setText(m.getName());
        m = db.customerDOA().GetCustomer(CList.get(position).getIdto());

        holder.nameto.setText(m.getName());

        holder.money.setText("" + CList.get(position).getMoneytransormed()+" $");
    }

    @Override
    public int getItemCount() {
        return CList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namefrom, nameto, money;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namefrom = itemView.findViewById(R.id.NameFrom);
            nameto = itemView.findViewById(R.id.NsmeTO);
            money = itemView.findViewById(R.id.Moneytrans);
        }
    }


}
