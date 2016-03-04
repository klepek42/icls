package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeImagineAnswer;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class Gui {

    // Member variables
    private TextView mTextFieldQuestion;
    private Button mButtonAbort;
    private Button mButtonConfirmThinkAnswer;

    // Constructor
    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_challenge_imagine_answer);
        mTextFieldQuestion = (TextView) activity.findViewById(R.id.textFieldQuestion);
        mButtonAbort = (Button) activity.findViewById(R.id.buttonAbort);
        mButtonConfirmThinkAnswer = (Button) activity.findViewById(R.id.buttonConfirmThinkAnswer);
    }

    // Display the given text as the questions text
    public void setQuestionText (String text){
        mTextFieldQuestion.setText(text);
    }

    // Get the id of the abort button
    public Button getButtonAbort() {
        return mButtonAbort;
    }

    // Get the id of the confirmation button
    public Button getButtonConfirmThinkAnswer() {
        return mButtonConfirmThinkAnswer;
    }

}