/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Main Activity and Title Page
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
// this class sets up the Main Title Page of the App.
public class MainActivity extends AppCompatActivity {

    private Button btn_about,btn_auctions,btn_view, btn_get_feedback, btn_get_fort;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_about = (Button) findViewById(R.id.btn_about);
        btn_auctions = (Button) findViewById(R.id.btn_bid);
        btn_view = (Button) findViewById(R.id.btn_view_bids);
        btn_get_feedback = (Button) findViewById(R.id.btn_feedback);
        btn_get_fort = (Button) findViewById(R.id.btn_fortune);

        btn_about.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this navigates to the About Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),About.class);
                startActivity(intent);
            }
        });

        btn_auctions.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this navigates to the Auctions Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Auctions.class);
                startActivity(intent);
            }
        });
        btn_view.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this navigates to the ViewBids Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ViewBids.class);
                startActivity(intent);
            }
        });
        btn_get_feedback.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this navigates to the Feedback Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Feedback.class);
                startActivity(intent);
            }
        });
        btn_get_fort.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this navigates to the Fortune Teller Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Fortune.class);
                startActivity(intent);
            }
        });
    }

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