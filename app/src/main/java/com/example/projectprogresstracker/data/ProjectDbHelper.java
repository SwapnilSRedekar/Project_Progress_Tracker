package com.example.projectprogresstracker.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_BUDGET;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_DESCRIPTION;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_END_DATE;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_END_POINT;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_PROJECT_NAME;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_PROJECT_PROGRESS;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_START_DATE;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry.COLUMN_START_POINT;
import static com.example.projectprogresstracker.data.ProjectContract.ProjectEntry._ID;

public class ProjectDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "project.db";

    public ProjectDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public ProjectDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PROJECT_TABLE = "CREATE TABLE " + ProjectContract.ProjectEntry.TABLE_NAME + " ( "
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PROJECT_NAME + " TEXT NOT NULL, "
                + COLUMN_START_DATE + " TEXT, "
                + COLUMN_END_DATE + " TEXT, "
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_BUDGET + " INTEGER DEFAULT 0, "
                + COLUMN_PROJECT_PROGRESS + " INTEGER DEFAULT 0, "
                + COLUMN_START_POINT + " INTEGER DEFAULT 0, "
                + COLUMN_END_POINT + " INTEGER DEFAULT 100); ";
        db.execSQL(SQL_CREATE_PROJECT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
