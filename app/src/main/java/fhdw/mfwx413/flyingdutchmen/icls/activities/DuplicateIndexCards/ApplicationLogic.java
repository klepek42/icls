package fhdw.mfwx413.flyingdutchmen.icls.activities.DuplicateIndexCards;

import android.content.Context;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by Edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 03.03.2016
 */

// application logic connects the data with the gui and defines the exact events after an user-interaction
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Context context;

    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
    }

    private void initialUpdateDataToGui() {

    }

    // There should be no option to go back
    public void onStandardBackButtonClicked() {

    }

    // calls the activity start Menu. No data needs to be transmitted
    public void onButtonOkClicked() {
        Navigation.startActivityStartMenu(mData.getActivity());
    }

}
