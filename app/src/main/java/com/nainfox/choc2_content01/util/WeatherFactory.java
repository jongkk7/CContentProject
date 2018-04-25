package com.nainfox.choc2_content01.util;

import com.nainfox.choc2_content01.R;
import com.nainfox.choc2_content01.data.WeatherType;

import java.util.Random;

/**
 * Created by yjk on 2018. 4. 18..
 */

public class WeatherFactory {
    private Random random;
    private int type = 1;

    public WeatherFactory(){
        random = new Random();
        type = random.nextInt(6)+1;
    }

    public int getTypeImage(){
        int res = R.drawable.cat_good1;
        switch (type){
            case 1:
                res = WeatherType.GOOD;
                break;
            case 2:
                res = WeatherType.DUSK;
                break;
            case 3:
                res = WeatherType.RAIN;
                break;
            case 4:
                res = WeatherType.THUNDER;
                break;
            case 5:
                res = WeatherType.UV;
                break;
            case 6:
                res = WeatherType.WINDY;
                break;
            default:
                res = WeatherType.GOOD;
                break;
        }

        return res;
    }
    public int getTypeClickImage(){
        int res = R.drawable.cat_good2;
        switch (type){
            case 1:
                res = WeatherType.GOOD_CLICK;
                break;
            case 2:
                res = WeatherType.DUSK_CLICK;
                break;
            case 3:
                res = WeatherType.RAIN_CLICK;
                break;
            case 4:
                res = WeatherType.THUNDER_CLICK;
                break;
            case 5:
                res = WeatherType.UV_CLICK;
                break;
            case 6:
                res = WeatherType.WINDY_CLICK;
                break;
            default:
                res = WeatherType.GOOD_CLICK;
                break;
        }

        return res;
    }
    public String getTypeText(){
        String res = "맑음";
        switch (type){
            case 1:
                res = "맑음";
                break;
            case 2:
                res = "미세먼지";
                break;
            case 3:
                res = "비";
                break;
            case 4:
                res = "천둥";
                break;
            case 5:
                res = "자외선";
                break;
            case 6:
                res = "바람많음";
                break;
            default:
                res = "맑음";
                break;
        }
        return res;
    }
    public int getTemperature(){
        return 15 + random.nextInt(20);
    }

}
