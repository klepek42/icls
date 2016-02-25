package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.app.Activity;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.*;
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Data;
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.EventToListenerMapping;
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Gui;

/**
Responsibility: Daniel zur Linden
 */
public class Init extends Activity {

    public fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Data mData;
    private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Gui mGui;
    private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    //initialize the ApplicationLogic
    private void initApplicationLogic(){
        mApplicationLogic = new fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.ApplicationLogic(mData, mGui, this);
    }

    //initialize the EventToListenerMapping
    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    //initialize the Gui
    private void initGui() {
        mGui = new Gui(this);
    }

    //initialize the Data (with saved data)
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