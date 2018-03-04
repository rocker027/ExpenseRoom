package com.coors.expenseroom;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.coors.expenseroom.database.ExpenseDao;
import com.coors.expenseroom.database.ExpenseDatabase;
import com.coors.expenseroom.database.ExpenseEntity;

import static com.coors.expenseroom.database.ExpenseEntity.TABLE_EXPENSE;

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
        getData();
    }

    private void getData() {
        Log.d(TAG, "getData: " + expenseDao.getAll().size());
    }

    private void insertList() {
        ExpenseEntity entity1 = new ExpenseEntity("2018-01-02", "book1", 300);
        ExpenseEntity entity2 = new ExpenseEntity("2018-01-03", "book2", 400);
        ExpenseEntity entity3 = new ExpenseEntity("2018-01-04", "book3", 500);
        expenseDao.insert(entity1);
        expenseDao.insert(entity2);
        expenseDao.insert(entity3);
    }

    private void createDB() {
        database = ExpenseDatabase.getDatabase(this);
        expenseDao = database.expenseDao();
    }


}
