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
        mGui.setmTextFieldNumberDueChallenges(String.valueOf(mData.getmNumberDueChallenges()));
        mGui.setmTextFieldNumberOfClass1(String.valueOf(mData.getmNumberOfPeriodClass1()));
        mGui.setmTextFieldNumberOfClass2(String.valueOf(mData.getmNumberOfPeriodClass2()));
        mGui.setmTextFieldNumberOfClass3(String.valueOf(mData.getmNumberOfPeriodClass3()));
        mGui.setmTextFieldNumberOfClass4(String.valueOf(mData.getmNumberOfPeriodClass4()));
        mGui.setmTextFieldNumberOfClass5(String.valueOf(mData.getmNumberOfPeriodClass5()));
        mGui.setmTextFieldNumberOfClass6(String.valueOf(mData.getmNumberOfPeriodClass6()));
    }

    public void onButtonBackToChooseFileClicked() {;
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }

    // Start learning mode and open the activity
    public void onButtonStartLearning() {
        // NUR ZU TESTZWECKEN; SPÄTER AUFRUF VON FUNKTIONEN FÜR CHALLENGES

        //Pascal Heß: There were changes in the class "Navigation". Now the method needs more parameters for being correctly called.
        //Therefore the next commented line needs to be adapted.
        //Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
    }
}
