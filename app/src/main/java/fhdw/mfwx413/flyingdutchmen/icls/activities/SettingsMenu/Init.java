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
    public fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Data mData;
    private fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Gui mGui;
    private fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initData();
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    private void initApplicationLogic(){
        mApplicationLogic = new fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.ApplicationLogic(mData, mGui, this);
    }

    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    private void initGui() {
        mGui = new Gui(this);
    }

    private void initData(){
        mData = new Data(this);
    }

}