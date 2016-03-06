package fhdw.mfwx413.flyingdutchmen.icls.activities.FeedbackImagineAnswer;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Pascal Heß
 */
public class Gui {

    private TextView mTextViewCorrectAnswer;
    private TextView mTextViewWasAnswerCorrect;
    private Button mButtonWasAnswerCorrect;
    private Button mButtonWasAnswerWrong;

    public Gui(Activity activity) {
        //set Gui elements
        activity.setContentView(R.layout.layout_feedback_imagine_answer);
        mTextViewCorrectAnswer = (TextView) activity.findViewById(R.id.textFieldCorrectAnswer);
        mTextViewWasAnswerCorrect = (TextView) activity.findViewById(R.id.textFieldWasAnswerCorrect);
        mButtonWasAnswerCorrect = (Button) activity.findViewById(R.id.buttonWasAnswerCorrect);
        mButtonWasAnswerWrong = (Button) activity.findViewById(R.id.buttonWasAnswerWrong);
    }

    public void setTextViewWasAnswerCorrect() {
        mButtonWasAnswerCorrect.setText("War ihre Antwort dabei und richtig?");
    }

    //display the correct answers, that are saved in the challenge
    public void setTextViewCorrectAnswer(String feedbackTextCorrectAnswer) {
        mTextViewCorrectAnswer.setText(feedbackTextCorrectAnswer);
    }

    public Button getmButtonWasAnswerWrong() {
        return mButtonWasAnswerWrong;
    }

    public Button getmButtonWasAnswerCorrect() {
        return mButtonWasAnswerCorrect;
    }
}
