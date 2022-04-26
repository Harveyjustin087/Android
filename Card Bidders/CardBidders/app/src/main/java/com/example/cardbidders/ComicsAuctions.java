/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Comics Auctions Page
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
// this class is for the Recyclerview Comic Book Cards Auctions to display and for navigation
public class ComicsAuctions extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Auction> comicsArrayList;
    private AuctionMagicAdapter comicsAdapter;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_auctions);

        recyclerView = findViewById(R.id.recyclerView);

        comicsArrayList = new ArrayList<>();

        comicsArrayList.add(new Auction("Captain America #1", "Extremely rare 1990 Captain America #1 from Impel Marvel Universe", 575, R.drawable.capamerica));
        comicsArrayList.add(new Auction("Fleer Venom", "1995 Fleer Marvel Venom Venom", 654, R.drawable.venom));
        comicsArrayList.add(new Auction("Wolverine", "1992 Wolverine Skybox Marvel Masters", 191, R.drawable.wolverine));
        comicsArrayList.add(new Auction("Spider-Man", "1992 Spider-Man Marvel Masterpieces", 150, R.drawable.spiderman));
        comicsArrayList.add(new Auction("Thanos", "1992 Thanos Skybox Marvel Masters", 216, R.drawable.thanos));


        comicsAdapter = new AuctionMagicAdapter(comicsArrayList, this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(linearLayoutManager);

        comicsAdapter.setOnItemClickListener(new AuctionMagicAdapter.ClickListener<Auction>() {
            /**
             * this method moves the user to the details of the selected auction
             * passing the intent and data of the auction.
             * @param data Parameter 1.
             * @return void
             */
            @Override
            public void onItemClick(Auction data) {
                //  Toast.makeText(MainActivity.this, data.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ComicsAuctions.this, MagicDetail.class);
                intent.putExtra("Name", data.getCard_name());
                intent.putExtra("Desc", data.getDescription());
                intent.putExtra("Value", data.getValue());
                intent.putExtra("Image", data.getImage());

                startActivity(intent);

            }
        });
        recyclerView.setAdapter(comicsAdapter);
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
