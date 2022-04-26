/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Pokemon Auctions Pages
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
// this class is for the Recyclerview Pokemon Cards Auctions to display and for navigation
public class PokemonAuctions extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Auction> pokemonArrayList;
    private AuctionMagicAdapter pokemonAdapter;
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

        pokemonArrayList = new ArrayList<>();

        pokemonArrayList.add(new Auction("Machamp", "First Edition Shadowless Holographic Machamp", 5000, R.drawable.machamp));
        pokemonArrayList.add(new Auction("Venusaur", "1999 Pokemon First Edition Venusaur", 8000, R.drawable.venusaur));
        pokemonArrayList.add(new Auction("Raichu", "Extremely Rare Pre-Release Raichu", 10000, R.drawable.raichu));
        pokemonArrayList.add(new Auction("Charizard", "Shadowless First Edition Charizard", 50000, R.drawable.charizard));
        pokemonArrayList.add(new Auction("Blastoise", "Shadowless First Edition Holographic Blastoise", 10000, R.drawable.blastoise));


        pokemonAdapter = new AuctionMagicAdapter(pokemonArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        pokemonAdapter.setOnItemClickListener(new AuctionMagicAdapter.ClickListener<Auction>() {
            /**
             * this method moves the user to the details of the selected auction
             * passing the intent and data of the auction.
             * @param data Parameter 1.
             * @return void
             */
            @Override
            public void onItemClick(Auction data) {
                //  Toast.makeText(MainActivity.this, data.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PokemonAuctions.this, MagicDetail.class);
                intent.putExtra("Name", data.getCard_name());
                intent.putExtra("Desc", data.getDescription());
                intent.putExtra("Value", data.getValue());
                intent.putExtra("Image", data.getImage());

                startActivity(intent);
            }
        });

        recyclerView.setAdapter(pokemonAdapter);
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
