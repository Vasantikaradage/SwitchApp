package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    // Shared Preferences
    private SharedPreferences pref;

    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    // Context
    private Context mContext;

    // Shared pref mode
    private int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "switchAppPref";
    public static final String REMEMBER_ME = "remember_me";


    public static final String SWITCH_ID = "id";

    // Constructor
    public SessionManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

   /* public void createOpenSession(String id) {
        editor.putBoolean(REMEMBER_ME, true);
        editor.putString(SWITCH_ID, id);

        // commit changes
        editor.commit();
    }

    public HashMap<String, String>  getSession() {

        HashMap<String, String> user = new HashMap<String, String>();
        user.put(SWITCH_ID, pref.getString(SWITCH_ID, null));
        return user;
    }*/

    public String getSession(Context context, String defaultLanguage) {

        return pref.getString(SWITCH_ID, defaultLanguage);
    }

    public void createOpenSession(Context context, String language) {
        editor.putString(SWITCH_ID, language);
        editor.apply();
    }






}
