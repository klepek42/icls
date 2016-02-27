package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Daniel zur Linden
 */
public class ApplicationLogic {
    private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Data mData;
    private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Gui mGui;
    private Activity mActivity;
    private int givenAnswer = 0; //variable to store the given Answer as an integer
    private boolean isCheckBoxAnswer1Clicked = false;
    private boolean isCheckBoxAnswer2Clicked = false;
    private boolean isCheckBoxAnswer3Clicked = false;

    public ApplicationLogic(fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Data data, Gui gui, Activity activity) {
        mData = data;
        mGui = gui;
        mActivity = activity;
        initialUpdateGui();
    }

    //Initial GUI Setup with question text
    private void initialUpdateGui() {
        Challenge challenge;
        int currentChallengeId;

        currentChallengeId = mData.getmCurrentChallengeId();
        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(currentChallengeId);

        mGui.setQuestionText(challenge.getmQuestiontext());
    }

    //Bauernvariante zur Überprüfung, ob eine CheckBox aktiv ist oder nicht - anders ginge es so: https://stackoverflow.com/questions/18336151/how-to-check-if-android-checkbox-is-checked-within-its-onclick-method-declared

    public void onCheckBoxAnswer1Clicked() {
        if (isCheckBoxAnswer1Clicked == false)
        {
            givenAnswer = givenAnswer + 1;
            isCheckBoxAnswer1Clicked = true;
        }
        else {
            givenAnswer = givenAnswer - 1;
            isCheckBoxAnswer1Clicked = false;
        }
    }

    public void onCheckBoxAnswer2Clicked() {
        if (isCheckBoxAnswer2Clicked == false)
        {
            givenAnswer = givenAnswer + 2;
            isCheckBoxAnswer2Clicked = true;
        }
        else {
            givenAnswer = givenAnswer - 2;
            isCheckBoxAnswer2Clicked = false;
        }
    }

    public void onCheckBoxAnswer3Clicked() {
        if (isCheckBoxAnswer3Clicked == false)
        {
            givenAnswer = givenAnswer + 4;
            isCheckBoxAnswer3Clicked = true;
        }
        else {
            givenAnswer = givenAnswer - 4;
            isCheckBoxAnswer3Clicked = false;
        }
    }


    public void onButtonConfirmAnswerClicked(){
        int challengeId = mData.getmCurrentChallengeId();
        Challenge challenge;
        boolean isAnswerCorrect = false;


        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(challengeId);

        if (challenge.getmCorrectAnswer() == givenAnswer)
        {
            System.out.println("Die Antwort ist korrekt!");
            isAnswerCorrect = true;
        }
        else {
            System.out.println("Die Antwort ist leider falsch!");
            System.out.println("givenAnswer: " + givenAnswer);
            System.out.println("hinterlegte Antwort: " + challenge.getmAnswerOne());
            isAnswerCorrect = false;
        }


        Navigation.startActivityFeedbackChallengeRest(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), isAnswerCorrect);
        givenAnswer = 0; //variable to store the given Answer as an integer
        isCheckBoxAnswer1Clicked = false;
        isCheckBoxAnswer2Clicked = false;
        isCheckBoxAnswer3Clicked = false;

    }


    public void onButtonAbortClicked(){
        Navigation.startActivityStartMenu(mData.getActivity());
    }

    //Todo Daniel :Back-Taste implementieren
}

