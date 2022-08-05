package com.example.basicbanking.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.basicbanking.Model;
import com.example.basicbanking.ModelTranformMoney;

import java.util.List;
@Dao
public interface TransformMoneyDOA {
    @Insert
    void InsertTransfromation(ModelTranformMoney model);

    @Query("delete from TransformMoney")
    void DeleteAll();

    @Query("select * from TransformMoney")
    List<ModelTranformMoney> DBList();

    @Query("select * from TransformMoney where idfrom = :id")
    List<ModelTranformMoney> DBList(int id);

}
