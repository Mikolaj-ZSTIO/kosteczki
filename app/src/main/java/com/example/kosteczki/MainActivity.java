package com.example.kosteczki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView wynik;
    private Button rzut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wynik = findViewById(R.id.wynik);
        rzut = findViewById(R.id.rzut);

        int[] ids = {
                R.id.kostka1,
                R.id.kostka2,
                R.id.kostka3,
                R.id.kostka4,
                R.id.kostka5,
        };

        List<Kosc> kosci = new ArrayList<>();

        for (int id : ids) {
            Kosc kosc = new Kosc();
            kosc.view = findViewById(id);
            kosci.add(kosc);

            kosc.view.setOnClickListener(view -> kosc.klikniecie_kosci());
        }

        rzut.setOnClickListener(view -> rzut(kosci));
    }

    private void rzut(List<Kosc> kosci) {
        Random random = new Random();

        int[] obrazki = {
                R.drawable.kosc1,
                R.drawable.kosc2,
                R.drawable.kosc3,
                R.drawable.kosc4,
                R.drawable.kosc5,
                R.drawable.kosc6,
        };

        int suma = 0;

        for (Kosc kosc : kosci) {
            if (kosc.dostepna) {
                kosc.wartosc = random.nextInt(6) + 1;
                kosc.view.setImageResource(obrazki[kosc.wartosc - 1]);
            }

            suma += kosc.wartosc;
        }

        wynik.setText(String.valueOf(suma));
    }
}