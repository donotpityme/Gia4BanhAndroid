package com.example.administrator.gia4banh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbHelpter {
    Context context;
    SQLiteDatabase db;

    public DbHelpter(Context context) {
        this.context = context;
        AssetDatabaseOpenHelper assetDB = new AssetDatabaseOpenHelper(context);
        db = assetDB.StoreDatabase();
    }

    private ArrayList<String> get(String sql, String... selectionArgs) {
        ArrayList<String> contents = new ArrayList<String>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            contents.add(c.getString(0));
        }
        c.close();
        return contents;
    }
    // lấy giá xe theo id
    public int getPrice(int id) {
        Cursor cursor;
        cursor = db.rawQuery("SELECT Price FROM Product WHERE Id = '" + id + "'", null);
        if (cursor != null)
            cursor.moveToFirst();
        int content = cursor.getInt(0);
        return content;
    }
    // lấy số chỗ ngồi của xe theo id
    public int getSochongoi(int id) {
        Cursor cursor;
        cursor = db.rawQuery("SELECT Sochongoi FROM Product WHERE Id = '" + id + "'", null);
        if (cursor != null)
            cursor.moveToFirst();
        int content = cursor.getInt(0);
        return content;
    }
    // lấy danh sách các xe trong csdl
    public ArrayList<String> getproduct() {
        String sql = "select Name from Product";
        return get(sql);
    }



//    public void add(String word) {
//        db.execSQL("");
//        db.close();
//    }

}
