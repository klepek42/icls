package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.app.Activity;

import fhdw.mfwx413.flyingdutchmen.icls.data.Challenge;
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
        correctAnswer = mData.getmDueChallengesOfUserInFile().getChallenge(mData.getmCurrentChallengeId()).getmCorrectAnswerString();

        //set feedback field with the real correct answer
        mGui.setFeedbackTextCorrectAnswer(correctAnswer);

        //if the answer was correct
        if (mData.ismIsAnswerCorrect() == true) {
            mGui.setFeedbackText("Die Antwort war korrekt");
            mGui.setFeedbackTextUpDownGrade("Die Frage wird heraufgestuft");
        }
        else {
            //if the answer was false
            mGui.setFeedbackText("Die Antwort war falsch");
            mGui.setFeedbackTextUpDownGrade("Die Frage wird wieder heruntergestuft");
        }

    }


    //method that is invoked if the continue button is clicked
    public void onButtonContinue(){

        //call the next Activity and send the required data
        //Navigation depends whether there is another question or not
        //either final screen or next Challenge
        //Navigation.start [...]
    }

    public void onButtonAbortClicked() {
    }

}
