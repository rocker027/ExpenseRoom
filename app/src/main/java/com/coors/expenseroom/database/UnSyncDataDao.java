package com.coors.expenseroom.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static com.coors.expenseroom.database.ExpenseDatabase.TABLE_UN_SYNC_DATA;

/**
 * Created by z8v on 2018/3/25.
 */

@Dao
public interface UnSyncDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void inset(UnSyncDataEntity unSyncDataEntity);

    @Query("select * from " + TABLE_UN_SYNC_DATA)
    public List<UnSyncDataEntity> getAll();

    @Query("SELECT * FROM " + TABLE_UN_SYNC_DATA + " WHERE USD_UPLOAD_SUCCESS_FLAG = 0")
    public List<UnSyncDataEntity> getNoSyncList();

    @Update
    public void updateUnSyncData(UnSyncDataEntity unSyncDataEntity);

    @Delete
    public void deleteUnSyncData(UnSyncDataEntity unSyncDataEntity);
}

