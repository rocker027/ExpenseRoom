package com.coors.expenseroom.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import static com.coors.expenseroom.database.ExpenseDatabase.TABLE_UN_SYNC_DATA;

/**
 * Created by z8v on 2018/3/25.
 */

@Entity(tableName = TABLE_UN_SYNC_DATA)
public class UnSyncDataEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "USD_ID")
    private long usdId;

    @ColumnInfo(name = "USD_API_TYPE")
    private String usdApiType;

    @ColumnInfo(name = "USD_REQUEST_JSON")
    private String usdRequestJson;

    @ColumnInfo(name = "USD_UPLOAD_TIME")
    private String usdUploadTime;

    @ColumnInfo(name = "USD_UPLOAD_SUCCESS_FLAG")
    private int usdUplaodSuccessFlag;

    public String getUsdApiType() {
        return usdApiType;
    }

    public void setUsdApiType(String usdApiType) {
        this.usdApiType = usdApiType;
    }

    public String getUsdRequestJson() {
        return usdRequestJson;
    }

    public void setUsdRequestJson(String usdRequestJson) {
        this.usdRequestJson = usdRequestJson;
    }

    public String getUsdUploadTime() {
        return usdUploadTime;
    }

    public void setUsdUploadTime(String usdUploadTime) {
        this.usdUploadTime = usdUploadTime;
    }

    public int getUsdUplaodSuccessFlag() {
        return usdUplaodSuccessFlag;
    }

    public void setUsdUplaodSuccessFlag(int usdUplaodSuccessFlag) {
        this.usdUplaodSuccessFlag = usdUplaodSuccessFlag;
    }

    public long getUsdId() {
        return usdId;
    }

    public void setUsdId(long usdId) {
        this.usdId = usdId;
    }
}
