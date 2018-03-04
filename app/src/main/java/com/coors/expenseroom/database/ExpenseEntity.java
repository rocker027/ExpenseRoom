package com.coors.expenseroom.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import static com.coors.expenseroom.database.ExpenseEntity.TABLE_EXPENSE;

/**
 * Created by z8v on 2018/3/4.
 */

@Entity(tableName = TABLE_EXPENSE)
public class ExpenseEntity {
    public static final String TABLE_EXPENSE = "expense";
    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String cdate;
    private String info;
    private int price;

    public ExpenseEntity( String cdate, String info, int price) {
        this.cdate = cdate;
        this.info = info;
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
