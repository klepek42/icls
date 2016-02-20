package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;
import android.os.Bundle;

/**
 * Responsibility: Jonas Krabs
 */
public class Init extends Activity {

    public Data mData;
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
        mApplicationLogic = new ApplicationLogic(mData, mGui);
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataFromBundle(outState);
        super.onSaveInstanceState(outState);
    }
}