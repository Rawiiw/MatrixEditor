package com.example.matrixeditor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MatrixDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MatrixDB";
    private static final int DATABASE_VERSION = 2;

    private static final String TABLE_NAME = "matrices";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WIDTH = "width";
    private static final String COLUMN_HEIGHT = "height";
    private static final String COLUMN_DATA = "data";

    public MatrixDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_WIDTH + " INTEGER,"
                + COLUMN_HEIGHT + " INTEGER,"
                + COLUMN_DATA + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void updateMatrix(Matrix matrix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WIDTH, matrix.getWidth());
        values.put(COLUMN_HEIGHT, matrix.getHeight());
        values.put(COLUMN_DATA, matrix.getDataAsString());
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[]{String.valueOf(matrix.getId())});
        db.close();
    }

    public void deleteMatrix(long matrixId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(matrixId)});
        db.close();
    }

    public long insertMatrix(Matrix matrix) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_WIDTH, matrix.getWidth());
        values.put(COLUMN_HEIGHT, matrix.getHeight());
        values.put(COLUMN_DATA, matrix.getData());
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public List<Matrix> getAllMatrices() {
        List<Matrix> matrixList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Matrix matrix = new Matrix();
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int widthIndex = cursor.getColumnIndex(COLUMN_WIDTH);
                int heightIndex = cursor.getColumnIndex(COLUMN_HEIGHT);
                int dataIndex = cursor.getColumnIndex(COLUMN_DATA);

                if (idIndex >= 0) {
                    matrix.setId(cursor.getInt(idIndex));
                }

                if (widthIndex >= 0) {
                    matrix.setWidth(cursor.getInt(widthIndex));
                }

                if (heightIndex >= 0) {
                    matrix.setHeight(cursor.getInt(heightIndex));
                }

                if (dataIndex >= 0) {
                    matrix.setData(cursor.getString(dataIndex));
                }

                matrixList.add(matrix);
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }

        db.close();
        return matrixList;
    }

    public long insertDefaultMatrix() {
        SQLiteDatabase db = this.getWritableDatabase();

        String matrixData = "10,9,3,4;4,8,9,5;3,7,9,8;3,8,4,7";

        ContentValues values = new ContentValues();
        values.put(COLUMN_WIDTH, 4);
        values.put(COLUMN_HEIGHT, 4);
        values.put(COLUMN_DATA, matrixData);


        long id = db.replace(TABLE_NAME, null, values);

        db.close();
        return id;
    }



}
