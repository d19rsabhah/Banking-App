package com.example.basicbanking.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.basicbanking.Model;

import java.util.List;

@Dao
public interface CustomerDOA {
    @Insert
    void InsertCustomer(Model model);

    @Query("delete from Customer")
    void DeleteAll();

    @Query("select * from Customer")
    List<Model> DBList();

    @Query("select * from Customer c where  c.id=:id")
    Model GetCustomer(int id);

    @Update
    void UpdateDate(Model model);


}
