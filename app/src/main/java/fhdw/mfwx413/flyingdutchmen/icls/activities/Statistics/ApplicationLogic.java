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
        mGui.setmTextFieldNumberAllChallenges("42");
        mGui.setmTextFieldNumberDueChallenges("13");
        mGui.setmTextFieldNumberOfClass1("22");
        mGui.setmTextFieldNumberOfClass2("5");
        mGui.setmTextFieldNumberOfClass3("7");
        mGui.setmTextFieldNumberOfClass4("3");
        mGui.setmTextFieldNumberOfClass5("4");
        mGui.setmTextFieldNumberOfClass6("1");
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
