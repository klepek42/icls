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
    private Button mButtonAbort;
    private Button mButtonConfirmFreeAnswer;


    public Gui(Activity activity) {
        //set Gui elements
        activity.setContentView(R.layout.layout_challenge_free_answer);
        mTextFieldQuestion = (TextView) activity.findViewById(R.id.textFieldQuestion);
        mGivenAnswer = (EditText) activity.findViewById(R.id.givenAnswer);
        mButtonAbort = (Button) activity.findViewById(R.id.buttonAbort);
        mButtonConfirmFreeAnswer = (Button) activity.findViewById(R.id.buttonConfirmFreeAnswer);
    }

    //display questiontext
    public void setQuestionText (String text){
        mTextFieldQuestion.setText(text);
    }

    public EditText getmGivenAnswer() {
        return mGivenAnswer;
    }

    public Button getmButtonAbort() {
        return mButtonAbort;
    }

    public Button getmButtonConfirmFreeAnswer() {
        return mButtonConfirmFreeAnswer;
    }
}
