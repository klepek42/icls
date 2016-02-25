package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
 */
public class Init extends Activity {

    public Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    // Initialize ApplicationLogic
    private void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogic(mData, mGui, this);
    }

    // Initialize EventToListenerMapping
    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    // Initialize Gui
    private void initGui() {
        mGui = new Gui(this);
    }

    // Initialize Data with saved data
    private void initData(Bundle savedInstanceState){
        mData = new Data(this, savedInstanceState);
    }

    // Save Data when activity stops
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataFromBundle(outState);
        super.onSaveInstanceState(outState);
    }

    // Back to layout_choose_file (back button)
    @Override
    public void onBackPressed() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }
}