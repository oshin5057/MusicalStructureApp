package com.example.android.musicalstructureapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PlaySong extends AppCompatActivity implements View.OnClickListener {

    Button play, pause, stop;
    Song song;
    MediaPlayer music;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        song = getIntent().getParcelableExtra("song_data");
        play = (Button)findViewById(R.id.play_btn);
        play.setOnClickListener(this);
        pause = (Button)findViewById(R.id.pause_btn);
        pause.setOnClickListener(this);
        stop = (Button)findViewById(R.id.stop_btn);
        stop.setOnClickListener(this);

    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_btn:
                if (music == null){
                    music = MediaPlayer.create(this,song.getSongId());
                    music.start();
                }
                else if (!music.isPlaying()){
                    music.seekTo(pauseCurrentPosition);
                    music.start();
                }
                break;
            case R.id.pause_btn:
                if (music != null) {
                    music.pause();
                    pauseCurrentPosition = music.getCurrentPosition();
                }
                break;
            case R.id.stop_btn:
                if (music != null) {
                    music.stop();
                    music = null;
                }
                break;
        }
    }
}
