package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import fhdw.mfwx413.flyingdutchmen.icls.exceptions.InvalidCorrectAnswerTypeException;
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
        startNextActivity();
        //Todo Pascal: Question has to be upgraded
    }

    public void onButtonWasAnswerWrong (){
        startNextActivity();
        //Todo Pascal: Question has to be downgraded
    }

    public void startNextActivity() {
        int dueChallengeNumber;

        //delivers int value, to decide which Activity has to be started
        dueChallengeNumber = otherDueChallenges();

        //it depends on the layoutType of the next challenge, which activity is to be started next
        switch (dueChallengeNumber) {
            //no other challenge is due
            case 0:
                Navigation.startActivityFinalEndOfChallenges(mData.getActivity());
                //a challenge of type ChallengeFreeAnswer is due
            case 1:
                Navigation.startActivityChallengeFreeAnswer(mData.getActivity());
                break;
            //a challenge of type ChallengeImagineAnser is due
            case 2:
                Navigation.startActivityChallengeImagineAnswer(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile());
                break;
            //a challenge of type ChallengeMultipleChoice is due
            case 3:
                Navigation.startActivityChallengeMultipleChoice(mData.getActivity(), mData.getmDueChallengesOfUserInFile(), mData.getmCurrentChallengeId(), mData.getmChosenUser(), mData.getmChosenFile());
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
        if (numberOfDueChallengesOfUserInFile > currentChallengeId) {

            //compute the type of the next challenge for the switch-statement
            nextChallengeId = currentChallengeId + 1;
            dueChallengeNumber = mData.getmDueChallengesOfUserInFile().getChallenge(nextChallengeId).getmQuestionTypeLayout();
        }
        else {
            dueChallengeNumber = 0;
        }

        return dueChallengeNumber;
    }
}