package com.example.basicbanking;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Customer")
public class Model {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String name, email,address,balance ;
    @NonNull
    private int money;

    public Model(@NonNull String name, @NonNull String email, @NonNull String address, @NonNull String balance, int money) {

        this.name = name;
        this.email = email;
        this.address = address;
        this.balance = balance;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getBalance() {
        return balance;
    }

    public void setBalance(@NonNull String balance) {
        this.balance = balance;
    }
}
