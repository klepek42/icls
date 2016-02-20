package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeFreeAnswer;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Jonas Krabs
 */
public class Gui {

    private TextView mTextFieldQuestion;
    private EditText mGivenAnswer;
    private Button mButtonLogout;
    private Button mButtonConfirmFreeAnswer;


    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_challenge_free_answer);
        mTextFieldQuestion = (TextView) activity.findViewById(R.id.textFieldQuestion);
        mGivenAnswer = (EditText) activity.findViewById(R.id.givenAnswer);
        mButtonLogout = (Button) activity.findViewById(R.id.buttonLogout);
        mButtonConfirmFreeAnswer = (Button) activity.findViewById(R.id.buttonConfirmFreeAnswer);
    }

    public void setQuestionText (String text){
        mTextFieldQuestion.setText(text);
    }

    public EditText getmGivenAnswer() {
        return mGivenAnswer;
    }

    public Button getmButtonLogout() {
        return mButtonLogout;
    }

    public Button getmButtonConfirmFreeAnswer() {
        return mButtonConfirmFreeAnswer;
    }
}
