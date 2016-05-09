package com.worldsoko.sokopay.Application;

import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.worldsoko.sokopay.MenuMaps;
import com.worldsoko.sokopay.Models.HomeMenus;


public class SokoApp extends android.app.Application  {

    private static Context context;
    MenuMaps menuMaps;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        menuMaps=new MenuMaps();

        initializeDB();
        menuMaps.InitStaticTables();

    }
    public static Context getAppContext() {
        return context;
    }


    protected void initializeDB() {
        Configuration.Builder configurationBuilder = new Configuration.Builder(this);

        configurationBuilder.addModelClass(HomeMenus.class);
        ActiveAndroid.initialize(configurationBuilder.create());
    }
}
