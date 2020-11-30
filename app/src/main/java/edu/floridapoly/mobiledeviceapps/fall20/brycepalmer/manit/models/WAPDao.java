package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.models;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WAPDao {
    @Insert
    void insertAll(WAPS... waps);

    @Insert
    void insert(WAPS wap);

    @Delete
    void delete(WAPS wap);

    @Query("SELECT * FROM WAPS WHERE OrgID =(:OrgID)")
    List<WAPS> getListWAPSForOrg(int OrgID);

    @Query("SELECT * FROM WAPS WHERE OrgID = (:OrgID)")
    LiveData<List<WAPS>> getAllForOrg(int OrgID);

    //Can add more queries as needed

}
