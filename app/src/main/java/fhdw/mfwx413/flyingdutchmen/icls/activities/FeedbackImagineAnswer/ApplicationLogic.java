package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidQuestionTypeLayoutException;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.UserProgressNotFoundException;
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

        //set the string "Die korrekten Antworten sind" into the textview
        mGui.setTextViewWasAnswerCorrect();

        try {
            //delivers String with the correct answer(s)
            correctAnswer = mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmCorrectAnswerString();

            //set the real correct answer(s) into the feedback field
            mGui.setTextViewCorrectAnswer(correctAnswer);
        }
        //Error-Handling if there is a invalid correct answer type
        catch (InvalidCorrectAnswerTypeException e){
            Log.e("ICLS-ERROR", "FeedbackImagineAnswer::ApplicationLogic::initialUpdateGui ", e);
            Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
            Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
        }
    }


    //method that is invoked, if the button "buttonWasAnswerCorrect" is clicked
    public void onButtonWasAnswerCorrect (){
        boolean isAnswerCorrect = true;

        try {
            //the current user progress has to be updated (here it is a upgrade)
            updateUserProgress(isAnswerCorrect);

            //the old challenge ID is incremented by 1, so the correct "next" activity can be started and the correct information can be sent
            mData.incrementChallengeIdByOne();

            //checks whether there is a next activity that is to be started and starts the next activity with the correct layout type
            startNextActivity();
        }
        //Exception-Handling, if there was a problem in finding the user progress
        catch (UserProgressNotFoundException e) {
            Log.e("ICLS-LOG", "ChallengeFreeAnswer::ApplicationLogic::onButtonConfirmFreeAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }


    //method that is invoked, if the button "buttonWasAnswerWring" is clicked
    public void onButtonWasAnswerWrong (){
        boolean isAnswerCorrect = false;

        try {
            //the current user progress has to be updated (here it is a downgrade)
            updateUserProgress(isAnswerCorrect);

            //the old challenge ID is incremented by 1, so the correct "next" activity can be started and the correct information can be sent
            mData.incrementChallengeIdByOne();

            //checks whether there is a next activity that is to be started and starts the next activity with the correct layout type
            startNextActivity();
        }
        //Exception-Handling, if there was a problem in finding the user progress
        catch (UserProgressNotFoundException e){
            Log.e("ICLS-LOG", "ChallengeFreeAnswer::ApplicationLogic::onButtonConfirmFreeAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }

    //method that computes the next due activity and the correct layout type that belongs to it, then this activitiy is started
    public void startNextActivity() {
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
                Navigation.startActivityChallengeFreeAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                break;
            //a challenge of type ChallengeImagineAnser is due
            case 2:
                Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                break;
            //a challenge of type ChallengeMultipleChoice is due
            case 3:
                Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile(), mData.getmCurrentUserProgresses());
                break;
            //Exception-Handling, if there is a int-value in "dueChallengeNumber" that is not 0,1,2 or 3
            default:
                //Todo: Error-Handling has to be implemented - throw exception
                //Todo: FeedbackChallengeRest outsource this function as well?!
        }
    }


    //method returns an int-value, that gives information whether there is another due challenge and of which type it is
    private int otherDueChallenges() {
        int dueChallengeNumber = 4;
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


    //method, that refreshes and saves the user progress
    //that depends on whether the question was answered correctly or not
    private void updateUserProgress(boolean isAnswerCorrect) throws UserProgressNotFoundException{
        boolean userProgressFound = false;
        //run with the for-loop through the collection "CurrentUserProgresses", to find the correct one
        for (int i = 0; i < mData.getmCurrentUserProgresses().getSize(); i++){
            //check, if the challenge ID of the collection (of the current for-loop) equals the challenge ID of the current challenge
            if (mData.getmCurrentUserProgresses().getUserProgress(i).getmChallengeID() == mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID()){
                int actualTimeClass = mData.getmCurrentUserProgresses().getUserProgress(i).getmPeriodClass();
                userProgressFound = true;
                mData.getmCurrentUserProgresses().getUserProgress(i).setCurrentTimeStamp();
                //check if the given answer was correct or not
                if (isAnswerCorrect == true) {
                    //if the answer was correct, do the following:
                    if (actualTimeClass < 5 ) {
                        //as long as the current time-class is lower than "5", it can be incremented by 1
                        mData.getmCurrentUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass + 1);
                    }
                }
                else {
                    //if the answer was false do the following:
                    if (actualTimeClass > 1 ) {
                        //as long as the current time-class is greater than "1", it can be decremented by 1
                        mData.getmCurrentUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass - 1);
                    }
                }
                //Save the current user progress in the user progress database
                UserProgressDatabase.writeSpecificUserProgresses(mData.getmCurrentUserProgresses(), mData.getmChosenUser().getName(), mActivity);
                break;
            }
        }
        //Exception-Handling, if there was a problem in finding the correct user progress, that belongs to this user
        if (userProgressFound == false){
            throw new UserProgressNotFoundException("ChallengeFreeAnswer::ApplicationLogic::updateUserProgress:"
                    + " CurrentUserName: " + mData.getmChosenUser().getName()
                    + "ChallengeID:" + mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID());
        }
    }


    //method that opens a toast for a few seconds on the screen
    public void showErrorUnexpectedError(){
        Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
    }

    //Todo: Implement method "errorToastFalseLayout" as well?! (--> FeedbackChallengeRest:ApplicationLogic)
}