package com.example.basicbanking.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.basicbanking.ModelTranformMoney;

@Database(entities = {ModelTranformMoney.class}, version = 1, exportSchema = false)
public abstract class TransfromMoneyDatabase extends RoomDatabase {
    public abstract TransformMoneyDOA transformMoneyDOA();
}
