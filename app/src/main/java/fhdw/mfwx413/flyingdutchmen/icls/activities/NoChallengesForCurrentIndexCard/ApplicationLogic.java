package fhdw.mfwx413.flyingdutchmen.icls.activities.NoChallengesForCurrentIndexCard;

import android.content.Context;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by Max on 02.03.2016.
 * Responsibility: Max Schumacher
 * Updated by Max on 02.03.2016
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
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonOk2Clicked() {
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getCurrentUser());
    }
}
