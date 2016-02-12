package com.oyeplay.android.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.oyeplay.android.R;

/**
 * Created by hubbelsoftware on 1/16/16.
 */
public class Welcome extends AppIntro {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro_1));
        addSlide(SampleSlide.newInstance(R.layout.intro_2));
        addSlide(SampleSlide.newInstance(R.layout.intro_3));
        addSlide(SampleSlide.newInstance(R.layout.intro_4));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.TRANSPARENT);
        setSeparatorColor(Color.TRANSPARENT);

        // Hide Skip/Done button.
        showSkipButton(true);
        showStatusBar(false);
        setProgressButtonEnabled(true);
        setProgressButtonEnabled(true);


        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest.


        //setFadeAnimation();
        setProgressBarIndeterminate(true);
        setZoomAnimation();
    }

    @Override
    public void onSkipPressed() {
login();
    }


    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        login();

    }

    @Override
    public void onSlideChanged() {

    }

    public void login() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
