/*
* PROG3210 Final Assignment
* Card Bidders 2021
* By: Justin Harvey
* Feedback Page
* Professor: Pratiksha Mahendrabhai Raval
* November/December 2021
* */
package com.example.cardbidders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.util.Pair;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
// This class is for actions on the Feedback page where users can leave feedback on the app.
public class Feedback extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar;
    private TextView txtSeek;
    private Button btnTime, btnSubmit;
    /**
     * this method creates the page actions and
     * listeners on creation.
     * @param savedInstanceState Parameter 1.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        btnTime = (Button) findViewById(R.id.btn_date_time);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        //Seek Bar Actions
        seekBar = (SeekBar) findViewById(R.id.ranking_seek);
        txtSeek = (TextView) findViewById(R.id.rating_total);
        seekBar.setOnSeekBarChangeListener(Feedback.this);
        int progress = seekBar.getProgress();
        txtSeek.setText(Integer.toString(progress));
        //Date-Time Picker actions
        MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select the Date & Time");
        final MaterialDatePicker materialDatePicker = builder.build();

        MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
                .setTitleText("Pick the Time")
                .setHour(12).setMinute(00).setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK).build();
        //Event Handler for Date/Time Picker button
        btnTime.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows the Date and Time Pickers
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                materialTimePicker.show(getSupportFragmentManager(), "Time Picker");
                materialDatePicker.show(getSupportFragmentManager(), "Date Picker");
            }
        });
        //Submit Button at the end of Feedback page's even handler thanking the user
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            /**
             * this method is for onClick actions
             * this shows an Alert Dialog Box
             * @param view Parameter 1.
             * @return void
             */
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(Feedback.this);
                alertDialogBuilder.setTitle("Thank you for your Feedback!!!");
                alertDialogBuilder.setIcon(R.drawable.cardicon);
                alertDialogBuilder.show();
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
    /**
     * Method to track changes to the Progress Bar
     * @param seekBar Parameter 1.
     * @param choice Parameter 2.
     * @param b Parameter 3.
     * @return boolean
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int choice, boolean b) {
        txtSeek.setText(Integer.toString(choice));
    }
    //Auto Generated Method not needed
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    //Auto Generated Method not needed
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

