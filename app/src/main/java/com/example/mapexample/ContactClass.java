package com.example.mapexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ContactClass implements java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String name;
    @ColumnInfo
    Double latitude;
    @ColumnInfo
    Double longitude;
    @ColumnInfo
    int tag;


    public ContactClass(String name, Double longitude, Double latitude, int tag) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tag = tag;
    }
}
