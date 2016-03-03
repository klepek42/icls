package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.data.UserProgressDatabase;
import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;
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

        //set the text "Die korrekten Antworten sind" in the textview
        mGui.setTextViewWasAnswerCorrect();

        //delivers String with the correct answer(s)
        try {
            correctAnswer = mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmCorrectAnswerString();

            //set feedback field with the real correct answer
            mGui.setTextViewCorrectAnswer(correctAnswer);
        }
        catch (InvalidCorrectAnswerTypeException e){
            Log.e("ICLS-ERROR", "FeedbackImagineAnswer::ApplicationLogic::initialUpdateGui ", e);
            Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
            Navigation.startActivityChooseFile(mData.getActivity(), mData.getmChosenUser());
        }
    }

    public void onButtonWasAnswerCorrect (){
        boolean isAnswerCorrect = true;

        try {
            //User progress has to be updated (here it is a upgrade)
            updateUserProgress(isAnswerCorrect);

            //set the next challenge ID by adding 1; this is required to start the correct "next" activity
            mData.incrementChallengeIdByOne();

            //start the next activity
            startNextActivity();
        }
        catch (UserProgressNotFoundException e) {
            Log.e("ICLS-LOG", "ChallengeFreeAnswer::ApplicationLogic::onButtonConfirmFreeAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }

    public void onButtonWasAnswerWrong (){
        boolean isAnswerCorrect = false;

        try {
            //User progress has to be updated (here it is a downgrade)
            updateUserProgress(isAnswerCorrect);

            //set the next challenge ID by adding 1; this is required to start the correct "next" activity
            mData.incrementChallengeIdByOne();

            //start the next activity
            startNextActivity();
        }
        catch (UserProgressNotFoundException e){
            Log.e("ICLS-LOG", "ChallengeFreeAnswer::ApplicationLogic::onButtonConfirmFreeAnswerClicked: ", e);
            showErrorUnexpectedError();
            Navigation.startActivityStartMenu(mActivity);
        }
    }

    public void startNextActivity() {
        int dueChallengeNumber;

        //delivers int value, to decide which Activity has to be started
        dueChallengeNumber = otherDueChallenges();

        //it depends on the layoutType of the next challenge, which activity is to be started next
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
            //Error handling is to be implemented here
            case 4:
                Log.wtf("Fehler bei Errechnung des nächsten Challengetyps", "Error");
                break;
        }
    }

    //Methode delivers int value, whether there are other Challenges due or not
    //value: 0 --> no other challenge is due, Type FinalEndOfChallenges can be started
    //value: 1 --> another challenge is due, Type ChallengeFreeAnswer can be started
    //value: 2 --> another challenge is due, Type ChallengeImagineAnswer can be started
    //value: 3 --> another challenge is due, Type ChallengeMultipleChoice can be started
    //value: 4 --> Error
    private int otherDueChallenges() {
        int dueChallengeNumber = 4;
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

    //method, that saves the user progress (whether the question was answered correctly or not)
    private void updateUserProgress(boolean isAnswerCorrect) throws UserProgressNotFoundException{
        boolean userProgressFound = false;
        for (int i = 0; i < mData.getmCurrentUserProgresses().getSize(); i++){
            if (mData.getmCurrentUserProgresses().getUserProgress(i).getmChallengeID() == mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID()){
                int actualTimeClass = mData.getmCurrentUserProgresses().getUserProgress(i).getmPeriodClass();
                userProgressFound = true;
                mData.getmCurrentUserProgresses().getUserProgress(i).setCurrentTimeStamp();
                if (isAnswerCorrect == true) {
                    if (actualTimeClass < 5 ) {
                        mData.getmCurrentUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass + 1);
                    }
                }
                else {
                    if (actualTimeClass > 1 ) {
                        mData.getmCurrentUserProgresses().getUserProgress(i).setmPeriodClass(actualTimeClass - 1);
                    }
                }
                UserProgressDatabase.writeSpecificUserProgresses(mData.getmCurrentUserProgresses(), mData.getmChosenUser().getName(), mActivity);
                break;
            }
        }
        if (userProgressFound == false){
            throw new UserProgressNotFoundException("ChallengeFreeAnswer::ApplicationLogic::updateUserProgress:"
                    + " CurrentUserName: " + mData.getmChosenUser().getName()
                    + "ChallengeID:" + mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmID());
        }
    }

    public void showErrorUnexpectedError(){
        Toast.makeText(mActivity, "Unerwarteter Fehler", Toast.LENGTH_SHORT).show();
    }
}