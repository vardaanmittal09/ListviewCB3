package com.example.android.listviewcb3;

import android.widget.EditText;

import java.util.Date;

/**
 * Created by lenovo on 6/11/2017.
 */

public class Movies {

    EditText name;
    EditText Release_Year;
    EditText Rating;

    public Movies(EditText name, EditText release_year, EditText rating) {
        this.name = name;
        Release_Year = release_year;
        Rating = rating;
    }

    public EditText getName() {
        return name;
    }

    public EditText getRelease_Date() {
        return Release_Year;
    }

    public EditText getRating() {
        return Rating;
    }
}

