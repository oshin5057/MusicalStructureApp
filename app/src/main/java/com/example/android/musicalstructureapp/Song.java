package com.example.android.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    private String mSong;
    private String mSinger;
    private int mSongId;

    public Song(String song, String singer, int songId){
        mSong = song;
        mSinger = singer;
        mSongId = songId;
    }

    protected Song(Parcel in) {
        mSong = in.readString();
        mSinger = in.readString();
        mSongId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {

            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {

            return new Song[size];
        }
    };

    public String getSong(){

        return mSong;
    }
    public String getSinger(){

        return mSinger;
    }

    public int getSongId()
    {
        return mSongId;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSong);
        parcel.writeString(mSinger);
        parcel.writeInt(mSongId);
    }
}
