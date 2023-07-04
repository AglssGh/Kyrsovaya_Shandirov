package com.mirea.kt.android.kyrsovaya_shandirov;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CalcInfoResponse {
    @SerializedName("result_code")
    @Expose
    private int result;


    public int getResult() {
        return result;
    }





}