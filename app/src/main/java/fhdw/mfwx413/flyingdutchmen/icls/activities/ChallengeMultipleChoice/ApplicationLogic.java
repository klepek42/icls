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
    private final Data mData;
    private final Gui mGui;
    private final Activity mActivity;
    private int givenAnswer; //variable to store the given Answer as an integer

    public ApplicationLogic(Data data, Gui gui, Activity activity) {
        mData = data;
        mGui = gui;
        mActivity = activity;
        initialUpdateGui();
    }

    //Initial GUI Setup with question text
    private void initialUpdateGui() {
        Challenge challenge;
        int currentChallengeId;

        givenAnswer = 0;

        currentChallengeId = mData.getmCurrentChallengeId();
        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(currentChallengeId);


        mGui.setQuestionText(challenge.getmQuestiontext());
        mGui.getmCheckBoxAnswer1().setText(challenge.getmAnswerOne());
        mGui.getmCheckBoxAnswer2().setText(challenge.getmAnswerTwo());
        mGui.getmCheckBoxAnswer3().setText(challenge.getmAnswerThree());
    }


    public void onButtonConfirmAnswerClicked() throws InvalidCorrectAnswerTypeException {
        int challengeId = mData.getmCurrentChallengeId();
        Challenge challenge;
        boolean isAnswerCorrect;


        challenge = mData.getmDueChallengesOfUserInFile().getChallenge(challengeId);

        //check which CheckBoxes are checked and count up givenAnswer based on that
        if (mGui.getmCheckBoxAnswer1().isChecked()) { givenAnswer = givenAnswer + 1;}
        if (mGui.getmCheckBoxAnswer2().isChecked()) { givenAnswer = givenAnswer + 2;}
        if (mGui.getmCheckBoxAnswer3().isChecked()) { givenAnswer = givenAnswer + 4;}

        //determine whether user given answer has same value as stored correct answer and set boolean isAnswerCorrect based on that
        if (challenge.getmCorrectAnswer() >= 1 && challenge.getmCorrectAnswer() <= 7) {
            if (challenge.getmCorrectAnswer() == givenAnswer){
                isAnswerCorrect = true;
            }
            else {
                isAnswerCorrect = false;
            }
        }

        //if stored correct answer has invalid value, exception is thrown
        else {
            throw new InvalidCorrectAnswerTypeException("ChallengeMultipleChoice::ApplicationLogic::onButtonConfirmAnswerClicked: Ungültiger Wert für CorrectAnswer: " + challenge.getmCorrectAnswer());
        }

        //try to update the user Progress, if not possible throw exception
        try {
            updateUserProgress(isAnswerCorrect);
            //call the Feedback-Activity and send the required data
            Navigation.startActivityFeedbackChallengeRest(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), isAnswerCorrect, mData.getmUserProgresses());


        } catch (UserProgressNotFoundException e) {
            Log.e("ICLS-LOG", "ChallengeMultipleChoice::ApplicationLogic::onButtonConfirmAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }

    //method to leave the activity without answering the question
    public void goBackToChooseFile() {
        Navigation.startActivityChooseIndexCard(mData.getActivity(), mData.getmChosenUser());
    }

    public void showErrorUnexpectedError() {
        Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
    }

    //method to update the userProgress with information, whether the given answer was correct or not
    private void updateUserProgress(boolean isAnswerCorrect) throws UserProgressNotFoundException {
        boolean userProgressFound = false;
        //go through user progresses to find these of current user
        for (int i = 0; i < mData.getmUserProgresses().getSize(); i++) {
            //find the challenge and update the time class + time stamp
            if (mData.getmUserProgresses().getUserProgress(i).getmChallengeID() == mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID()) {
                int actualTimeClass = mData.getmUserProgresses().getUserProgress(i).getmPeriodClass();
                userProgressFound = true;
                mData.getmUserProgresses().getUserProgress(i).setCurrentTimeStamp();
                //count up period classes based on current time class
                if (isAnswerCorrect) {
                    if (actualTimeClass < 5) {
                        mData.getmUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass + 1);
                    }
                } else {
                    if (actualTimeClass > 1) {
                        mData.getmUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass - 1);
                    }
                }
                //update the userProgress of the current user
                UserProgressDatabase.writeSpecificUserProgresses(mData.getmUserProgresses(), mData.getmChosenUser().getName(), mActivity);
                break;
            }
        }
        //throw exception if the userProgress was not found
        if (!userProgressFound) {
            throw new UserProgressNotFoundException("ChallengeMultipleChoice::ApplicationLogic::updateUserProgress:"
                    + " CurrentUserName: " + mData.getmChosenUser().getName()
                    + " ChallengeID:" + mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID());
        }
    }
}

