package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016
 */

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initialUpdateDataToGui();
    }

    private void initialUpdateDataToGui() {

    }

    // Noch nicht fertig
    public void onButtonStatisticsClicked() {
        Navigation.startActivityStatistics(mData.getActivity());
    }

    public void onButtonLogoutClicked() {
        // Abmelden-Fragment
        Navigation.startActivityStatistics(mData.getActivity());
    }

    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity());
    }

    public void onButtonStartLearningClicked() {
        // Start Lernmodus mit fälligen Fragen oder Ende-Screen
        Navigation.startActivityStatistics(mData.getActivity());
    }

}
