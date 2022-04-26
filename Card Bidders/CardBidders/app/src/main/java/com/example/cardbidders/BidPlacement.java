/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Bid Placement Page
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;
// This class gives the user a form to input their bid information
public class BidPlacement extends AppCompatActivity {

    private EditText bid_card_name,bid_start,bid_value, bid_person, bid_email;
    private Button placeBid;
    private int starter, finisher;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid_placement);

        bid_card_name = (EditText) findViewById(R.id.enterCard);
        bid_person = (EditText) findViewById(R.id.bid_name);
        bid_email = (EditText) findViewById(R.id.bid_email);
        bid_start = (EditText) findViewById(R.id.starting_value);
        bid_value = (EditText) findViewById(R.id.bid_final_value);
        placeBid = (Button) findViewById(R.id.button_final_bid);

        Intent intent = getIntent();
        String name_bid = intent.getStringExtra("Name");
        int value_bid = intent.getIntExtra("Value",0);

        bid_card_name.setText(name_bid);
        bid_start.setText("$ " + value_bid);




        placeBid.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this attempts to write what the users is trying to write
             * to the database and ensures the value for the bid is higher
             * than the initial value. Should it fail it catches the exception.
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                String final_bid = bid_value.getText().toString();
                finisher = Integer.parseInt(final_bid);
                BiddingModel biddingModel;
                DatabaseHelper databaseHelper = new DatabaseHelper(BidPlacement.this);
                if(value_bid >= finisher){
                    Toast.makeText(getApplicationContext(), "Error Starting Bid:  " + value_bid + " Is Greater than Your Bid: " + finisher, Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        biddingModel = new BiddingModel(bid_card_name.getText().toString(), bid_person.getText().toString(), bid_email.getText().toString(), finisher);
                        databaseHelper.addBid(biddingModel);
                        Toast.makeText(getApplicationContext(), "Successful Bid: " + biddingModel.toString(), Toast.LENGTH_SHORT).show();
                        Intent serviceIntent = new Intent(BidPlacement.this, NotificationService.class);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            startForegroundService(serviceIntent);
                        }
                        startActivity(new Intent(BidPlacement.this, MainActivity.class));
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error in Placing Bid ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    /**
     * Create Options Menu for App Navigation.
     * @param menu Parameter 1.
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    /**
     * Set up Options for the Menu.
     * @param item Parameter 1.
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.item_main:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.item_auctions:
                startActivity(new Intent(this, Auctions.class));
                return true;
            case R.id.item_view:
                startActivity(new Intent(this, ViewBids.class));
                return true;
            case R.id.item_feed:
                startActivity(new Intent(this, Feedback.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}