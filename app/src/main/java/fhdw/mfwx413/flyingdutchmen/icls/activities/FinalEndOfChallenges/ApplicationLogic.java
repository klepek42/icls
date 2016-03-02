package fhdw.mfwx413.flyingdutchmen.icls.activities.FinalEndOfChallenges;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.ChallengeCollection;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Luisa Leifer
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

    // initialize the Gui by setting the questiontext
    private void initialUpdateGui() {

    }

    //method that is invoked if the back to choose file button is clicked
    public void onButtonBackToChooseFileClicked(){

        //call the ChooseFile-Activity and send the required data
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());

    }

    public void onButtonStatisticsClicked() {
        //TODO Luisa: Leere ChallengeCollection übergeben
        //call the Statistics-Activity and send the required data
        //Navigation.startActivityStatistics(mData.getActivity(), mData.getmChosenUser(), mData.getmChosenFile());

    }

}
