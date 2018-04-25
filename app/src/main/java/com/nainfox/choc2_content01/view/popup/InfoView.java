package com.nainfox.choc2_content01.view.popup;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;

import com.airbnb.lottie.LottieAnimationView;
import com.nainfox.choc2_content01.R;

/**
 * Created by yjk on 2018. 4. 17..
 */

public class InfoView extends Dialog {

    private LottieAnimationView loadingView;

    public InfoView(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.dialog_info);

        loadingView = (LottieAnimationView) findViewById(R.id.loadingView);

    }




}
