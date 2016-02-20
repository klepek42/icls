package fhdw.mfwx413.flyingdutchmen.icls.activities.Statistics;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Edgar Klepek
 */
public class Gui {
    private TextView mTextFieldFileName;
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
        mTextFieldFileName = (TextView) activity.findViewById(R.id.textFieldFileName);
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

    public Button getmButtonBackToChooseFile() {
        return mButtonBackToChooseFile;
    }

    public Button getmButtonStartLearning() {
        return mButtonStartLearning;
    }

}
