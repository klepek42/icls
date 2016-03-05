package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import android.app.Activity;
import android.os.Bundle;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.IdNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 13.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 20.02.2016
 * Updated by Max on 21.02.2016
 * Updated by Max on 22.02.2016
 * Updated by Max on 24.02.2016
 * Updated by Max on 27.02.2016
 * Updated by Max on 01.03.2016
 */

// Init initializes all the classes relating to the current activity
public class Init extends Activity {

    private Data mData;
    private Gui mGui;
    private ApplicationLogic mApplicationLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData(savedInstanceState);

        try {
            // checks if there are double index cards and calls duplicate index cards activity
            if(mData.checkForDuplicates()){
                Navigation.startActivityDuplicateIndexCards(mData.getActivity());
            }
            // checks if there are index cards available and calls no index cards available activity
            if(mData.checkForRecords()){
                Navigation.startActivityNoIndexCardsAvailable(mData.getActivity());
            }
        } catch (IdNotFoundException e) {
            e.printStackTrace();
        }

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

    // saves data if activity stops
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