package fhdw.mfwx413.flyingdutchmen.icls.activities.FragLogout;

import android.content.Context;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 17.02.2016.
 */
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

    public void onStandardBackButtonClicked() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
    }


    public void onButtonConfirmLogoutClicked() {
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    public void onButtonDenyLogoutClicked() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
    }
}
