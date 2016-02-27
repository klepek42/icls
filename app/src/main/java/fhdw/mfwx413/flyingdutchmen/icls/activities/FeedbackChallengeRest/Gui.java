package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackChallengeRest;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Pascal Heß
 */

public class Gui {

    private TextView mTextViewFeedbackText;
    private TextView mTextViewCorrectAnswer;
    private TextView mTextViewUpDownGrade;
    private Button mButtonContinue;
    private Button mButtonAbort;

    public Gui(Activity activity) {
        //set Gui elements
        activity.setContentView(R.layout.layout_feedback_challenge_rest);
        mTextViewFeedbackText = (TextView) activity.findViewById(R.id.textFieldFeedbackText);
        mTextViewCorrectAnswer = (TextView) activity.findViewById(R.id.textFieldCorrectAnswer);
        mTextViewUpDownGrade = (TextView) activity.findViewById(R.id.textFieldChallengeUpDownGrade);
        mButtonContinue = (Button) activity.findViewById(R.id.buttonContinue);
        mButtonAbort = (Button) activity.findViewById(R.id.buttonAbort);
    }

    // display the feedbacktext (correct or false answer)
    public void setFeedbackText(String text) {
        mTextViewFeedbackText.setText(text);
    }

    // display the correct answer, that is saved in the challenge
    public void setFeedbackTextCorrectAnswer(String text) {
        String correctAnswerIs = "Richtige Antwort: ";
        correctAnswerIs = correctAnswerIs.concat(text);
        mTextViewCorrectAnswer.setText(correctAnswerIs);
    }

    // display whether the question was down- or upgraded
    public void setFeedbackTextUpDownGrade(String text) {
        mTextViewUpDownGrade.setText(text);
    }

    public View getmButtonAbort() {
        return mButtonAbort;
    }

    public View getmButtonContinue() {
        return mButtonContinue;
    }
}
