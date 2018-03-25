package com.coors.expenseroom;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.coors.expenseroom.database.ExpenseDatabase;
import com.coors.expenseroom.database.UnSyncDataDao;
import com.coors.expenseroom.database.UnSyncDataEntity;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by z8v on 2018/3/25.
 */
@RunWith(AndroidJUnit4.class)
public class EntityTest {
    private UnSyncDataDao unSyncDataDao;
    private ExpenseDatabase expenseDatabase;

    @Before
    public void initDB() {
        Context context = InstrumentationRegistry.getTargetContext();
        expenseDatabase = Room.inMemoryDatabaseBuilder(context, ExpenseDatabase.class).build();
        unSyncDataDao = expenseDatabase.unSyncDataDao();
        initFakeData();
    }

    public void initFakeData() {
        UnSyncDataEntity unSyncDataEntity = new UnSyncDataEntity();
        UnSyncDataEntity unSyncDataEntity2 = new UnSyncDataEntity();
        unSyncDataEntity.setUsdApiType("test api");
        unSyncDataEntity.setUsdRequestJson("{ api_type : test api}");
        unSyncDataEntity.setUsdUploadTime("2018-03-25 21:00:01");
        unSyncDataEntity.setUsdUplaodSuccessFlag(0);

        unSyncDataEntity2.setUsdApiType("test api 2");
        unSyncDataEntity2.setUsdRequestJson("{ api_type : test api 2}");
        unSyncDataEntity2.setUsdUploadTime("2018-03-25 21:10:01");
        unSyncDataEntity2.setUsdUplaodSuccessFlag(1);
        unSyncDataDao.inset(unSyncDataEntity);
        unSyncDataDao.inset(unSyncDataEntity2);
    }

    @After
    public void closeDB() throws IOException{
        expenseDatabase.close();
    }

    @Test
    public void writeAndRead() throws Exception {


        List<UnSyncDataEntity> noSyncList = unSyncDataDao.getNoSyncList();
        assertEquals(noSyncList.size(), 1);
    }

    @Test
    public void testGetSize() {
        List<UnSyncDataEntity> list = unSyncDataDao.getAll();
        assertEquals(list.size(), 2);
    }

    @Test
    public void testUpdate() {
        List<UnSyncDataEntity> list = unSyncDataDao.getNoSyncList();
        UnSyncDataEntity unSyncDataUpdate = list.get(0);
        unSyncDataUpdate.setUsdUplaodSuccessFlag(1);
        unSyncDataDao.updateUnSyncData(unSyncDataUpdate);

        assertEquals(unSyncDataDao.getNoSyncList().size(), 1);
    }

}
