package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Edgar Klepek
 */
public class ApplicationLogic {

    // Member variables
    private Data mData;
    private Gui mGui;

    // Constructor
    public ApplicationLogic(Data data, Gui gui) {
        mData = data;
        mGui = gui;
        initialUpdateGui();
    }

    // Function for initializing the graphical user interface with the questiontext of the current challenge
    private void initialUpdateGui() {
        Challenge challenge;
        int currentChallengeId;

        // Get the current challenge id from Data and then all Challenges from the current user and current IndexCard
        currentChallengeId = mData.getCurrentChallengeId();
        challenge = mData.getDueChallengesOfUserInFile().getChallenge(currentChallengeId);

        mGui.setQuestionText(challenge.getmQuestiontext());
    }

    // Confirm the though answer and go to the feedback activity
    public void onButtonConfirmThinkAnswerClicked(){
        Navigation.startActivityFeedbackImagineAnswer(mData.getActivity(), mData.getDueChallengesOfUserInFile(), mData.getCurrentChallengeId(), mData.getChosenUser(), mData.getChosenFile(), mData.getUserProgresses());
    }

    // Back button goes to activity ChooseFile
    public void onButtonAbortClicked(){
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getChosenUser());
    }

}