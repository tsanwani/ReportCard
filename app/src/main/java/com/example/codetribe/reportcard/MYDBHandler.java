package com.example.codetribe.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CodeTribe on 2017/08/01.
 */

public class MYDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "product.db";
    private static final String TABLE_PRODUCTS = "product";

    public static final String KEY_ROWID = "id";
    public static final String KEY_NAME = "Productname";
    public static final String KEY_SURNAME = "Surname";
    public static final String KEY_SUBJECTONE = "Subjectone";
    public static final String KEY_SUBJECTTWO = "Subjecttwo";
    public static final String KEY_SUBJECTTHREE = "Subjectthree";
    public static final String KEY_ID = "Quantity";
    public static final String KEY_MARK1 = "Quantity2";
    public static final String KEY_MARK2 = "Quantity3";
    public static final String KEY_MARK3 = "Quantity4";


    public MYDBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_PRODUCTS + "(" + KEY_ROWID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_SURNAME + " TEXT,"
                + KEY_SUBJECTONE + " TEXT,"
                + KEY_SUBJECTTWO + " TEXT,"
                + KEY_SUBJECTTHREE + " TEXT,"
                + KEY_MARK1 + " INTEGER,"
                + KEY_MARK2 + " INTEGER,"
                + KEY_MARK3 + " INTEGER,"
                + KEY_ID + " INTEGER " + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

    }

    public void addProduct(Product product) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getProductname());
        values.put(KEY_SURNAME, product.getSurname());
        values.put(KEY_SUBJECTONE, product.getSubjectone());
        values.put(KEY_SUBJECTTWO, product.getSubjecttwo());
        values.put(KEY_SUBJECTTHREE, product.getSubjectthree());
        values.put(KEY_ID, product.getQuantity());
        values.put(KEY_MARK1, product.getQuantity2());
        values.put(KEY_MARK2, product.getQuantity3());
        values.put(KEY_MARK3, product.getQuantity4());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }
    public Product findProduct(String productname) {

        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + KEY_NAME + " = \"" + productname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Product product = new Product();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setProductname(cursor.getString(1));
            product.setSurname(cursor.getString(2));
            product.setSubjectone(cursor.getString(3));
            product.setSubjecttwo(cursor.getString(4));
            product.setSubjectthree(cursor.getString(5));
            product.setQuantity(Integer.parseInt(cursor.getString(6)));
            product.setQuantity2(Integer.parseInt(cursor.getString(7)));
            product.setQuantity3(Integer.parseInt(cursor.getString(8)));
            product.setQuantity4(Integer.parseInt(cursor.getString(9)));
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;

    }
    public boolean deleteProduct(String x) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_PRODUCTS, KEY_NAME + " = ?", new String[] {String.valueOf(x)});

        db.close();
        return true;
    }

    public void Update(Product product) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getProductname());
        values.put(KEY_SURNAME, product.getSurname());
        values.put(KEY_SUBJECTONE, product.getSubjectone());
        values.put(KEY_SUBJECTTWO, product.getSubjecttwo());
        values.put(KEY_SUBJECTTHREE, product.getSubjectthree());
        values.put(KEY_ID, product.getQuantity());
        values.put(KEY_MARK1, product.getQuantity2());
        values.put(KEY_MARK2, product.getQuantity3());
        values.put(KEY_MARK3, product.getQuantity4());

        SQLiteDatabase db = this.getWritableDatabase();

        db.update(TABLE_PRODUCTS, values, KEY_NAME + " = ?", new String[]{String.valueOf(product.getProductname())});
        db.close();
    }

}