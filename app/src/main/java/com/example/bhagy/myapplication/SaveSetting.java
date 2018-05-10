package com.example.bhagy.myapplication;

import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by bhagy on 5/9/2018.
 */

public class SaveSetting {

    public  static String name = null;
    public static String email = null;
    private static final String DEFAULT_NAME = "NAME";
    public static final String DEFAULT_EMAIL = "EMAIL";

    private SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor prefEditor = null;

    public  static SaveSetting saveSetting = null;
    private Context mContext = null;


    // Create instance of ScanSettings

    public static SaveSetting getInstance() {

        if (saveSetting == null) {
            saveSetting = new SaveSetting();
        }

        return saveSetting;

    }

    public void initSetting(Context context){
        mContext = context;

        if (sharedPreferences == null) {
            resetSettings(context);
        } else {
            name = sharedPreferences.getString("name", DEFAULT_NAME);
            email = sharedPreferences.getString("email", DEFAULT_EMAIL);
        }
    }
    public void saveDetails(){
        prefEditor.putString("name", name);
        prefEditor.putString("email", email);
        prefEditor.apply();

    }
    public void resetSettings(Context context) {
        mContext = context;
        if (sharedPreferences == null) {
            sharedPreferences = mContext.getSharedPreferences("details", Context.MODE_PRIVATE);
        }

        if (prefEditor == null) {
            prefEditor = sharedPreferences.edit();
        }
    }
    public String getName(){
       // sharedPreferences = mContext.getSharedPreferences("Details", MODE_PRIVATE);
        name = sharedPreferences.getString("name", DEFAULT_NAME);
         return "".equals(name)||name==null?DEFAULT_NAME:name;

    }

    public String getEmail(){
        email = sharedPreferences.getString("email",DEFAULT_EMAIL );
        return "".equals(email)||email==null?DEFAULT_EMAIL:email;

    }

    public void clear(){
        prefEditor.putString("name","");
        prefEditor.putString("email", "");
        prefEditor.apply();
    }
}
