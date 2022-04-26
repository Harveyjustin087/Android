/*
* PROG3210 Final Assignment
* Card Bidders 2021
* By: Justin Harvey
* About Page
* Professor: Pratiksha Mahendrabhai Raval
* November/December 2021
* */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//This Class Allows for Navigation from the Main Activity to
//the different bid type activities.
public class About extends AppCompatActivity {

    private Button btn_sports,btn_magic,btn_comics,btn_pokemon;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btn_sports = (Button) findViewById(R.id.btn_about_sports);
        btn_magic = (Button) findViewById(R.id.btn_about_magic);
        btn_comics = (Button) findViewById(R.id.btn_about_comics);
        btn_pokemon = (Button) findViewById(R.id.btn_about_pokemon);
        // Button Event Listener for Navigation to the Magic Cards Auctions Page
        btn_magic.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows the Magic Cards Information Fragment
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                replaceFragmentMagic(new Fragment());
            }
        });
        // Button Event Listener for Navigation to the Sports Cards Auctions Page
        btn_sports.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows the Sports Cards Information Fragment
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                replaceFragmentSports(new Fragment());
            }
        });
        // Button Event Listener for Navigation to the Comic Book Cards Auctions Page
        btn_comics.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows the Comic Book Cards Information Fragment
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                replaceFragmentComics(new Fragment());
            }
        });
        // Button Event Listener for Navigation to the Pokemon Cards Auctions Page
        btn_pokemon.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows the Pokemon Cards Information Fragment
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                replaceFragmentPokemon(new Fragment());
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
    /**
     * Show Fragment for Magic Cards
     * @param fragment Parameter 1.
     * @return boolean
     */
    private void replaceFragmentMagic(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MagicFragment()).commit();
    }
    /**
     * Show Fragment for Sports Cards
     * @param fragment Parameter 1.
     * @return boolean
     */
    private void replaceFragmentSports(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new SportsFragment()).commit();
    }
    /**
     * Show Fragment for Comic Book Cards
     * @param fragment Parameter 1.
     * @return boolean
     */
    private void replaceFragmentComics(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ComicFragment()).commit();
    }
    /**
     * Show Fragment for Pokemon Cards
     * @param fragment Parameter 1.
     * @return boolean
     */
    private void replaceFragmentPokemon(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new PokemonFragment()).commit();
    }

}