package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Daniel zur Linden
 */
public class ApplicationLogic {
    private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Data mData;
    private fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice.Gui mGui;
    private Activity mActivity;
    private int givenAnswer; //variable to store the given Answer as an integer
    private boolean isCheckBoxAnswer1Clicked;
    private boolean isCheckBoxAnswer2Clicked;
    private boolean isCheckBoxAnswer3Clicked;

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

        givenAnswer = 0;
        isCheckBoxAnswer1Clicked = false;
        isCheckBoxAnswer2Clicked = false;
        isCheckBoxAnswer3Clicked = false;

        mGui.setQuestionText(challenge.getmQuestiontext());
        mGui.getmCheckBoxAnswer1().setText(challenge.getmAnswerOne());
        mGui.getmCheckBoxAnswer2().setText(challenge.getmAnswerTwo());
        mGui.getmCheckBoxAnswer3().setText(challenge.getmAnswerThree());
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

    public void onButtonConfirmAnswerClicked() throws InvalidCorrectAnswerTypeException {
        int challengeId = mData.getmCurrentChallengeId();
        Challenge challenge;
        boolean isAnswerCorrect = false;


        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(challengeId);

    if (challenge.getmCorrectAnswer() >= 1 && challenge.getmCorrectAnswer() <=7){

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
    }

    else {
        throw new InvalidCorrectAnswerTypeException("ChallengeMultipleChoice::ApplicationLogic::onButtonConfirmAnswerClicked: Ungültiger Wert für CorrectAnswer: " + challenge.getmCorrectAnswer());
    }

        try {
            updateUserProgress(isAnswerCorrect);
            //call the Feedback-Activity and send the required data
            Navigation.startActivityFeedbackChallengeRest(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), isAnswerCorrect);

        }
        catch (UserProgressNotFoundException e){
            Log.e("ICLS-LOG", "ChallengeMultipleChoice::ApplicationLogic::onButtonConfirmAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }


    public void goBackToChooseFile(){
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }

    public void showErrorUnexpectedError(){
        Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
    }

    public void updateUserProgress(boolean isAnswerCorrect) throws UserProgressNotFoundException{
        boolean userProgressFound = false;
        for (int i = 0; i < mData.getmUserProgresses().getSize(); i++){
            if (mData.getmUserProgresses().getUserProgress(i).getmChallengeID() == mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID()){
                int actualTimeClass = mData.getmUserProgresses().getUserProgress(i).getmPeriodClass();
                userProgressFound = true;
                mData.getmUserProgresses().getUserProgress(i).setCurrentTimeStamp();
                if (isAnswerCorrect == true) {
                    if (actualTimeClass < 5 ) {
                        mData.getmUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass + 1);
                    }
                }
                else {
                    if (actualTimeClass > 1 ) {
                        mData.getmUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass - 1);
                    }
                }
                UserProgressDatabase.writeSpecificUserProgresses(mData.getmUserProgresses(), mData.getmChosenUser().getmName(), mActivity);
                break;
            }
        }
        if (userProgressFound == false){
            throw new UserProgressNotFoundException("ChallengeMultipleChoice::ApplicationLogic::updateUserProgress:"
                    + " CurrentUserName: " + mData.getmChosenUser().getmName()
                    + " ChallengeID:" + mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID());
        }
    }
}

