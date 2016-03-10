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

    private void initialUpdateGui() {

    }

    // method that is invoked if the choose file button is clicked
    public void onButtonBackToChooseFileClicked(){

        // navigation to activity ChooseFile and send the required data
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getmChosenUser());

    }

    // method that is invoked if the statistics button is clicked
    public void onButtonStatisticsClicked() {

        // empty ChallengeCollection
        ChallengeCollection cc = new ChallengeCollection();

        // navigation to activity statistics and send the required data
        Navigation.startActivityStatistics(mData.getActivity(), mData.getmChosenUser(), mData.getmChosenFile(), cc);

    }

}
