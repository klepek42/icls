package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.os.Bundle;

/**
 * Responsibility: Pascal Heß
 */

public class Init extends Activity {

    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    //define what shall happen, when the application is started
    //the whole structure is initialized
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    //initialize the EventToListenerMapping
    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    //initialize the ApplicationLogic
    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogic(mData, mGui, this);
    }

    //initialize the GUI
    private void initGui() {
        mGui = new Gui(this);
    }

    //initialize the Data (with saved Data)
    private void initData(Bundle savedInstanceState) {
        mData = new Data(this, savedInstanceState);
    }

    //save data if activity stops
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataFromBundle(outState);
        super.onSaveInstanceState(outState);
    }

    //Back-Button pressed leads to nothing (standard back button)
    //this happens on purpose, the function of the button is deactivated here
    @Override
    public void onBackPressed() {
    }
}