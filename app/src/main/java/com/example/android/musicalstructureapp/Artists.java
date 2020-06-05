package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Artists extends AppCompatActivity implements PlayListener {
    ArrayList<Song> songs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        songs = new ArrayList<Song>();
        songs.add(new Song("I Wanna Love You", "Akon",R.raw.i_wana_love_you));
        songs.add(new Song("Beautiful","Akon",R.raw.beautiful));
        songs.add(new Song("Shake It Off","Taylor Swift",R.raw.shake_it_off));
        songs.add(new Song("Blank Space","Taylor Swift",R.raw.blank_space));
        songs.add(new Song("Lover","Taylor Swift",R.raw.lover));
        songs.add(new Song("You Belong To Me","Taylor Swift",R.raw.you_belong_to_me));

        SongAdapter adaptor = new SongAdapter(this, songs, this);
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
