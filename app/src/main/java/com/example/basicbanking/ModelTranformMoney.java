package com.example.basicbanking;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TransformMoney")
public class ModelTranformMoney {
    @PrimaryKey(autoGenerate = true)
    int id;
    @NonNull
    private int idfrom, moneytransormed, idto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelTranformMoney(int idfrom, int moneytransormed, int idto) {
        this.idfrom = idfrom;
        this.moneytransormed = moneytransormed;
        this.idto = idto;
    }

    public int getIdfrom() {
        return idfrom;
    }

    public void setIdfrom(int idfrom) {
        this.idfrom = idfrom;
    }

    public int getMoneytransormed() {
        return moneytransormed;
    }

    public void setMoneytransormed(int moneytransormed) {
        this.moneytransormed = moneytransormed;
    }

    public int getIdto() {
        return idto;
    }

    public void setIdto(int idto) {
        this.idto = idto;
    }
}
