package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class HitSongs extends AppCompatActivity implements PlayListener{
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        songs = new ArrayList<Song>();
        songs.add(new Song("Senorita","Camila Cabello",R.raw.senotita));
        songs.add(new Song("Havana", "Camila Cabello",R.raw.havana));
        songs.add(new Song("I'll Always Be Right There","Bryan adams",R.raw.i_ll_be_rith_there));
        songs.add(new Song("I Wanna Love You", "Akon", R.raw.i_wana_love_you));
        songs.add(new Song("Beautiful","Akon",R.raw.beautiful));
        songs.add(new Song("Hero","Enrique Lglesias",R.raw.hero));
        songs.add(new Song("Shake It Off","Taylor Swift",R.raw.shake_it_off));

        SongAdapter adaptor = new SongAdapter(this, songs, new PlayListener() {
            @Override
            public void onPlayClick(int position) {
                Intent playIntent = new Intent(HitSongs.this,PlaySong.class);
                playIntent.putExtra("song_data",songs.get(position));
                startActivity(playIntent);

            }
        });
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adaptor);

    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onPlayClick(int position) {
        Intent playIntent = new Intent(this, PlaySong.class);
        playIntent.putExtra("song_data",songs.get(position));
        startActivity(playIntent);
    }
}
