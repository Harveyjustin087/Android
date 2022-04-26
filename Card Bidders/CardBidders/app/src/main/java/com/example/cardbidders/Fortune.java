/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Fortune Page and Threader Class
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
// This class is for the Fortune teller pages that uses the threader class to present the user with a
// random fortune
public class Fortune extends AppCompatActivity {

    private Button btn_fort;
    private ImageView img_fort;
    private TextView txt_fortune;
    Random rand = new Random();
    int upperBound = 10;
    int randomNum = rand.nextInt(upperBound);
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        btn_fort = (Button) findViewById(R.id.btn_get_fortune);
        img_fort = (ImageView) findViewById(R.id.img_fortune);
        txt_fortune = (TextView) findViewById(R.id.fortuneFinal);

        btn_fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (randomNum <= 3){
                    new Threader().execute("https://www.alittlesparkofjoy.com/wp-content/uploads/2020/03/the-fool-tarot-card.webp");
                    txt_fortune.setText("THE FOOL" +"\n"+"To see the Fool tarot card generally indicates that you are on the verge of an unexpected and exciting new adventure. This may require you to take a blind leap of faith.");
                }
                else if(randomNum > 4 || randomNum <= 7){
                    new Threader().execute("https://www.alittlesparkofjoy.com/wp-content/uploads/2020/10/wheel-of-fortune-tarot-card.webp");
                    txt_fortune.setText("FORTUNE" +"\n"+"Whether you believe in destiny or not, things are lining up for your benefit. Think of surprising offers and new opportunities. Your personal vision will also increase as life’s tempo cranks up.");
                }
                else{
                    new Threader().execute("https://www.alittlesparkofjoy.com/wp-content/uploads/2020/10/death-tarot-card-image.webp");
                    txt_fortune.setText("DEATH" +"\n"+"For many readings, the Death tarot card signifies completing a chapter, putting the past behind you, and cutting out what is unnecessary. It can also signify a transition or middle ground between one phase of life and the next.");

                }
            }
        });
    }

    // This class loads one of 3 images from a thread
    public class Threader extends AsyncTask<String,Void, Bitmap> {

        HttpURLConnection httpURLConnection;
        /**
         * this method shows a toast before executing
         * @return void
         */
        @Override
        protected void onPreExecute() {
            Toast.makeText(Fortune.this, "Generating Fortune", Toast.LENGTH_SHORT).show();
        }
        /**
         * this method runs in the background generating the images from
         * a website
         * @param strings Parameter 1.
         * @return Bitmap
         */
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream input = new BufferedInputStream(httpURLConnection.getInputStream());
                Bitmap imgFortune = BitmapFactory.decodeStream(input);
                Thread.sleep(5000);
                return imgFortune;
            } catch (Exception e) {
                Toast.makeText(Fortune.this, "The Future is Hazy", Toast.LENGTH_SHORT).show();

            }
            return null;
        }
        /**
         * this method shows a toast if the image loading is successful or not
         * @return void
         */
        @Override
        protected void onPostExecute(Bitmap bitmap){
            if(bitmap!=null){
                img_fort.setImageBitmap(bitmap);
                Toast.makeText(Fortune.this,"Fortune Found!!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(Fortune.this,"The Visions Are Clouded. I Cannot Make Predictions Just Now",Toast.LENGTH_SHORT).show();
            }
        }
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
}