package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class Gui {
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

    public TextView getmTextFieldFileNameText() {
        return mTextFieldFileNameText;
    }

    public void setmTextFieldFileNameText(String text) {
        mTextFieldFileNameText.setText(text);
    }

    public TextView getmTextFieldNumberAllChallenges() {
        return mTextFieldNumberAllChallenges;
    }

    public void setmTextFieldNumberAllChallenges(String text) {
        mTextFieldNumberAllChallenges.setText(text);
    }

    public TextView getmTextFieldNumberDueChallenges() {
        return mTextFieldNumberDueChallenges;
    }

    public void setmTextFieldNumberDueChallenges(String text) {
        mTextFieldNumberDueChallenges.setText(text);
    }

    public TextView getmTextFieldNumberOfClass1() {
        return mTextFieldNumberOfClass1;
    }

    public void setmTextFieldNumberOfClass1(String text) {
        mTextFieldNumberOfClass1.setText(text);
    }

    public TextView getmTextFieldNumberOfClass2() {
        return mTextFieldNumberOfClass2;
    }

    public void setmTextFieldNumberOfClass2(String text) {
        mTextFieldNumberOfClass2.setText(text);
    }

    public TextView getmTextFieldNumberOfClass3() {
        return mTextFieldNumberOfClass3;
    }

    public void setmTextFieldNumberOfClass3(String text) {
        mTextFieldNumberOfClass3.setText(text);
    }

    public TextView getmTextFieldNumberOfClass4() {
        return mTextFieldNumberOfClass4;
    }

    public void setmTextFieldNumberOfClass4(String text) {
        mTextFieldNumberOfClass4.setText(text);
    }

    public TextView getmTextFieldNumberOfClass5() {
        return mTextFieldNumberOfClass5;
    }

    public void setmTextFieldNumberOfClass5(String text) {
        mTextFieldNumberOfClass5.setText(text);
    }

    public TextView getmTextFieldNumberOfClass6() {
        return mTextFieldNumberOfClass6;
    }

    public void setmTextFieldNumberOfClass6(String text) {
        mTextFieldNumberOfClass6.setText(text);
    }

    public Button getmButtonBackToChooseFile() {
        return mButtonBackToChooseFile;
    }

    public Button getmButtonStartLearning() {
        return mButtonStartLearning;
    }

}
