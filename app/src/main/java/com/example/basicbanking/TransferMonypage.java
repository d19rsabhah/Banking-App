package com.example.basicbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Index;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basicbanking.Adabtor.CustomerAdapter;
import com.example.basicbanking.Adabtor.onClickRecyclerView;
import com.example.basicbanking.RoomDatabase.CustomerDatabase;
import com.example.basicbanking.RoomDatabase.TransfromMoneyDatabase;

import java.util.ArrayList;
import java.util.List;

public class TransferMonypage extends AppCompatActivity implements onClickRecyclerView {


    RecyclerView recyclerView;
    CustomerAdapter adapter;
    List<Model> list = new ArrayList<>();
    CustomerDatabase db;
    Model MLFrom;
    EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_monypage);


        editTextNumber = findViewById(R.id.editTextNumber);

        db = Room.databaseBuilder(getApplicationContext(), CustomerDatabase.class, "Customer").allowMainThreadQueries().build();

        Intent in = getIntent();
        int idfrom = in.getIntExtra("FromName", 0);
        MLFrom = db.customerDOA().GetCustomer(idfrom);

        TextView name = findViewById(R.id.CTName);
        name.setText(MLFrom.getName());

        list = db.customerDOA().DBList();
        recyclerView = findViewById(R.id.re2);
        adapter = new CustomerAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    @Override
    public void onclick(int id) {
        if (editTextNumber.getText() != null) {
            try {
                String xx = editTextNumber.getText().toString();
                int x = Integer.parseInt(xx);
                Intent i = new Intent(this, Home.class);

                if (x > MLFrom.getMoney() || x<=0) {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
                } else {

                    Model mlTO = db.customerDOA().GetCustomer(id);
                    mlTO.setMoney(mlTO.getMoney() + x);

                    MLFrom.setMoney(MLFrom.getMoney() - x);
                    db.customerDOA().UpdateDate(MLFrom);
                    db.customerDOA().UpdateDate(mlTO);
                    //Save
                    TransfromMoneyDatabase Tdb = Room.databaseBuilder(getApplicationContext(), TransfromMoneyDatabase.class, "TransformMoney").allowMainThreadQueries().build();
                    Tdb.transformMoneyDOA().InsertTransfromation(new ModelTranformMoney(MLFrom.getId(), x, id));
                    /////
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }
                startActivity(i);
                finish();
            } catch (Exception e) {
                Toast.makeText(this, "Write good Number", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Write good Number", Toast.LENGTH_SHORT).show();
        }
    }
}