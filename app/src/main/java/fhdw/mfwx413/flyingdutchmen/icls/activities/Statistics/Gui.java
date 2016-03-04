package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class Gui {

    // Member variables
    private TextView mTextFieldFileNameText;
    private TextView mTextFieldNumberAllChallenges;
    private TextView mTextFieldNumberDueChallenges;
    private TextView mTextFieldNumberOfClass1;
    private TextView mTextFieldNumberOfClass2;
    private TextView mTextFieldNumberOfClass3;
    private TextView mTextFieldNumberOfClass4;
    private TextView mTextFieldNumberOfClass5;
    private TextView mTextFieldNumberOfClass6;
    private Button mButtonBackToChooseFile;
    private Button mButtonStartLearning;

    // Constructor
    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_statistics);
        mTextFieldFileNameText = (TextView) activity.findViewById(R.id.textFieldFileNameText);
        mTextFieldNumberAllChallenges = (TextView) activity.findViewById(R.id.textFieldNumberAllChallenges);
        mTextFieldNumberDueChallenges = (TextView) activity.findViewById(R.id.textFieldNumberDueChallenges);
        mTextFieldNumberOfClass1 = (TextView) activity.findViewById(R.id.textFieldNumberOfClass1);
        mTextFieldNumberOfClass2 = (TextView) activity.findViewById(R.id.textFieldNumberOfClass2);
        mTextFieldNumberOfClass3 = (TextView) activity.findViewById(R.id.textFieldNumberOfClass3);
        mTextFieldNumberOfClass4 = (TextView) activity.findViewById(R.id.textFieldNumberOfClass4);
        mTextFieldNumberOfClass5 = (TextView) activity.findViewById(R.id.textFieldNumberOfClass5);
        mTextFieldNumberOfClass6 = (TextView) activity.findViewById(R.id.textFieldNumberOfClass6);
        mButtonBackToChooseFile = (Button) activity.findViewById(R.id.buttonBackToChooseFile);
        mButtonStartLearning = (Button) activity.findViewById(R.id.buttonStartLearning);
    }

    // Fill this TextView with the name of the current file
    public void setTextFieldFileNameText(String text) {
        mTextFieldFileNameText.setText(text);
    }

    // Fill this TextView with the number of all challenges of the current file
    public void setTextFieldNumberAllChallenges(String text) {
        mTextFieldNumberAllChallenges.setText(text);
    }

    // Fill this TextView with the number of due challenges in the current file
    public void setTextFieldNumberDueChallenges(String text) {
        mTextFieldNumberDueChallenges.setText(text);
    }

    // Fill this TextView with the number of challenges being in class 1 right now
    public void setTextFieldNumberOfClass1(String text) {
        mTextFieldNumberOfClass1.setText(text);
    }

    // Fill this TextView with the number of challenges being in class 2 right now
    public void setTextFieldNumberOfClass2(String text) {
        mTextFieldNumberOfClass2.setText(text);
    }

    // Fill this TextView with the number of challenges being in class 3 right now
    public void setTextFieldNumberOfClass3(String text) {
        mTextFieldNumberOfClass3.setText(text);
    }

    // Fill this TextView with the number of challenges being in class 4 right now
    public void setTextFieldNumberOfClass4(String text) {
        mTextFieldNumberOfClass4.setText(text);
    }

    // Fill this TextView with the number of challenges being in class 5 right now
    public void setTextFieldNumberOfClass5(String text) {
        mTextFieldNumberOfClass5.setText(text);
    }

    // Fill this TextView with the number of challenges being in class 6 right now
    public void setTextFieldNumberOfClass6(String text) {
        mTextFieldNumberOfClass6.setText(text);
    }

    // Get the id of the choose file button
    public Button getButtonBackToChooseFile() {
        return mButtonBackToChooseFile;
    }

    // Get the id of the start learning button
    public Button getButtonStartLearning() {
        return mButtonStartLearning;
    }

}
