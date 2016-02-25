package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.content.Context;
import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import android.widget.AdapterView;
import android.widget.Toast;


import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Daniel zur Linden
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Context context;




    public ApplicationLogic(fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu.Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
    }

    private void initialUpdateDataToGui() {
        //Todo Daniel: Fill in (default) values for time periods in EditTexts and choose automatically default Spinner values (Minute(n), Stunde(n), Tag(e), Tage(e), Tag(e), Tag(e)
        //Todo Daniel: Method fillSpinner()
    }

    //simple method to convert a given string period value from a given unit into minutes and return as int
    private int convertChosenPeriodInMinutes (String chosenPeriod, String chosenTimeUnit)
    {
    int chosenPeriodInt = Integer.parseInt(chosenPeriod);
        switch (chosenTimeUnit) {
            case "Minute(n)":
                //Nothing to do
            break;
            case "Stunde(n)":
                chosenPeriodInt = chosenPeriodInt * 60;
            break;
            case "Tage(e)":
                chosenPeriodInt = chosenPeriodInt * 60 * 24;
            break;
        }
        return chosenPeriodInt;
    }

    private void fillSpinner() {
        //Todo Daniel: to be defined
    }

    public void onButtonConfirmSettingsClicked() {
        //Read values for user chosen period EditText and time unit Spinner
        String chosenPeriodClass1 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass1 = mGui.getTimeUnit1().getSelectedItem().toString();
        String chosenPeriodClass2 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass2 = mGui.getTimeUnit1().getSelectedItem().toString();
        String chosenPeriodClass3 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass3 = mGui.getTimeUnit1().getSelectedItem().toString();
        String chosenPeriodClass4 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass4 = mGui.getTimeUnit1().getSelectedItem().toString();
        String chosenPeriodClass5 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass5 = mGui.getTimeUnit1().getSelectedItem().toString();
        String chosenPeriodClass6 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass6 = mGui.getTimeUnit1().getSelectedItem().toString();

        //convert these into minutes
        int chosenPeriodClass1Int = convertChosenPeriodInMinutes(chosenPeriodClass1,chosenTimeUnitClass1);
        int chosenPeriodClass2Int = convertChosenPeriodInMinutes(chosenPeriodClass2,chosenTimeUnitClass2);
        int chosenPeriodClass3Int = convertChosenPeriodInMinutes(chosenPeriodClass3,chosenTimeUnitClass3);
        int chosenPeriodClass4Int = convertChosenPeriodInMinutes(chosenPeriodClass4,chosenTimeUnitClass4);
        int chosenPeriodClass5Int = convertChosenPeriodInMinutes(chosenPeriodClass5,chosenTimeUnitClass5);
        int chosenPeriodClass6Int = convertChosenPeriodInMinutes(chosenPeriodClass6,chosenTimeUnitClass6);

        //determine whether chosen periods are valid
        if (chosenPeriodClass1Int > 0 &&
                chosenPeriodClass6Int > chosenPeriodClass5Int &&
                chosenPeriodClass5Int > chosenPeriodClass4Int &&
                chosenPeriodClass4Int > chosenPeriodClass3Int &&
                chosenPeriodClass3Int > chosenPeriodClass2Int &&
                chosenPeriodClass2Int > chosenPeriodClass1Int )
        {
            //chosen periods are valid
            Toast.makeText(mData.getActivity(), "Die Werte wurden gespeichert!", Toast.LENGTH_LONG).show();
            mData.getCurrentUser().setPeriodClasses(chosenPeriodClass1Int, chosenPeriodClass2Int, chosenPeriodClass3Int, chosenPeriodClass4Int, chosenPeriodClass5Int, chosenPeriodClass6Int);
            Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
        }
        else {
            //not valid
            Toast.makeText(mData.getActivity(), "Bitte prüfen Sie die eingegebenen Werte und Einheiten.", Toast.LENGTH_LONG).show();
        }
    }

    public void onButtonAbortSettingsClicked() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
    }

    //Set settings back to default values
    public void onButtonSetSettingsDefaultClicked() {
        mData.getCurrentUser().setDefaultPeriodClasses(mData.getCurrentUser().getmName());
        Toast.makeText(mData.getActivity(), "Zu default-Werten zurückgesetzt!", Toast.LENGTH_LONG).show();
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
    }
}
