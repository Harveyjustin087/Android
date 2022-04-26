/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Sports Cards Auction Page
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
// this class is for the Recyclerview Sports Cards Auctions to display and for navigation
public class SportsAuctions extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Auction> sportsArrayList;
    private AuctionMagicAdapter sportsAdapter;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_auctions);

        recyclerView = findViewById(R.id.recyclerView);
        sportsArrayList = new ArrayList<>();

        sportsArrayList.add(new Auction("Wayne Gretzky","Original Wayne Gretzky Rookie Card",465000,R.drawable.wayneg));
        sportsArrayList.add(new Auction("Willie Mays","Willie Mays Mint condition limited edition card.",93412,R.drawable.williemays));
        sportsArrayList.add(new Auction("Reggie Jackson","1969 Reggie Jackson Rookie Card. One of the greatest of all time.",115000,R.drawable.reggiejackson));
        sportsArrayList.add(new Auction("Sidney Crosby","Autographed 2005 Sidney Crosby Rookie Card",30000,R.drawable.crosby));
        sportsArrayList.add(new Auction("Mario Lemieux","Mario Lemieux 1985 O-Pee-Chee",14500,R.drawable.mario));

        sportsAdapter = new AuctionMagicAdapter(sportsArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        sportsAdapter.setOnItemClickListener(new AuctionMagicAdapter.ClickListener<Auction>() {
            /**
             * this method moves the user to the details of the selected auction
             * passing the intent and data of the auction.
             * @param data Parameter 1.
             * @return void
             */
            @Override
            public void onItemClick(Auction data) {
                //  Toast.makeText(MainActivity.this, data.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SportsAuctions.this, MagicDetail.class);
                intent.putExtra("Name", data.getCard_name());
                intent.putExtra("Desc", data.getDescription());
                intent.putExtra("Value", data.getValue());
                intent.putExtra("Image", data.getImage());

                startActivity(intent);

            }
        });
        recyclerView.setAdapter(sportsAdapter);
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