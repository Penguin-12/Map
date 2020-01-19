package com.example.mapexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ContactClass.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactClassDao contactClassDao();


}
