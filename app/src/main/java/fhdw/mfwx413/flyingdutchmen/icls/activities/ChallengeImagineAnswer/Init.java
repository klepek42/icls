package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.R;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
 */
public class Init extends Activity {

    // Member variables
    public Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    /** Actions to perform directly once the app has been started
     * Initializing the whole structure of the activity.
     * It contains the data, gui, applicationLogic and a mapping of events and listeners
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    // Initialize the ApplicationLogic
    private void initApplicationLogic(){
        mApplicationLogic = new ApplicationLogic(mData, mGui);
    }

    // Initialize the mapping between the events and listeners
    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    // Initialize the graphical user interface and containing elements
    private void initGui() {
        mGui = new Gui(this);
    }

    // Initialize Data with saved data
    private void initData(Bundle savedInstanceState){
        mData = new Data(this, savedInstanceState);
    }

    // Save Data when the activity stops
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mData.saveDataFromBundle(outState);
        super.onSaveInstanceState(outState);
    }

    // Back button action to activity chooseFile
    @Override
    public void onBackPressed() {
        mApplicationLogic.onButtonAbortClicked();
    }
}