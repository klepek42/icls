package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.utilities.Navigation;

/**
 * Responsibility: Pascal Heß
 */

public class ApplicationLogic {

    private Data mData;
    private Gui mGui;
    private Activity mActivity;

    //Constructor
    public ApplicationLogic(Data data, Gui gui, Activity activity) {
        mData = data;
        mGui = gui;
        mActivity = activity;
        initialUpdateGui();
    }


    //initialize GUI by setting the Feedbacktexts
    private void initialUpdateGui() {
        String correctAnswer;

        try {
            //delivers String with the correct answer(s)
            correctAnswer = mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmCorrectAnswerString();

            //set the real correct answer(s) into the feedback field
            mGui.setFeedbackTextCorrectAnswer(correctAnswer);

            //check if the answer was correct
            if (mData.getmIsAnswerCorrect() == true) {
                //if yes, set the feedback-fields with the following
                mGui.setFeedbackText("Die Antwort war korrekt");
                mGui.setFeedbackTextUpDownGrade("Die Frage wird heraufgestuft");
            } else {
                //if not, set the feedback-fields with the following:
                mGui.setFeedbackText("Die Antwort war falsch");
                mGui.setFeedbackTextUpDownGrade("Die Frage wird wieder heruntergestuft");
            }
        }
        //Exception-Handling, if there is a invalid correct answer type
        catch (InvalidCorrectAnswerTypeException e){
            Log.e("ICLS-ERROR", "FeedbackChallengeRest::ApplicationLogic::initialUpdateGui ", e);
            Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
            Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
        }
    }


    //method that is invoked, if the continue button is clicked
    public void onButtonContinue() {
        try {
            //checks whether there is a next activity that is to be started and starts the next activity with the correct layout type
            startNextActivity();
        }
        //Exception-Handling, if there is a problem with the layout type
        catch (InvalidQuestionTypeLayoutException e) {
            Log.e("ICLS-LOG", "FeedbackImagineAnswer::ApplicationLogic::onButtonWasAnswerWrong: ", e);
            errorToastFalseLayout();
            Navigation.startActivityStartMenu(mActivity);
        }
    }


    //method that is invoked, if the abort button is clicked
    public void onButtonAbortClicked() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }


    //method that is invoked, if the standard back button (on the phone or tablet) is clicked
    public void onStandardBackButtonClicked() {
        Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
    }


    //method returns an int-value, that gives information whether there is another due challenge and of which type it is
    public int otherDueChallenges() {
        int dueChallengeNumber = -1;
        int numberOfDueChallengesOfUserInFile;
        int currentChallengeId;
        int nextChallengeId;

        //get the total number of due challenges in the current file of the user
        numberOfDueChallengesOfUserInFile = mData.getmDueChallengesOfUserInFile().getSize();
        //get the challenge ID of the current challenge
        currentChallengeId = mData.getmCurrentChallengeId();

        //check if there are further challenges to be started (check if there is a next due challenge after the present one
        if (numberOfDueChallengesOfUserInFile > (currentChallengeId + 1)) {
            //if there are other due challenges do the following:

            //set the next challenge ID
            nextChallengeId = currentChallengeId + 1;

            //compute the layout-type of the next challenge and safe it as an int-value
                // "1": layout type ChallengeFreeAnswer
                // "2": layout type ChallengeImagineAnswer
                // "3": layout type ChallengeMultipleChoice
            dueChallengeNumber = mData.getmDueChallengesOfUserInFile().getChallenge(nextChallengeId).getmQuestionTypeLayout();
        }
        else {
            //if there are no other du challenges do the following:
            dueChallengeNumber = 0;
        }
        return dueChallengeNumber;
    }

    //Error-Handling for the false next activity-layout
    //it starts, when the int-value of the layout type is not 0,1,2 or 3
    public void errorToastFalseLayout() {
        Toast.makeText(mActivity, "Unerwartetes Layout", Toast.LENGTH_SHORT).show();
    }


    //method that computes the next due activity and the correct layout type that belongs to it, then this activitiy is started
    public void startNextActivity() throws InvalidQuestionTypeLayoutException {
        int dueChallengeNumber;

        //delivers int value, to decide which Activity has to be started
        dueChallengeNumber = otherDueChallenges();

        //it depends on the layout-type of the next due challenge, which activity is to be started next
        //Switch-Statement determines which layout has to be started and which data have to be sent
        switch (dueChallengeNumber) {
            //no other challenge is due
            case 0:
                Navigation.startActivityFinalEndOfChallenges(mData.getActivity(), mData.getmChosenUser(), mData.getmChosenFile());
                break;
            //a challenge of type ChallengeFreeAnswer is due
            case 1:
                //the old challenge ID is incremented by 1, so the correct "next" activity can be started and the correct information can be sent
                mData.incrementChallengeIdByOne();
                Navigation.startActivityChallengeFreeAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                break;
            //a challenge of type ChallengeImagineAnser is due
            case 2:
                //the old challenge ID is incremented by 1, so the correct "next" activity can be started and the correct information can be sent
                mData.incrementChallengeIdByOne();
                Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                break;
            //a challenge of type ChallengeMultipleChoice is due
            case 3:
                //the old challenge ID is incremented by 1, so the correct "next" activity can be started and the correct information can be sent
                mData.incrementChallengeIdByOne();
                Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                break;
            //Exception-Handling, if there is a int-value in "dueChallengeNumber" that is not 0,1,2 or 3
            default:
                throw new InvalidQuestionTypeLayoutException("FeedbackChallengeRest::ApplicationLogic::startNextActivity");
        }
    }
}
