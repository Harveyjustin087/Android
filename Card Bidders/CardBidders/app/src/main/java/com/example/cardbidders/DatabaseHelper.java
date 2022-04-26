/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Database Helper Class
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//This class is to assist with database operations
public class DatabaseHelper extends SQLiteOpenHelper {

    // Create Constants for the Table and Columns in the Database
    public static final String BIDDING_TABLE = "Bidding_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_CARD = "CARD";
    public static final String COLUMN_PERSON= "PERSON";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_AMOUNT = "AMOUNT";

    // Constructor Method
    public DatabaseHelper(@Nullable Context context) {
        super(context,  "bidding.db", null, 1);
    }

    /**
     * This Method Creates the Database
     * @param db Parameter 1.
     * @return void
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createPlayerTable = "CREATE TABLE " + BIDDING_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CARD + " TEXT," + COLUMN_PERSON + " TEXT," + COLUMN_EMAIL + " TEXT," + COLUMN_AMOUNT + " INTEGER)";

        db.execSQL(createPlayerTable);

    }

    /**
     * This Method is to be called when there is an upgrade to the database
     * @param i Parameter 1.
     * @param j Parameter 2.
     * @return void
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BIDDING_TABLE);
        onCreate(sqLiteDatabase);
    }
    /**
     * Add a new Bid to SQLite Database
     * @param biddingModel Parameter 1.
     * @return void
     */
    public void addBid(BiddingModel biddingModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CARD,biddingModel.getCard());
        cv.put(COLUMN_PERSON,biddingModel.getPerson());
        cv.put(COLUMN_EMAIL,biddingModel.getEmail());
        cv.put(COLUMN_AMOUNT,biddingModel.getAmount());
        db.insert(BIDDING_TABLE, null, cv);
        db.close();
    }
    /**
     * Get the Active Bids in the system by Largest Bid
     * @return StringBuilder
     */
    public StringBuilder viewActiveBids() {

        String queryString = "SELECT * FROM " + BIDDING_TABLE + " ORDER BY " + COLUMN_AMOUNT + " DESC ";
        SQLiteDatabase data = this.getReadableDatabase();
        Cursor cursor = data.rawQuery(queryString, null);

        StringBuilder stringBuilder = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                int bidID = cursor.getInt(0);
                String card = cursor.getString(1);
                String person = cursor.getString(2);
                String email = cursor.getString(3);
                int amount= cursor.getInt(4);

                stringBuilder.append("Card Name: " + card + " | Bid Owner: " + person + " | Bidder Email: " + email + " | Amount: $ " + amount +".00"+ "\n\n");

            } while (cursor.moveToNext());
        }
        return stringBuilder;
    }

}
