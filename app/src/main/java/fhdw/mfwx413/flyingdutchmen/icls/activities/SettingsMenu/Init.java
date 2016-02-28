package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.app.Activity;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.*;
import fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Data;
import fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.EventToListenerMapping;
import fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Gui;

/**
 * Responsibility: Daniel zur Linden
 */
public class Init extends Activity {
    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    private void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogic(mData, mGui, this);
    }

    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    private void initGui() {
        mGui = new Gui(this);
    }

    private void initData(Bundle savedInstanceState){
        mData = new Data(this, savedInstanceState);
    }

    //save data if activity stops
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataFromBundle(outState);
        super.onSaveInstanceState(outState);
    }

}