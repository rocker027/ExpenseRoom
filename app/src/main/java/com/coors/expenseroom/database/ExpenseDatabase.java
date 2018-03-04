package com.coors.expenseroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by z8v on 2018/3/4.
 */

@Database(entities = {ExpenseEntity.class}, version = 1)
public abstract class ExpenseDatabase extends RoomDatabase {
    public abstract ExpenseDao expenseDao();

}
