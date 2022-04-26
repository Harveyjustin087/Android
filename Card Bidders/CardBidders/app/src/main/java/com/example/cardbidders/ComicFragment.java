/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Comic Fragment
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//This class creates the fragment to display information about Comic Book Cards on the About page
public class ComicFragment extends Fragment {
    /**
     * Creates the Fragment
     * @param inflater  Parameter 1.
     * @param container Parameter 2.
     * @param savedInstanceState  Parameter 3.
     * @return boolean
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic, container, false);
    }
}