package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

class SongAdapter extends ArrayAdapter<Song> {

    PlayListener listener;

    public SongAdapter(Activity context, ArrayList<Song> songs, PlayListener listener){
        super(context,0,songs);
        this.listener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_list, parent, false);
        }

        Song currentSong = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        songTextView.setText(currentSong.getSong());

        TextView singerTextView = (TextView) listItemView.findViewById(R.id.singer_text_view);
        singerTextView.setText(currentSong.getSinger());

        Button playButton = (Button) listItemView.findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPlayClick(position);
            }
        });

        return listItemView;
    }

}
