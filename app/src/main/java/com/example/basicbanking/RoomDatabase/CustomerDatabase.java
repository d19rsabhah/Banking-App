package com.example.basicbanking.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.basicbanking.Model;

@Database(entities = {Model.class}, version = 1, exportSchema = false)
public abstract class CustomerDatabase extends RoomDatabase {
    public abstract CustomerDOA customerDOA();
}
