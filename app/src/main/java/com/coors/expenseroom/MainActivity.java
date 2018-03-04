package com.coors.expenseroom;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.coors.expenseroom.database.ExpenseDao;
import com.coors.expenseroom.database.ExpenseDatabase;
import com.coors.expenseroom.database.ExpenseEntity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ExpenseDatabase database;
    private ExpenseDao expenseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDB();
        insertList();
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "getData: " + expenseDao.getAll().size());
            }
        }).start();


    }

    private void insertList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExpenseEntity entity1 = new ExpenseEntity("2018-01-02", "book1", 300);
                ExpenseEntity entity2 = new ExpenseEntity("2018-01-03", "book2", 400);
                ExpenseEntity entity3 = new ExpenseEntity("2018-01-04", "book3", 500);
                expenseDao.insert(entity1);
                expenseDao.insert(entity2);
                expenseDao.insert(entity3);
                getData();
            }
        }).start();

    }

    private void createDB() {
                database = Room.inMemoryDatabaseBuilder(MainActivity.this, ExpenseDatabase.class).build();
                expenseDao = database.expenseDao();
    }


}
