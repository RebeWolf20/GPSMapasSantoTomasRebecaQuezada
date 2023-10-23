package com.example.rebecaquezada;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoUST extends AppCompatActivity {

    private VideoView videoUTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_ust);

        videoUTS= findViewById(R.id.videoView);
        videoUTS.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.santo));
        MediaController media = new MediaController(this);
        videoUTS.setMediaController(media);
        media.setAnchorView(videoUTS);
        videoUTS.start();
    }
}
