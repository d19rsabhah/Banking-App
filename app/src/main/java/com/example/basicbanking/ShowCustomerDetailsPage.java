package com.example.basicbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.basicbanking.Adabtor.CustomerAdapter;
import com.example.basicbanking.Adabtor.tranformationAdabtor;
import com.example.basicbanking.RoomDatabase.CustomerDatabase;
import com.example.basicbanking.RoomDatabase.TransfromMoneyDatabase;

import java.util.ArrayList;
import java.util.List;

public class ShowCustomerDetailsPage extends AppCompatActivity {
    int idfrom;
    CustomerDatabase Cdb;

    RecyclerView recyclerView;
    tranformationAdabtor adapter;
    List<ModelTranformMoney> list = new ArrayList<>();
    TransfromMoneyDatabase Tdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_customer_details_page);

        Cdb = Room.databaseBuilder(getApplicationContext(), CustomerDatabase.class, "Customer").allowMainThreadQueries().build();
        Tdb = Room.databaseBuilder(getApplicationContext(), TransfromMoneyDatabase.class, "TransformMoney").allowMainThreadQueries().build();

        Intent in = getIntent();
        idfrom = in.getIntExtra("FromName", 0);
        Model MLFrom = Cdb.customerDOA().GetCustomer(idfrom);

        TextView email=findViewById(R.id.CDeamil);
        email.setText(""+MLFrom.getEmail());
        TextView name=findViewById(R.id.CDName);
        name.setText(""+MLFrom.getName());
        TextView address=findViewById(R.id.CDaddress);
        address.setText(""+MLFrom.getAddress());
        TextView balance=findViewById(R.id.CDaddress);
        balance.setText(""+MLFrom.getAddress());
        TextView money=findViewById(R.id.CDMoney);
        money.setText(""+MLFrom.getMoney());

        list = Tdb.transformMoneyDOA().DBList(MLFrom.getId());


        recyclerView = findViewById(R.id.recyclerView4);
        adapter = new tranformationAdabtor(list,Cdb);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void GotoCustome2rPage(View view) {
        Intent i = new Intent(this, TransferMonypage.class);
        i.putExtra("FromName", idfrom);
        startActivity(i);
    }
}