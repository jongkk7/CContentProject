package com.nainfox.choc2_content01.view.popup;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.nainfox.choc2_content01.R;

/**
 * Created by yjk on 2018. 4. 17..
 */

public class SelfView extends Dialog {

    private TextView q;
    private TextView a01,a02,a03,a04;
    private CheckBox a01_checkbox,a02_checkbox,a03_checkbox,a04_checkbox;

    private LottieAnimationView arrowButton;

    public SelfView(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.dialog_self);

        init();

    }

    private void init(){
        q = (TextView) findViewById(R.id.q);
        a01 = (TextView) findViewById(R.id.a01);
        a02 = (TextView) findViewById(R.id.a02);
        a03 = (TextView) findViewById(R.id.a03);
        a04 = (TextView) findViewById(R.id.a04);

        a01_checkbox = (CheckBox) findViewById(R.id.a01_checkbox);
        a02_checkbox = (CheckBox) findViewById(R.id.a02_checkbox);
        a03_checkbox = (CheckBox) findViewById(R.id.a03_checkbox);
        a04_checkbox = (CheckBox) findViewById(R.id.a04_checkbox);

        arrowButton = (LottieAnimationView) findViewById(R.id.self_arrow);
        arrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrowButton.setProgress(0);
                arrowButton.playAnimation();
            }
        });
    }




}
