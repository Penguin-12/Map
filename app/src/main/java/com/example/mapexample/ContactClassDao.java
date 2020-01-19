package com.example.mapexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface ContactClassDao {

    @Query("Select * from ContactClass")
    List<ContactClass> getAllContacts();

    @Query("Delete from ContactClass")
    void emptyDatabase();

    @Insert
    void insertContact(ContactClass... contactClasses);

    @Delete
    void deleteContact(ContactClass... contactClasses);
}
