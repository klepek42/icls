package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
 */
public class ApplicationLogic {

    private Data mData;
    private Gui mGui;

    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initialUpdateGui();
    }

    private void initialUpdateGui() {
        Challenge challenge;
        int currentChallengeId;

        currentChallengeId = mData.getmCurrentChallengeId();
        challenge = mData.getmChallengeCollection().getChallenge(currentChallengeId);
    }

    public void onButtonBackToChooseFileClicked() {
        Navigation.startActivityChooseFile(mData.getActivity());
    }

    // Start learning mode and open the activity
    public void onButtonStartLearning() {
        // NUR ZU TESTZWECKEN; SPÄTER AUFRUF VON FUNKTIONEN FÜR CHALLENGES
        Navigation.startActivityChallengeImagineAnswer(mData.getActivity());
    }

    //Todo zurücktaste realisieren

}
