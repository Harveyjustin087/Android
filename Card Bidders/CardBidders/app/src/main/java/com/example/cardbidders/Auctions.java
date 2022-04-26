package com.example.cardbidders;
/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Auctions Page
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//This class is for Navigation to the selected Auction type based on the chosen kind of card (Magic, Pokemon etc.)
public class Auctions extends AppCompatActivity {

    private Button btn_magic_auc,btn_sports_auc,btn_comics_auc,btn_pokemon_auc;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auctions);

        btn_magic_auc = (Button) findViewById(R.id.btn_magic);
        btn_sports_auc = (Button) findViewById(R.id.btn_sports);
        btn_comics_auc = (Button) findViewById(R.id.btn_comics);
        btn_pokemon_auc = (Button) findViewById(R.id.btn_pokemon);

        btn_magic_auc.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this moves to the Magic Card Auctions Activity Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MagicAuctions.class);
                startActivity(intent);
            }
        });

        btn_sports_auc.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this moves to the Sports Card Auctions Activity Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SportsAuctions.class);
                startActivity(intent);
            }
        });

        btn_comics_auc.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this moves to the Comic Book Card Auctions Activity Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ComicsAuctions.class);
                startActivity(intent);
            }
        });

        btn_pokemon_auc.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this moves to the Pokemon Card Auctions Activity Page
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PokemonAuctions.class);
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