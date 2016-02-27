package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.content.Context;

import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Daniel zur Linden
 */
public class ApplicationLogic{

    private Data mData;
    private Gui mGui;
    private Context context;
    private ArrayList<String> periodUnits = new ArrayList<>();



    public ApplicationLogic(Data data, Gui gui, Context context) {
        mData = data;
        mGui = gui;
        this.context = context;
        initialUpdateDataToGui();
    }

    private void initialUpdateDataToGui() {
        fillAllSpinner();
        fillAllTimePeriods();
    }

    //simple method to convert a given string period value from a given unit into minutes and return as int
    //Todo Daniel: make it work
    private int convertChosenPeriodInMinutes (String chosenPeriod, String chosenTimeUnit)
    {
    int chosenPeriodInt;
        chosenPeriodInt = Integer.parseInt(chosenPeriod);
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


   private void fillAllSpinner() {
       periodUnits.add(0, "Minute(n)");
       periodUnits.add(1, "Stunde(n)");
       periodUnits.add(2, "Tag(e)");

       ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,periodUnits);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       mGui.getTimeUnit1().setAdapter(adapter);
       mGui.getTimeUnit2().setAdapter(adapter);
       mGui.getTimeUnit3().setAdapter(adapter);
       mGui.getTimeUnit4().setAdapter(adapter);
       mGui.getTimeUnit5().setAdapter(adapter);
       mGui.getTimeUnit6().setAdapter(adapter);

       //--- TEST ONLY ---//
       mGui.getTimeUnit1().setSelection(0);
       mGui.getTimeUnit2().setSelection(1);
       mGui.getTimeUnit3().setSelection(2);
       mGui.getTimeUnit4().setSelection(2);
       mGui.getTimeUnit5().setSelection(2);
       mGui.getTimeUnit6().setSelection(2);
       //--- TEST ONLY ---//

       //Todo Daniel: Adapt these to set selections based on user chosen units - not working
       //check whether user has changed time periods and fill spinner based on that
       /*if (mData.getCurrentUser().getmPeriodClass1() == Constants.PERIOD_CLASS_1 &&
               mData.getCurrentUser().getmPeriodClass2() == Constants.PERIOD_CLASS_2 &&
               mData.getCurrentUser().getmPeriodClass3() == Constants.PERIOD_CLASS_3 &&
               mData.getCurrentUser().getmPeriodClass4() == Constants.PERIOD_CLASS_4 &&
               mData.getCurrentUser().getmPeriodClass5() == Constants.PERIOD_CLASS_5 &&
               mData.getCurrentUser().getmPeriodClass6() == Constants.PERIOD_CLASS_6
               )
       {
           mGui.getTimeUnit1().setSelection(0);
           mGui.getTimeUnit2().setSelection(1);
           mGui.getTimeUnit3().setSelection(2);
           mGui.getTimeUnit4().setSelection(2);
           mGui.getTimeUnit5().setSelection(2);
           mGui.getTimeUnit6().setSelection(2);
       }
       else
       {
           //Todo Daniel: add
       }*/

    }



    //method to fill all EditTexts with user chosen or default values
    private void fillAllTimePeriods(){
    //throws Exception, don't know why
        //Todo Daniel: make it work, reminder: read out user chosen units and convert from minutes into these
    /*    mGui.getmPeriodClass1().setText(String.valueOf(mData.getCurrentUser().getmPeriodClass1()));
        mGui.getmPeriodClass2().setText(String.valueOf(mData.getCurrentUser().getmPeriodClass2()));
        mGui.getmPeriodClass3().setText(String.valueOf(mData.getCurrentUser().getmPeriodClass3()));
        mGui.getmPeriodClass4().setText(String.valueOf(mData.getCurrentUser().getmPeriodClass4()));
        mGui.getmPeriodClass5().setText(String.valueOf(mData.getCurrentUser().getmPeriodClass5()));
        mGui.getmPeriodClass6().setText(String.valueOf(mData.getCurrentUser().getmPeriodClass6()));*/
    }

    public void onButtonConfirmSettingsClicked() {
        //Read values for user chosen period EditText and time unit Spinner
        String chosenPeriodClass1 = mGui.getmPeriodClass1().getText().toString();
        String chosenTimeUnitClass1 = mGui.getTimeUnit1().getSelectedItem().toString();
        String chosenPeriodClass2 = mGui.getmPeriodClass2().getText().toString();
        String chosenTimeUnitClass2 = mGui.getTimeUnit2().getSelectedItem().toString();
        String chosenPeriodClass3 = mGui.getmPeriodClass3().getText().toString();
        String chosenTimeUnitClass3 = mGui.getTimeUnit3().getSelectedItem().toString();
        String chosenPeriodClass4 = mGui.getmPeriodClass4().getText().toString();
        String chosenTimeUnitClass4 = mGui.getTimeUnit4().getSelectedItem().toString();
        String chosenPeriodClass5 = mGui.getmPeriodClass5().getText().toString();
        String chosenTimeUnitClass5 = mGui.getTimeUnit5().getSelectedItem().toString();
        String chosenPeriodClass6 = mGui.getmPeriodClass6().getText().toString();
        String chosenTimeUnitClass6 = mGui.getTimeUnit6().getSelectedItem().toString();

        int chosenPeriodClass1Int = 0;
        int chosenPeriodClass2Int = 0;
        int chosenPeriodClass3Int = 0;
        int chosenPeriodClass4Int = 0;
        int chosenPeriodClass5Int = 0;
        int chosenPeriodClass6Int = 0;


        //if not empty convert these into minutes
        if (!chosenPeriodClass1.isEmpty() &&
                !chosenPeriodClass2.isEmpty() &&
                !chosenPeriodClass3.isEmpty() &&
                !chosenPeriodClass4.isEmpty() &&
                !chosenPeriodClass5.isEmpty() &&
                !chosenPeriodClass6.isEmpty()
                ){
            chosenPeriodClass1Int = convertChosenPeriodInMinutes(chosenPeriodClass1, chosenTimeUnitClass1);
            chosenPeriodClass2Int = convertChosenPeriodInMinutes(chosenPeriodClass2, chosenTimeUnitClass2);
            chosenPeriodClass3Int = convertChosenPeriodInMinutes(chosenPeriodClass3, chosenTimeUnitClass3);
            chosenPeriodClass4Int = convertChosenPeriodInMinutes(chosenPeriodClass4, chosenTimeUnitClass4);
            chosenPeriodClass5Int = convertChosenPeriodInMinutes(chosenPeriodClass5, chosenTimeUnitClass5);
            chosenPeriodClass6Int = convertChosenPeriodInMinutes(chosenPeriodClass6, chosenTimeUnitClass6);
        }
        else
        {
            System.out.println("One Chosen Period String is empty!");
        }

        System.out.println(chosenPeriodClass1Int);



        //determine whether chosen periods are valid (and not empty)
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
           //Todo Daniel: Add mData.getCurrentUser().setTimeUnits(mGui.getTimeUnit1().getSelectedItemPosition(), ...);
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
