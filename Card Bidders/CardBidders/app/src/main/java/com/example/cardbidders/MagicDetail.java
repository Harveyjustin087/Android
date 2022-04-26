/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Card Details Page
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
import android.widget.ImageView;
import android.widget.TextView;
// this Page displays  the details of a card after being selected from the Recyclerview.
public class MagicDetail extends AppCompatActivity {

    private TextView cardName, cardDesc, cardValue;
    private ImageView cardImg;
    private Button placeBid;
    private String name, desc;
    private int value;
    private int image;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_detail);

        cardName = (TextView) findViewById(R.id.txt_name_detail);
        cardDesc = (TextView) findViewById(R.id.txt_description_detail);
        cardValue = (TextView) findViewById(R.id.txt_value_detail);
        cardImg = (ImageView) findViewById(R.id.magic_detail_img);
        placeBid = (Button)  findViewById(R.id.btn_bid_magic);

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        desc = intent.getStringExtra("Desc");
        value = intent.getIntExtra("Value",0);
        image = intent.getIntExtra("Image",0);

        cardName.setText(name);
        cardDesc.setText(desc);
        cardValue.setText("$ " + value);
        cardImg.setImageResource(image);

        placeBid.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows the Pokemon Cards Information Fragment
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MagicDetail.this, BidPlacement.class);
                intent.putExtra("Name",name);
                intent.putExtra("Value",value);
                startActivity(intent);
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