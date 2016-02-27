package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.util.Log;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Activity mActivity;

    public ApplicationLogic(Data data, Gui gui, Activity activity) {
        mData = data;
        mGui = gui;
        mActivity = activity;
        initialUpdateGui();
    }

    private void initialUpdateGui() {
        // Demodaten
        mGui.setmTextFieldFileNameText(mData.getmChosenFile().getmName().toString());
        mGui.setmTextFieldNumberAllChallenges(String.valueOf(mData.getmNumberAllChallenges()));
        mGui.setmTextFieldNumberDueChallenges("13"); //mData.getmNumberDueChallenges().toString();
        mGui.setmTextFieldNumberOfClass1("22");      //mData.getmNumberOfPeriodClass1.toString();
        mGui.setmTextFieldNumberOfClass2("5");       //mData.getmNumberOfPeriodClass2.toString();
        mGui.setmTextFieldNumberOfClass3("7");       //mData.getmNumberOfPeriodClass3.toString();
        mGui.setmTextFieldNumberOfClass4("3");       //mData.getmNumberOfPeriodClass4.toString();
        mGui.setmTextFieldNumberOfClass5("4");       //mData.getmNumberOfPeriodClass5.toString();
        mGui.setmTextFieldNumberOfClass6("1");       //mData.getmNumberOfPeriodClass6.toString();
    }

    public void onButtonBackToChooseFileClicked() {;
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }

    // Start learning mode and open the activity
    public void onButtonStartLearning() {
        // NUR ZU TESTZWECKEN; SPÄTER AUFRUF VON FUNKTIONEN FÜR CHALLENGES
        Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
    }
}
