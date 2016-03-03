package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressCollection;
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

        //delivers String with the correct answer(s)
        try {
            correctAnswer = mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmCorrectAnswerString();

            //set feedback field with the real correct answer
            mGui.setFeedbackTextCorrectAnswer(correctAnswer);

            //if the answer was correct
            if (mData.getmIsAnswerCorrect() == true) {
                mGui.setFeedbackText("Die Antwort war korrekt");
                mGui.setFeedbackTextUpDownGrade("Die Frage wird heraufgestuft");
            } else {
                //if the answer was false
                mGui.setFeedbackText("Die Antwort war falsch");
                mGui.setFeedbackTextUpDownGrade("Die Frage wird wieder heruntergestuft");
            }
        }
        catch (InvalidCorrectAnswerTypeException e){
            Log.e("ICLS-ERROR", "FeedbackChallengeRest::ApplicationLogic::initialUpdateGui ", e);
            Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
            Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
        }

    }

    //method that is invoked if the continue button is clicked
    //call the next due activity and send the required data
    public void onButtonContinue() throws InvalidQuestionTypeLayoutException {
        int dueChallengeNumber;

            //delivers int value, to decide which Activity has to be started
            dueChallengeNumber = otherDueChallenges();

            //it depends on the layoutType of the next challenge, which activity is to be started next
            switch (dueChallengeNumber) {
                //no other challenge is due
                case 0:
                    Navigation.startActivityFinalEndOfChallenges(mData.getActivity(), mData.getmChosenUser(), mData.getmChosenFile());
                    break;
                case 1: //a challenge of type ChallengeFreeAnswer is due
                    //set the next challenge ID by adding 1; this is required to start the correct "next" activity
                    mData.incrementChallengeIdByOne();
                    Navigation.startActivityChallengeFreeAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                    break;
                case 2: //a challenge of type ChallengeImagineAnser is due
                    //set the next challenge ID by adding 1; this is required to start the correct "next" activity
                    mData.incrementChallengeIdByOne();
                    Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                    break;
                case 3: //a challenge of type ChallengeMultipleChoice is due
                    //set the next challenge ID by adding 1; this is required to start the correct "next" activity
                    mData.incrementChallengeIdByOne();
                    Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                    break;
                default:
                    throw new InvalidQuestionTypeLayoutException("FeedbackChallengeRest::ApplicationLogic::onButtonContinue");
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

    //Methode delivers int value, whether there are other Challenges due or not
    //value: 0 --> no other challenge is due, Type FinalEndOfChallenges can be started
    //value: 1 --> another challenge is due, Type ChallengeFreeAnswer can be started
    //value: 2 --> another challenge is due, Type ChallengeImagineAnswer can be started
    //value: 3 --> another challenge is due, Type ChallengeMultipleChoice can be started
    //value: 4 --> Error
    public int otherDueChallenges() {
        int dueChallengeNumber = -1;
        int numberOfDueChallengesOfUserInFile;
        int currentChallengeId;
        int nextChallengeId;

        numberOfDueChallengesOfUserInFile = mData.getmDueChallengesOfUserInFile().getSize();
        currentChallengeId = mData.getmCurrentChallengeId();

        //check if there are further challenges to be started
        if (numberOfDueChallengesOfUserInFile > (currentChallengeId + 1)) {

            //compute the type of the next challenge for the switch-statement
            nextChallengeId = currentChallengeId + 1;
            dueChallengeNumber = mData.getmDueChallengesOfUserInFile().getChallenge(nextChallengeId).getmQuestionTypeLayout();
        }
        else {
            dueChallengeNumber = 0;
        }

        return dueChallengeNumber;
    }

    //Error-Handling for the method which computes the nex activity-layout
    public void errorToastFalseLayout() {
        Toast.makeText(mActivity, "Unerwartetes layout", Toast.LENGTH_SHORT).show();
    }
}

