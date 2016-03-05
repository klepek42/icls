package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;
import android.os.Bundle;

/**
 * Responsibility: Jonas Krabs
 */
public class Init extends Activity {

// Pascal Heß 24.02.2016
//  public Data mData; replaced with:
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

    //initialize the ApplicationLogic
    private void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogic(mData, mGui, this);
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

    // Back to Activity ChooseFile (back button)
    @Override
    public void onBackPressed() {
        mApplicationLogic.goBackToChooseFile();
    }
}