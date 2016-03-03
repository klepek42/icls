package fhdw.mfwx413.flyingdutchmen.icls.activities.SettingsMenu;

import android.content.Context;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.util.ArrayList;

import fhdw.mfwx413.flyingdutchmen.icls.data.Constants;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserCollection;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserNotFoundException;
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


    //method to add content to Unit-Spinner and Timeclass-EditTexts
   private void fillAllPeriodClassesAndTimeUnits() {
       //fill ArrayList of units
       periodUnits.add(0, "Minute(n)");
       periodUnits.add(1, "Stunde(n)");
       periodUnits.add(2, "Tag(e)");

       //fill all unit-Spinner
       ArrayAdapter<String> adapter = new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,periodUnits);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

       mGui.getTimeUnit1().setAdapter(adapter);
       mGui.getTimeUnit2().setAdapter(adapter);
       mGui.getTimeUnit3().setAdapter(adapter);
       mGui.getTimeUnit4().setAdapter(adapter);
       mGui.getTimeUnit5().setAdapter(adapter);
       mGui.getTimeUnit6().setAdapter(adapter);

        //store current user chosen period classes
       int chosenPeriodClass1Int = mData.getCurrentUser().getPeriodClass1();
       int chosenPeriodClass2Int = mData.getCurrentUser().getPeriodClass2();
       int chosenPeriodClass3Int = mData.getCurrentUser().getPeriodClass3();
       int chosenPeriodClass4Int = mData.getCurrentUser().getPeriodClass4();
       int chosenPeriodClass5Int = mData.getCurrentUser().getPeriodClass5();
       int chosenPeriodClass6Int = mData.getCurrentUser().getPeriodClass6();

       //following switch statements set user chosen time periods in EditTexts and set proper unit in Spinner - convertion from int to String is necessary because EditText stores as String
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
            //nothing to do, one chosen period class is empty and therefore not valid
        }

        //determine whether chosen periods are valid (and not empty)
        if (chosenPeriodClass1Int > 0 &&
                chosenPeriodClass6Int > chosenPeriodClass5Int &&
                chosenPeriodClass5Int > chosenPeriodClass4Int &&
                chosenPeriodClass4Int > chosenPeriodClass3Int &&
                chosenPeriodClass3Int > chosenPeriodClass2Int &&
                chosenPeriodClass2Int > chosenPeriodClass1Int )
        {
            //chosen periods are valid

            try {
                //store periods temporary
                mData.getCurrentUser().setPeriodClasses(chosenPeriodClass1Int, chosenPeriodClass2Int, chosenPeriodClass3Int, chosenPeriodClass4Int, chosenPeriodClass5Int, chosenPeriodClass6Int);

                //store periods permanently
                updateUserCollection(chosenPeriodClass1Int,chosenPeriodClass2Int,chosenPeriodClass3Int,chosenPeriodClass4Int,chosenPeriodClass5Int,chosenPeriodClass6Int);
                Toast.makeText(mData.getActivity(), "Die Werte wurden gespeichert!", Toast.LENGTH_SHORT).show();
                Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
            } catch (UserNotFoundException e) {
                Log.e("ICLS-LOG", "SettingsMenu::ApplicationLogic::onButtonConfirmSettingsClicked: ", e);
                showErrorUnexpectedError();
                Navigation.startActivityStartMenu(mData.getActivity());
            }

        }
        else {
            //not valid
            Toast.makeText(mData.getActivity(), "Bitte prüfen Sie die eingegebenen Werte und Einheiten.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showErrorUnexpectedError() {
        Toast.makeText(mData.getActivity(), "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
    }

    //method to convert a given period (string) value from a given unit into another - or same unit - and return as int
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

    //method to determine which unit is best to select in Spinner: returns 0 for minutes, 1 for hours, 2 for days
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

    //method to update a UserCollection with given Units (int)
    private void updateUserCollection(int periodClass1, int periodClass2,int periodClass3,int periodClass4,int periodClass5,int periodClass6) throws UserNotFoundException {
        UserCollection uc = mData.getmAllUsers();
        boolean userFoundInCollection = false;

        for (int i=0; i<uc.getSize(); i++)
        {
            if (uc.get(i).getName().equals(mData.getCurrentUser().getName()))
            {
                uc.get(i).setPeriodClasses(periodClass1,periodClass2,periodClass3,periodClass4,periodClass5,periodClass6);
                userFoundInCollection = true;
            }
        }
        if (userFoundInCollection == false){
            throw new UserNotFoundException("SettingsMenu::ApplicationLogic::updateUserCollection:"
                    + " CurrentUserName: " + mData.getmChosenUser().getName());
        }
        UserDatabase.writeAllUsers(context, uc);
    }


    public void goBackToChooseFile() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
        Toast.makeText(mData.getActivity(), "Abgebrochen und nichts gespeichert.", Toast.LENGTH_SHORT).show();
    }

    //Set settings back to default values
    public void onButtonSetSettingsDefaultClicked() {
      try {
          //store periods temporary
            mData.getCurrentUser().setDefaultPeriodClasses();

          //store periods permanently
            updateUserCollection(Constants.PERIOD_CLASS_1,Constants.PERIOD_CLASS_2,Constants.PERIOD_CLASS_3,Constants.PERIOD_CLASS_4,Constants.PERIOD_CLASS_5,Constants.PERIOD_CLASS_6);
            Toast.makeText(mData.getActivity(), "Zu default-Werten zurückgesetzt!", Toast.LENGTH_SHORT).show();
            Navigation.startActivityChooseFile(mData.getActivity(), mData.getCurrentUser());
        } catch (UserNotFoundException e) {
            Log.e("ICLS-LOG", "SettingsMenu::ApplicationLogic::onButtonSetSettingsDefaultClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mData.getActivity());
        }
    }
}
