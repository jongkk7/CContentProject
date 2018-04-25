package com.nainfox.choc2_content01.view;

import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.nainfox.choc2_content01.R;
import com.nainfox.choc2_content01.util.DateFactory;
import com.nainfox.choc2_content01.util.WeatherFactory;
import com.nainfox.choc2_content01.view.popup.InfoView;
import com.nainfox.choc2_content01.view.popup.SelfView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "### MainActivity";

    private DateFactory dateFactory;
    private WeatherFactory weatherFactory;

    private RelativeLayout mainLayout;

    private TextView temTextView, weatherTextView;
    private ImageView skyImageView;
    private ImageView catImageView;
    private LottieAnimationView item01, item02, item03;
    private InfoView infoView;
    private SelfView selfView;

    private Random random;
    private boolean _item01, _item02, _item03;
    private int itemCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    @Override
    protected void onResume() {
        super.onResume();

        init();
    }

    private void init(){
        dateFactory = new DateFactory();;
        weatherFactory = new WeatherFactory();
        infoView = new InfoView(this);

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);

        initTopLayout();
        initBottomLayout();
        initMidLayout();
        initMenu();
    }

    private void initTopLayout(){
        temTextView = (TextView) findViewById(R.id.temperature_textview);
        weatherTextView = (TextView) findViewById(R.id.weather_textview);
        skyImageView = (ImageView) findViewById(R.id.sky_imageview);

        int hour = dateFactory.getHour();
        if(hour > 6 && hour < 18){
            mainLayout.setBackgroundResource(R.drawable.background_sun);
            skyImageView.setBackgroundResource(R.drawable.icon_sun);
        }else{
            mainLayout.setBackgroundResource(R.drawable.background_moon);
            skyImageView.setBackgroundResource(R.drawable.icon_moon);
        }

        temTextView.setText(""+weatherFactory.getTemperature());
        weatherTextView.setText(weatherFactory.getTypeText());
    }

    private void initMidLayout(){
        catImageView = (ImageView) findViewById(R.id.cat_imageview);
        catImageView.setBackgroundResource(weatherFactory.getTypeImage());

        initAnimItem();
        initAnim();
    }

    // 아이템 박스 초기화
    private void initAnimItem(){
        random = new Random();
        _item01 = false;
        _item02 = false;
        _item03 = false;

        item01 = (LottieAnimationView) findViewById(R.id.item01);
        item02 = (LottieAnimationView) findViewById(R.id.item02);
        item03 = (LottieAnimationView) findViewById(R.id.item03);

        item01.setAnimation(R.raw.item01);
        item02.setAnimation(R.raw.item01);
        item03.setAnimation(R.raw.item01);

        item01.playAnimation();
        item02.playAnimation();
        item03.playAnimation();

        // true = 보여지고 있음 , false = 보여지지 않음
        item01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_item01 = false) return;
                _item01 = false;
                item01.setVisibility(View.INVISIBLE);
                infoView.show();
            }
        });

        item02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_item02 = false) return;
                _item02 = false;
                item02.setVisibility(View.INVISIBLE);
                infoView.show();
            }
        });

        item03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_item03 = false) return;
                _item03 = false;
                item03.setVisibility(View.INVISIBLE);
                infoView.show();
            }
        });

        item01.setVisibility(View.INVISIBLE);
        item02.setVisibility(View.INVISIBLE);
        item03.setVisibility(View.INVISIBLE);
    }

    // 캐릭터 초기화, setting
    private void initAnim(){
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(weatherFactory.getTypeImage());
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(weatherFactory.getTypeClickImage());

        final int duraion = 150;

        final AnimationDrawable mAnimation = new AnimationDrawable();
        mAnimation.addFrame(frame1, duraion);
        mAnimation.addFrame(frame2, duraion);
        mAnimation.addFrame(frame1, duraion);
        mAnimation.addFrame(frame2, duraion);
        mAnimation.addFrame(frame1, duraion);
        mAnimation.addFrame(frame2, duraion);
        catImageView.setBackgroundDrawable(mAnimation);

        catImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mAnimation.isRunning()){
                    mAnimation.start();
                    startItem();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mAnimation.stop();
                        }
                    }, duraion * 6 );
                }
            }
        });
    }

    // 정보 아이템박스 생성
    private void startItem(){
        itemCount = random.nextInt(3)+1;
        Log.d(TAG, "count : " + itemCount);

        switch (itemCount){
            case 1:
                if(_item01 == true) return;
                item01.setVisibility(View.VISIBLE);
                _item01 = !_item01;
                break;
            case 2:
                if(_item02 == true) return;
                item02.setVisibility(View.VISIBLE);
                _item02 = !_item02;
                break;
            case 3:
                if(_item03 == true) return;
                item03.setVisibility(View.VISIBLE);
                _item03 = !_item03;
                break;
        }
    }


    private void initBottomLayout(){

    }

    // 메뉴버튼 초기화
    private void initMenu(){
        selfView = new SelfView(this);
        Button menuButton = (Button) findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfView.show();
            }
        });

    }


}
