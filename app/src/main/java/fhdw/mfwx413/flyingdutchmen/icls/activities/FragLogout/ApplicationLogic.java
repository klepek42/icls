package fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout;

import android.content.Context;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max Schumacher
 * Updated by Max on 01.03.2016
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

    // calls the activity choose File and transmits the selected user from spinner as the current user
    public void onStandardBackButtonClicked() {
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getCurrentUser());
    }

    // calls the activity start Menu. No data needs to be transmitted
    public void onButtonConfirmLogoutClicked() {
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    // calls the activity choose File and transmits the selected user from spinner as the current user
    public void onButtonDenyLogoutClicked() {
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getCurrentUser());
    }
}
