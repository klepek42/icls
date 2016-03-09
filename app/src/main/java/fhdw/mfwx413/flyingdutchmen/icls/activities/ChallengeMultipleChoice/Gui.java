package fhdw.mfwx413.flyingdutchmen.icls.activities.ChallengeMultipleChoice;

import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Daniel zur Linden
 */
public class Gui {

    private TextView mTextFieldQuestion;
    private CheckBox mCheckBoxAnswer1;
    private CheckBox mCheckBoxAnswer2;
    private CheckBox mCheckBoxAnswer3;

    private Button mButtonAbort;
    private Button mButtonConfirmAnswer;


    public Gui(Activity activity) {
        //set Gui elements
        activity.setContentView(R.layout.layout_challenge_multiple_choice);
        mTextFieldQuestion = (TextView) activity.findViewById(R.id.textFieldQuestion);
        mCheckBoxAnswer1 = (CheckBox) activity.findViewById(R.id.checkboxAnswer1);
        mCheckBoxAnswer2 = (CheckBox) activity.findViewById(R.id.checkboxAnswer2);
        mCheckBoxAnswer3 = (CheckBox) activity.findViewById(R.id.checkboxAnswer3);
        mButtonAbort = (Button) activity.findViewById(R.id.buttonAbort);
        mButtonConfirmAnswer = (Button) activity.findViewById(R.id.buttonConfirmAnswer);
    }

    //display questiontext
    public void setQuestionText(String text) {
        mTextFieldQuestion.setText(text);
    }

    public CheckBox getmCheckBoxAnswer1() {
        return mCheckBoxAnswer1;
    }

    public CheckBox getmCheckBoxAnswer2() {
        return mCheckBoxAnswer2;
    }

    public CheckBox getmCheckBoxAnswer3() {
        return mCheckBoxAnswer3;
    }


    public Button getmButtonAbort() {
        return mButtonAbort;
    }

    public Button getmButtonConfirmAnswer() {
        return mButtonConfirmAnswer;
    }
}
