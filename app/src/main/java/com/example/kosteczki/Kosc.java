package com.example.kosteczki;

import android.widget.ImageView;

public class Kosc {
    ImageView view;
    int wartosc;
    boolean dostepna = true;

    public void klikniecie_kosci() {
        if (dostepna) {
            dostepna = false;
            view.setAlpha(0.5f);
        } else {
            dostepna = true;
            view.setAlpha(1f);
        }
    }
}
