package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.os.Bundle;

/*
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.ApplicationLogic;
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.Data;
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.EventToListenerMapping;
import fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer.Gui;
*/

/**
 * Responsibility Edgar Klepek
 */
public class Init extends Activity {

    public Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
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

    private void initData(){
        mData = new Data(this);
    }
}