package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView allSongs =(TextView) findViewById(R.id.all_songs);
        allSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allSongsIntent = new Intent(MainActivity.this,AllSongs.class);

                startActivity(allSongsIntent);
            }
        });

        TextView artists = (TextView) findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this,Artists.class);

                startActivity(artistsIntent);
            }
        });

        TextView hitSongs = (TextView) findViewById(R.id.hit_songs);
        hitSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hitSongsIntent = new Intent(MainActivity.this,HitSongs.class);

                startActivity(hitSongsIntent);
            }
        });
    }
}
