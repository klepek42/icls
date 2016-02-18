package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;

/**
 * Responsibility: Jonas Krabs
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

        mGui.setQuestionText(challenge.getmQuestiontext());
    }

    public void onButtonConfirmFreeAnswerClicked(){

    }

    public void onButtonLogoutClicked(){

    }

    //Todo zurücktaste realisieren


}
