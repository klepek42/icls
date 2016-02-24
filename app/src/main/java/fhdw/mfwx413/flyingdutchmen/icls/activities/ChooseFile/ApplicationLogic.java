package fhdw.mfwx413.flyingdutchmen.icls.activities.ChooseFile;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

/**
 * Created by edgar on 13.02.2016
 * Updated by Max on 20.12.2016
 */

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Context context;

    public static ArrayList<String> files = new ArrayList<>();

    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
        fillSpinner();
    }

    private void initialUpdateDataToGui() {

    }

    // Noch nicht fertig
    public void onButtonStatisticsClicked() {
        //Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
        //Navigation.startActivityStatistics(mData.getActivity());
    }

    public void onButtonLogoutClicked() {
        // Abmelden-Fragment
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    public void onButtonSettingsClicked() {
        Navigation.startActivitySettingMenu(mData.getActivity());
        //Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
    }

    public void onButtonStartLearningClicked() {
        //TODO Max: Start Lernmodus mit fälligen Fragen oder Ende-Screen
        //Navigation.startActivityEditUser(mData.getActivity(), mData.getCurrentUser());
        Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
    }

    private void fillSpinner() {
        //files = csvImport.importIndexCsv(context);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, files);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mGui.getChooseRegister().setAdapter(adapter);
    }

}
