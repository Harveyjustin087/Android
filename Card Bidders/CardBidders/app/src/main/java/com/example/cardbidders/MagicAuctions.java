/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Magic Card Auctions Page
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
// this class is for the Recyclerview Magic Cards Auctions to display and for navigation
public class MagicAuctions extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Auction> magicArrayList;
    private AuctionMagicAdapter magicAdapter;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_auctions);

        recyclerView = findViewById(R.id.recyclerView);

        magicArrayList = new ArrayList<>();

        magicArrayList.add(new Auction("The Black Lotus", "Black Lotus is revered as the most expensive Magic: The Gathering card ever made.", 42000, R.drawable.blacklotus));
        magicArrayList.add(new Auction("Ancestral Recall", "Ancestral Recall lets you draw three cards from your deck - at the low cost of 20 grand.", 20000, R.drawable.ancestralrecall));
        magicArrayList.add(new Auction("Time Walk", "Time Walk is as powerful as it is simple, you play two mana to take a whole second turn after the one you're currently doing.", 6500, R.drawable.timewalk));
        magicArrayList.add(new Auction("Nicol Bolas, God-Pharaoh", "Planeswalker Nicol Bolas requires a fair chunk of mana plus three specific colors but offers four loyalty abilities.", 500, R.drawable.nicol));
        magicArrayList.add(new Auction("Thassa God of the Sea", "God. Indestructible. As long as your devotion to blue is less than five, Thassa isn't a creature.", 500, R.drawable.thassa));


        magicAdapter = new AuctionMagicAdapter(magicArrayList, this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(linearLayoutManager);

        magicAdapter.setOnItemClickListener(new AuctionMagicAdapter.ClickListener<Auction>() {
            /**
             * this method moves the user to the details of the selected auction
             * passing the intent and data of the auction.
             * @param data Parameter 1.
             * @return void
             */
            @Override
            public void onItemClick(Auction data) {
                //  Toast.makeText(MainActivity.this, data.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MagicAuctions.this, MagicDetail.class);
                intent.putExtra("Name", data.getCard_name());
                intent.putExtra("Desc", data.getDescription());
                intent.putExtra("Value", data.getValue());
                intent.putExtra("Image", data.getImage());

                startActivity(intent);

            }
        });


        recyclerView.setAdapter(magicAdapter);
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
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
