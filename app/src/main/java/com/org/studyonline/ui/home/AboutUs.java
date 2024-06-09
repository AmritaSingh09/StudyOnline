package com.org.studyonline.ui.home;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.org.studyonline.R;

public class AboutUs extends AppCompatActivity {

    TextView app_version, ads, contact_us, connect_fb, connect_twitter, connect_youtube,
            connect_instagram, rate_playstore, share, contact_developer;

    PackageManager packageManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        initViews();
        packageManager = getPackageManager();


        ads.setOnClickListener(view ->{

        });

        contact_us.setOnClickListener(view ->{

        });
        connect_fb.setOnClickListener(view ->{

        });
        connect_twitter.setOnClickListener(view ->{

        });
        connect_youtube.setOnClickListener(view ->{

        });
        connect_instagram.setOnClickListener(view ->{

        });
        rate_playstore.setOnClickListener(view ->{

        });
        share.setOnClickListener(view ->{

        });
        contact_developer.setOnClickListener(view ->{

        });


    }

    private synchronized void initViews() {
        app_version = findViewById(R.id.app_version);
        ads = findViewById(R.id.ads);
        contact_us = findViewById(R.id.contact_us);
        connect_fb = findViewById(R.id.connect_fb);
        connect_twitter = findViewById(R.id.connect_twitter);
        connect_youtube = findViewById(R.id.connect_youtube);
        connect_instagram = findViewById(R.id.connect_instagram);
        rate_playstore = findViewById(R.id.rate_playstore);
        share = findViewById(R.id.share);
        contact_developer = findViewById(R.id.contact_developer);
        //app_version = findViewById(R.id.app_version);
    }
}