package fhdw.mfwx413.flyingdutchmen.icls.activities.NoIndexCardsAvailable;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Max on 05.03.2016.
 * Responsibility: Max Schumacher
 * Updated by Max on 05.03.2016
 */
public class Init extends Activity {

    private Data mData;
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

    private void initData(Bundle savedInstanceState) {
        mData = new Data(this, savedInstanceState);
    }

    private void initGui() {
        mGui = new Gui(this);
    }

    private void initApplicationLogic() {
        mApplicationLogic = new ApplicationLogic(mData, mGui, this);
    }

    private void initEventToListenerMapping() {
        new EventToListenerMapping(mGui, mApplicationLogic);
    }

    //save data if activity stops
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        mApplicationLogic.onStandardBackButtonClicked();
    }
}
