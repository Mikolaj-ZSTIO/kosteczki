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

//        kosc1 = findViewById(R.id.kostka1);
//        kosc2 = findViewById(R.id.kostka2);
//        kosc3 = findViewById(R.id.kostka3);
//        kosc4 = findViewById(R.id.kostka4);
//        kosc5 = findViewById(R.id.kostka5);
//
//        Kosc Kostka1 = new Kosc();
//        Kosc Kostka2 = new Kosc();
//        Kosc Kostka3 = new Kosc();
//        Kosc Kostka4 = new Kosc();
//        Kosc Kostka5 = new Kosc();
//
//        Kostka1.view = kosc1;
//        Kostka2.view = kosc2;
//        Kostka3.view = kosc3;
//        Kostka4.view = kosc4;
//        Kostka5.view = kosc5;
//
//
//        kosci.add(Kostka1);
//        kosci.add(Kostka2);
//        kosci.add(Kostka3);
//        kosci.add(Kostka4);
//        kosci.add(Kostka5);
//
//        for (Kosc kosc : kosci) {
//            kosc.view.setOnClickListener(view -> kosc.klikniecie_kosci());
//        }

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

//            switch (kosc.wartosc) {
//                case 1:
//                    kosc.view.setImageResource(R.drawable.kosc1);
//                    break;
//                case 2:
//                    kosc.view.setImageResource(R.drawable.kosc2);
//                    break;
//                case 3:
//                    kosc.view.setImageResource(R.drawable.kosc3);
//                    break;
//                case 4:
//                    kosc.view.setImageResource(R.drawable.kosc4);
//                    break;
//                case 5:
//                    kosc.view.setImageResource(R.drawable.kosc5);
//                    break;
//                case 6:
//                    kosc.view.setImageResource(R.drawable.kosc6);
//                    break;
//            }
        }

        wynik.setText(String.valueOf(suma));
    }
}