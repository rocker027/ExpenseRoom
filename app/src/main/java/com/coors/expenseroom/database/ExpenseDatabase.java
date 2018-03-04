package com.coors.expenseroom.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by z8v on 2018/3/4.
 */

@Database(entities = {ExpenseEntity.class}, version = 1)
public abstract class ExpenseDatabase extends RoomDatabase {
    public static final String DB_NAME = "Expense";
    private static ExpenseDatabase INSTANCE;
    public abstract ExpenseDao expenseDao();

    public static ExpenseDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    ExpenseDatabase.class,
                    ExpenseDatabase.DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        if (INSTANCE != null) {
            INSTANCE.close();
            INSTANCE = null;
        }
    }
}
