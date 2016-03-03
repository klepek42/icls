package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.DoubleIndexCardFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

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
        } catch (IdNotFoundException e) {
            e.printStackTrace();
        } catch (DoubleIndexCardFoundException e) {
            e.printStackTrace();
            //TODO Max: Aufruf reparieren
            //Navigation.startActivityDuplicateFiles(mData.getActivity());
        }
        initGui();
        initApplicationLogic();
        initEventToListenerMapping();
    }

    private void initData(Bundle savedInstanceState) throws ParseException, IdNotFoundException, DoubleIndexCardFoundException {
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

    @Override
    public void onBackPressed() {
        mApplicationLogic.onStandardBackButtonClicked();
    }
}