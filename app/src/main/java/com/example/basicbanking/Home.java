package com.example.basicbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    public void GotoCustomerPage(View view) {
        Toast.makeText(this, "All Customer", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, AllCustomerPage.class);
        startActivity(i);
    }

    public void GotoTransformationPage(View view) {
        Toast.makeText(this, "All Transformation", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, AllTransformationPage.class);
        startActivity(i);
    }
}
