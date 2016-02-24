package fhdw.mfwx413.flyingdutchmen.icls.activities.FinalEndOfChallenges;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import fhdw.mfwx413.flyingdutchmen.icls.R;

/**
 * Responsibility: Luisa Leifer
 */
public class Gui {

    private TextView mTextFieldNoChallengesLeft;
    private Button mButtonBackToChooseFile;
    private Button mButtonStatistics;


    public Gui(Activity activity) {
        activity.setContentView(R.layout.layout_final_end_of_challenges);
        mTextFieldNoChallengesLeft = (TextView) activity.findViewById(R.id.textFieldNoChallengesLeft);
        mButtonBackToChooseFile = (Button) activity.findViewById(R.id.buttonBackToChooseFile);
        mButtonStatistics = (Button) activity.findViewById(R.id.buttonStatistics);
    }

    public Button getmButtonBackToChooseFile() {
        return mButtonBackToChooseFile;
    }

    public Button getmButtonStatistics() {
        return mButtonStatistics;
    }
}
