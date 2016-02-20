package fhdw.mfwx413.flyingdutchmen.icls.activities.StartMenu;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Created by edgar on 17.02.2016
 * Responsibility: Max
 * Updated by Max on 20.02.2016
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

    public void onButtonAddUserClicked() {
        Navigation.startActivityAddNewUser(mData.getActivity());
    }

    // Übergabeparameter fehlen noch
    public void onButtonConfirmUserClicked() {
        Navigation.startActivityChooseFile(mData.getActivity());
    }

    // Übergabeparameter fehlen noch
    public void onButtonEditUserClicked() {
        Navigation.startActivityEditUser(mData.getActivity());
    }

}
