package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.os.Bundle;

import java.text.ParseException;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016
 */

public class Init extends Activity {

    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            initData(savedInstanceState);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    private void initData(Bundle savedInstanceState) throws ParseException {
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
        mData.saveDataFromBundle(outState);
        super.onSaveInstanceState(outState);
    }
}