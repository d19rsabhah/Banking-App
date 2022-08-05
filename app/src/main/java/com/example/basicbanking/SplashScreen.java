package com.example.basicbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.basicbanking.RoomDatabase.CustomerDatabase;

public class SplashScreen extends AppCompatActivity {
    CustomerDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        db = Room.databaseBuilder(getApplicationContext(), CustomerDatabase.class, "Customer").allowMainThreadQueries().build();
        init();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, 4500);

    }

    public void init() {
        db.customerDOA().DeleteAll();
        db.customerDOA().InsertCustomer(new Model("David Warner", "email2@Yahoo.com", "Cairo", "Business", 805000));
        db.customerDOA().InsertCustomer(new Model("Steve Smith", "email2@Yahoo.com", "Cairo", "Business", 7095000));
        db.customerDOA().InsertCustomer(new Model("Arron Finch", "email2@Yahoo.com", "Cairo", "Business", 9901000));
        db.customerDOA().InsertCustomer(new Model("Joe Root", "email2@Yahoo.com", "Cairo", "Business", 110500));
        db.customerDOA().InsertCustomer(new Model("Gleen Maxwell", "email2@Yahoo.com", "Cairo", "Business", 504200));
        db.customerDOA().InsertCustomer(new Model("Jason Roy", "email2@Yahoo.com", "Cairo", "Business", 609800));
        db.customerDOA().InsertCustomer(new Model("Joss Buttler", "email2@Yahoo.com", "Cairo", "Business", 111600));
        db.customerDOA().InsertCustomer(new Model("Mitchel Marsh ", "email2@Yahoo.com", "Cairo", "Business", 190900));
        db.customerDOA().InsertCustomer(new Model("Mitchel Stark", "email2@Yahoo.com", "Cairo", "Business", 2021500));
        db.customerDOA().InsertCustomer(new Model("James Anderson", "email2@Yahoo.com", "Cairo", "Business", 3031000));
        db.customerDOA().InsertCustomer(new Model("Kevin Peterson", "email2@Yahoo.com", "Cairo", "Business", 409500));
        db.customerDOA().InsertCustomer(new Model("Ross Taylor", "email2@Yahoo.com", "Cairo", "Business", 403900));
        db.customerDOA().InsertCustomer(new Model("Mark Wood", "email2@Yahoo.com", "Cairo", "Business", 201300));
        db.customerDOA().InsertCustomer(new Model("Ravindra Jadeja", "email2@Yahoo.com", "Cairo", "Business", 320000));
        db.customerDOA().InsertCustomer(new Model("Morni Morkel", "email2@Yahoo.com", "Cairo", "Business", 10901400));

    }

}