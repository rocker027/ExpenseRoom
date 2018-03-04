package com.coors.expenseroom.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;



/**
 * Created by z8v on 2018/3/4.
 */

@Dao
public interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(ExpenseEntity expenseEntity);

    @Query("select * from " + ExpenseEntity.TABLE_EXPENSE)
    public List<ExpenseEntity> getAll();

}
