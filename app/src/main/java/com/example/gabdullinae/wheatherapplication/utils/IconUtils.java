package com.example.gabdullinae.wheatherapplication.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.example.gabdullinae.wheatherapplication.R;

/**
 * Created by Elvira Gabdullina
 * on 15.11.2016, 14:44.
 */

public class IconUtils {
    public static Drawable prettyIcon(Context context, String path) {
        Drawable image = null;
        switch (path) {
            case "01d":
                image = ContextCompat.getDrawable(context, R.drawable.solnechno);
                break;
            case "02d":
                image = ContextCompat.getDrawable(context, R.drawable.solnce_s_oblakami);
                break;
            case "03d":
                image = ContextCompat.getDrawable(context, R.drawable.oblako);
                break;
            case "04d":
                image = ContextCompat.getDrawable(context, R.drawable.oblaka);
                break;
            case "09d":
                image = ContextCompat.getDrawable(context, R.drawable.bolshie_osadki);
                break;
            case "10d":
                image = ContextCompat.getDrawable(context, R.drawable.nebolshoj_dozhd_dnem);
                break;
            case "11d":
                image = ContextCompat.getDrawable(context, R.drawable.groza_s_dozhdem_dnem);
                break;
            case "13d":
                image = ContextCompat.getDrawable(context, R.drawable.snezhinki);
                break;
            case "50d":
                image = ContextCompat.getDrawable(context, R.drawable.tuman);
                break;
            case "01n":
                image = ContextCompat.getDrawable(context, R.drawable.bolshaja_luna);
                break;
            case "02n":
                image = ContextCompat.getDrawable(context, R.drawable.solnechno);
                break;
            case "03n":
                image = ContextCompat.getDrawable(context, R.drawable.oblako);
                break;
            case "04n":
                image = ContextCompat.getDrawable(context, R.drawable.oblaka);
                break;
            case "09n":
                image = ContextCompat.getDrawable(context, R.drawable.bolshie_osadki);
                break;
            case "10n":
                image = ContextCompat.getDrawable(context, R.drawable.kapli_nochyu);
                break;
            case "11n":
                image = ContextCompat.getDrawable(context, R.drawable.groza_s_dozhdem_nochyu);
                break;
            case "13n":
                image = ContextCompat.getDrawable(context, R.drawable.snezhinki);
                break;
            case "50n":
                image = ContextCompat.getDrawable(context, R.drawable.tuman);
                break;
            default:
                break;
        }
        return image;
    }
}
