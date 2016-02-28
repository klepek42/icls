package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.content.Context;

import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Daniel zur Linden
 */
//Optional Todo: reduce toString() -  Int
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
        fillAllPeriodClassesAndTimeUnits();
    }

    //method to convert a given string period value from a given unit into minutes and return as int
    private int convertChosenPeriod(String originalPeriod, String originalTimeUnit, String wantedTimeUnit)
    {
    int originalPeriodInt;
        originalPeriodInt = Integer.parseInt(originalPeriod);
        switch (wantedTimeUnit) {
            case "Minute(n)":
                switch (originalTimeUnit) {
                    case "Minute(n)": break;
                    case "Stunde(n)": originalPeriodInt = originalPeriodInt * 60; break;
                    case "Tag(e)":   originalPeriodInt = originalPeriodInt * 60 * 24; break;
                }
                break;
            case "Stunde(n)":
                switch (originalTimeUnit) {
                    case "Minute(n)": originalPeriodInt = originalPeriodInt / 60; break;
                    case "Stunde(n)": break;
                    case "Tag(e)":   originalPeriodInt = originalPeriodInt * 24; break;
                }
                break;
            case "Tag(e)":
                switch (originalTimeUnit) {
                    case "Minute(n)": originalPeriodInt = originalPeriodInt / 24 / 60; break;
                    case "Stunde(n)": originalPeriodInt = originalPeriodInt / 24;
                    case "Tag(e)":   break;
                }
                break;
        }
        return originalPeriodInt;
    }

    //method to determine which unit is best returns 0 for minutes, 1 for hours, 2 for days
    private int determineProperUnit(int periodClass) {
        double periodClassDouble = periodClass;
        if (periodClassDouble/60 >= 1 && periodClassDouble/60%1 == 0)
        {
            if (periodClassDouble/60/24 >= 1 && periodClassDouble/60/24%1 == 0)
            {
                return 2;
            }
            else
            {
                return 1;
            }
        }
        else {
            return 0;
        }
    }

    //method to add content to Unit-Spinner and Timeclass-EditTexts
   private void fillAllPeriodClassesAndTimeUnits() {
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

       //check which time periods are chosen (might be default) and fill Spinner/EditTexts based on that
       int chosenPeriodClass1Int = mData.getCurrentUser().getmPeriodClass1();
       int chosenPeriodClass2Int = mData.getCurrentUser().getmPeriodClass2();
       int chosenPeriodClass3Int = mData.getCurrentUser().getmPeriodClass3();
       int chosenPeriodClass4Int = mData.getCurrentUser().getmPeriodClass4();
       int chosenPeriodClass5Int = mData.getCurrentUser().getmPeriodClass5();
       int chosenPeriodClass6Int = mData.getCurrentUser().getmPeriodClass6();

       //following switch statements set user chosen time periods in EditTexts and choose proper unit in Spinner
       switch (determineProperUnit(chosenPeriodClass1Int)) {
           case 0:
               mGui.getTimeUnit1().setSelection(0);
               mGui.getmPeriodClass1().setText(String.valueOf(chosenPeriodClass1Int));
               break;
           case 1:
               mGui.getTimeUnit1().setSelection(1);
               mGui.getmPeriodClass1().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass1Int), "Minute(n)", "Stunde(n)")));
               break;
           case 2:
               mGui.getTimeUnit1().setSelection(2);
               mGui.getmPeriodClass1().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass1Int), "Minute(n)", "Tag(e)")));
       }

       switch (determineProperUnit(chosenPeriodClass2Int)) {
           case 0:
               mGui.getTimeUnit2().setSelection(0);
               mGui.getmPeriodClass2().setText(String.valueOf(chosenPeriodClass2Int));
               break;
           case 1:
               mGui.getTimeUnit2().setSelection(1);
               mGui.getmPeriodClass2().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass2Int), "Minute(n)", "Stunde(n)")));
               break;
           case 2:
               mGui.getTimeUnit2().setSelection(2);
               mGui.getmPeriodClass2().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass2Int), "Minute(n)", "Tag(e)")));
       }

       switch (determineProperUnit(chosenPeriodClass3Int)) {
           case 0:
               mGui.getTimeUnit3().setSelection(0);
               mGui.getmPeriodClass3().setText(String.valueOf(chosenPeriodClass3Int));
               break;
           case 1:
               mGui.getTimeUnit3().setSelection(1);
               mGui.getmPeriodClass3().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass3Int), "Minute(n)", "Stunde(n)")));
               break;
           case 2:
               mGui.getTimeUnit3().setSelection(2);
               mGui.getmPeriodClass3().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass3Int), "Minute(n)", "Tag(e)")));
       }

       switch (determineProperUnit(chosenPeriodClass4Int)) {
           case 0:
               mGui.getTimeUnit4().setSelection(0);
               mGui.getmPeriodClass4().setText(String.valueOf(chosenPeriodClass4Int));
               break;
           case 1:
               mGui.getTimeUnit4().setSelection(1);
               mGui.getmPeriodClass4().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass4Int), "Minute(n)", "Stunde(n)")));
               break;
           case 2:
               mGui.getTimeUnit4().setSelection(2);
               mGui.getmPeriodClass4().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass4Int), "Minute(n)", "Tag(e)")));
       }

       switch (determineProperUnit(chosenPeriodClass5Int)) {
           case 0:
               mGui.getTimeUnit5().setSelection(0);
               mGui.getmPeriodClass5().setText(String.valueOf(chosenPeriodClass5Int));
               break;
           case 1:
               mGui.getTimeUnit5().setSelection(1);
               mGui.getmPeriodClass5().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass5Int), "Minute(n)", "Stunde(n)")));
               break;
           case 2:
               mGui.getTimeUnit5().setSelection(2);
               mGui.getmPeriodClass5().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass5Int), "Minute(n)", "Tag(e)")));
       }

       switch (determineProperUnit(chosenPeriodClass6Int)) {
           case 0:
               mGui.getTimeUnit6().setSelection(0);
               mGui.getmPeriodClass6().setText(String.valueOf(chosenPeriodClass6Int));
               break;
           case 1:
               mGui.getTimeUnit6().setSelection(1);
               mGui.getmPeriodClass6().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass6Int), "Minute(n)", "Stunde(n)")));
               break;
           case 2:
               mGui.getTimeUnit6().setSelection(2);
               mGui.getmPeriodClass6().setText(String.valueOf(convertChosenPeriod(String.valueOf(chosenPeriodClass6Int), "Minute(n)", "Tag(e)")));
       }


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
            chosenPeriodClass1Int = convertChosenPeriod(chosenPeriodClass1, chosenTimeUnitClass1, "Minute(n)");
            chosenPeriodClass2Int = convertChosenPeriod(chosenPeriodClass2, chosenTimeUnitClass2, "Minute(n)");
            chosenPeriodClass3Int = convertChosenPeriod(chosenPeriodClass3, chosenTimeUnitClass3, "Minute(n)");
            chosenPeriodClass4Int = convertChosenPeriod(chosenPeriodClass4, chosenTimeUnitClass4, "Minute(n)");
            chosenPeriodClass5Int = convertChosenPeriod(chosenPeriodClass5, chosenTimeUnitClass5, "Minute(n)");
            chosenPeriodClass6Int = convertChosenPeriod(chosenPeriodClass6, chosenTimeUnitClass6, "Minute(n)");
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
