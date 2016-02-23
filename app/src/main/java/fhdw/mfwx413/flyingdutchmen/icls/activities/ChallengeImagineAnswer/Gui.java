package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class Gui {

    private TextView mTextFieldQuestion;
    private Button mButtonAbort;
    private Button mButtonConfirmThinkAnswer;

    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_challenge_imagine_answer);
        mTextFieldQuestion = (TextView) activity.findViewById(R.id.textFieldQuestion);
        mButtonAbort = (Button) activity.findViewById(R.id.buttonAbort);
        mButtonConfirmThinkAnswer = (Button) activity.findViewById(R.id.buttonConfirmThinkAnswer);
    }

    // Display a given text as the questions text
    public void setQuestionText (String text){
        mTextFieldQuestion.setText(text);
    }

    public Button getmButtonAbort() {
        return mButtonAbort;
    }

    public Button getmButtonConfirmThinkAnswer() {
        return mButtonConfirmThinkAnswer;
    }

}