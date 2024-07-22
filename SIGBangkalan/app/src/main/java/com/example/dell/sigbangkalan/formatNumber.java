package com.example.dell.sigbangkalan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class formatNumber {
    public String formatNumber(String s){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formattedString = formatter.format(Long.parseLong(s));
        return formattedString;
    }
    public String formatNumber2(String s){
        return s.replace(".", ",");
    }
}
