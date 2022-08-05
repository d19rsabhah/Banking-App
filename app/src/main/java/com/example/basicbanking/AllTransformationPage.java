package com.example.basicbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import com.example.basicbanking.Adabtor.CustomerAdapter;
import com.example.basicbanking.Adabtor.tranformationAdabtor;
import com.example.basicbanking.RoomDatabase.CustomerDatabase;
import com.example.basicbanking.RoomDatabase.TransfromMoneyDatabase;

import java.util.ArrayList;
import java.util.List;

public class AllTransformationPage extends AppCompatActivity {

    RecyclerView recyclerView;
    tranformationAdabtor adapter;
    List<ModelTranformMoney> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transformation_page);

        TransfromMoneyDatabase Tdb = Room.databaseBuilder(getApplicationContext(), TransfromMoneyDatabase.class, "TransformMoney").allowMainThreadQueries().build();
        CustomerDatabase Cdb = Room.databaseBuilder(getApplicationContext(), CustomerDatabase.class, "Customer").allowMainThreadQueries().build();
        list = Tdb.transformMoneyDOA().DBList();
        if (list.size()==0)
            Toast.makeText(this, "No Transformation Found", Toast.LENGTH_SHORT).show();
        recyclerView = findViewById(R.id.ResyclerViewAllTran);
        adapter = new tranformationAdabtor(list, Cdb);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}